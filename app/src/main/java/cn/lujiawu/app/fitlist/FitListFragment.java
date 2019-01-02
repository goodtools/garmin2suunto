package cn.lujiawu.app.fitlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.lujiawu.app.R;

public class FitListFragment extends Fragment {

    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerView mRecyclerView;

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

        startup();
    }

    private void startup() {

        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        mRecyclerView.setAdapter(new FitRecyclerViewAdapter(list));
        mSwipeRefreshLayout.setRefreshing(false);
    }


}
