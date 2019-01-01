package cn.lujiawu.app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class FitRecyclerViewAdapter
            extends RecyclerView.Adapter<FitViewHolder>{

        private List list;

        public FitRecyclerViewAdapter(List list) {
                this.list = list;
        }

        @NonNull
        @Override
        public FitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_item_fit_cardview, parent, false);
                return new FitViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull FitViewHolder holder, int position) {
//                holder.mItem = mValues.get(position);
//                holder.mTitleView.setText(holder.mItem.get(&quot;title&quot;));
//                holder.mSubTitleView.setText(holder.mItem.get(&quot;subtitle&quot;));
//                holder.mLogoView.setImageResource(Integer.parseInt(holder.mItem.get(&quot;image&quot;)));
//
//                holder.mView.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                                if (mPreviousHolder != null &amp;&amp; mPreviousHolder != holder)
//                                mPreviousHolder.setCollapse(false);
//
//                                holder.toggleCollapse();
//                                mPreviousHolder = holder;
//                        }
//                });
        }

        @Override
        public int getItemCount() {
                return list.size();
        }
}