package cn.lujiawu.app.fitlist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import cn.lujiawu.app.R;
import cn.lujiawu.garmin2suunto.fitlist.FitListService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FitListFragment extends Fragment {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private FitRecyclerViewAdapter mFitRecyclerViewAdapter;
    private FitListService mFitListService;
    private int mPage = 0;
    private int limit = 20;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.content_fit_list, container, false);

        Toolbar toolbar = (Toolbar) fragmentView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
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

        startup();
    }

    private void startup() {
        mPage = 0;
        mSwipeRefreshLayout.setRefreshing(true);
        mFitListService.getActivityPaged(mPage, limit)
                .subscribeOn(Schedulers.io())
                .map(FitConverter::convert)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    mFitRecyclerViewAdapter.resetDate(list);
                    mSwipeRefreshLayout.setRefreshing(false);
                }, this::handleException);

    }

    private void loadNextPage() {
        mFitListService.getActivityPaged(++mPage, limit)
                .subscribeOn(Schedulers.io())
                .map(FitConverter::convert)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    mFitRecyclerViewAdapter.appendDate(list);
                    mSwipeRefreshLayout.setRefreshing(false);
                }, this::handleException);
    }

    @NonNull
    private void handleException(Throwable e) {
        Log.e("net", e.getMessage(), e);
        mSwipeRefreshLayout.setRefreshing(false);
        Toast.makeText(mSwipeRefreshLayout.getContext(), "网络请求失败 " + e.getMessage(), Toast.LENGTH_LONG).show();
    }

}
