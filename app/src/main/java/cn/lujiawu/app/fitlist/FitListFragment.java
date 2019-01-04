package cn.lujiawu.app.fitlist;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import cn.lujiawu.app.R;
import cn.lujiawu.app.event.EventHandler;
import cn.lujiawu.app.settings.SettingManager;
import cn.lujiawu.app.settings.SettingVO;
import cn.lujiawu.garmin2suunto.SyncService;
import cn.lujiawu.garmin2suunto.fitlist.FitListService;
import dmax.dialog.SpotsDialog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FitListFragment extends Fragment {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private FitRecyclerViewAdapter mFitRecyclerViewAdapter;
    private FitListService mFitListService;
    private SyncService mSyncService;
    private int mPage = 0;
    private int limit = 20;

    private AlertDialog loadingDialog;
    public EventHandler eventHandler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.content_fit_list, container, false);

        Toolbar toolbar = (Toolbar) fragmentView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        loadingDialog = new SpotsDialog.Builder().setContext(container.getContext()).build();
        return fragmentView;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                startup();
            }
        });
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        @SuppressLint("WrongConstant") LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        // 设置布局管理器
        mRecyclerView.setLayoutManager(linearLayoutManager);
        // 确定item的大小是固定的，设置为true，recyclerview可以得到优化
        mRecyclerView.setHasFixedSize(true);
        // 添加分割线
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        // 设置动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFitRecyclerViewAdapter = new FitRecyclerViewAdapter(new ArrayList());
        mRecyclerView.setAdapter(mFitRecyclerViewAdapter);

        mFitListService = new FitListService();
        mSyncService = new SyncService();

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int lastVisibleItem;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && mFitRecyclerViewAdapter.isFootPosition(lastVisibleItem)) {
                    mFitRecyclerViewAdapter.changeMoreStatus(FitRecyclerViewAdapter.LOADING_MORE);
                    loadNextPage();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });

        startup();
    }

    public void startup() {

        mPage = 0;
        mSwipeRefreshLayout.setRefreshing(false);
        loadingDialog.setMessage("loading");
        loadingDialog.show();
        mFitListService.getActivityPaged(mPage, limit)
                .subscribeOn(Schedulers.io())
                .map(FitConverter::convert)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    mFitRecyclerViewAdapter.resetDate(list);
                    mSwipeRefreshLayout.setRefreshing(false);
                    loadingDialog.hide();
                }, this::handleException);

    }

    private void loadNextPage() {
        mPage++;
        mFitListService.getActivityPaged(mPage * limit, limit)
                .subscribeOn(Schedulers.io())
                .map(FitConverter::convert)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    if (list.isEmpty()) {
                        Toast.makeText(mSwipeRefreshLayout.getContext(), "没有更多的数据了", Toast.LENGTH_LONG).show();
                    } else {
                        mFitRecyclerViewAdapter.appendDate(list);
                    }
                    mSwipeRefreshLayout.setRefreshing(false);
                    loadingDialog.hide();
                }, this::handleException);
    }

    @NonNull
    private void handleException(Throwable e) {
        Log.e("net", e.getMessage(), e);
        mSwipeRefreshLayout.setRefreshing(false);
        loadingDialog.hide();
        Toast.makeText(mSwipeRefreshLayout.getContext(), "网络请求失败 " + e.getMessage(), Toast.LENGTH_LONG).show();

        openSettingView();

    }

    private boolean openSettingView() {
        SettingVO setting = SettingManager.getInstance();
        if (StringUtils.isAnyEmpty(setting.garminUserName, setting.garminPassword)) {
            eventHandler.openSettingView();
            return true;
        }
        return false;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int position = item.getItemId();
        FitVO fitVO = mFitRecyclerViewAdapter.getFitVO(position);
        switch (item.getOrder()) {
            case 1:
                String url = "https://connect.garmin.cn/modern/activity/" + fitVO.getActivityId();
                eventHandler.openWebView(url);
                break;
            case 2:
                String url2 = "http://www.movescount.com/moves/move" + fitVO.getMoveId();
                eventHandler.openWebView(url2);
                break;
            case 3:
                loadingDialog.show();
                mSyncService.getMoveFromGarminAct(fitVO.getActivityId())
                        .flatMap(mSyncService::saveMove)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(moveResult -> {
                            fitVO.setMoveId(moveResult.getMoveID());
                            mFitRecyclerViewAdapter.notifyDataSetChanged();
                            loadingDialog.hide();
                        }, e -> {
                            this.handleException(e);
                        });
                //start to sync
                //update current vo
                //reload url
                break;
        }
        return true;
    }
}
