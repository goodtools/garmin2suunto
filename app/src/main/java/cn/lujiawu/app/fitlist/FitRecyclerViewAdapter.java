package cn.lujiawu.app.fitlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.lujiawu.app.R;

public class FitRecyclerViewAdapter
        extends RecyclerView.Adapter<FitViewHolder> {

    private static final int TYPE_ITEM = 0;  //普通Item View
    private static final int TYPE_FOOTER = 1;  //顶部FootView

    private List<FitVO> list;

    public FitRecyclerViewAdapter(List<FitVO> list) {
        this.list = list;
    }

    public FitRecyclerViewAdapter() {
        this.list = new ArrayList<>();
    }

    @NonNull
    @Override
    public FitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_FOOTER) {
            View foot_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_fit_load_more, parent, false);
            //这边可以做一些属性设置，甚至事件监听绑定
            //view.setBackgroundColor(Color.RED);
            FitViewHolder.FootViewHolder footViewHolder = new FitViewHolder.FootViewHolder(foot_view);
            return footViewHolder;
        }

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_fit_cardview, parent, false);
        return new FitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FitViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_FOOTER){
            return;
        }
        FitVO fitVO = list.get(position);
        holder.setFitVO(fitVO);
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        // 最后一个item设置为footerView
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    public void resetDate(List<FitVO> FitVOs) {
        this.list = FitVOs;
        notifyDataSetChanged();
    }

    public void appendDate(List<FitVO> FitVOs) {
        this.list.addAll(FitVOs);
        notifyDataSetChanged();
    }


}