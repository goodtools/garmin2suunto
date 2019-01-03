package cn.lujiawu.app.fitlist;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import cn.lujiawu.app.R;

public class FitViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

    private FitVO fitVO;
    private int position;

    TextView cadenceView;
    TextView caloriesView;
    TextView distanceView;
    TextView durationView;
    TextView hrView;
    TextView speedView;
    TextView statusView;
    TextView titleView;

    public FitViewHolder(View itemView) {
        super(itemView);
        itemView.setOnCreateContextMenuListener(this);

        cadenceView = itemView.findViewById(R.id.fit_cadence);
        caloriesView = itemView.findViewById(R.id.fit_calories);
        distanceView = itemView.findViewById(R.id.fit_distance);
        durationView = itemView.findViewById(R.id.fit_duration);
        hrView = itemView.findViewById(R.id.fit_hr);
        speedView = itemView.findViewById(R.id.fit_speed);
        statusView = itemView.findViewById(R.id.fit_status);
        titleView = itemView.findViewById(R.id.fit_title);

    }

    public void setFitVO(FitVO fitVO, int position) {
        this.fitVO = fitVO;
        //TODO here
        cadenceView.setText(fitVO.getCadence());
        caloriesView.setText(fitVO.getCalories());
        distanceView.setText(fitVO.getDistance());
        durationView.setText(fitVO.getDuration());
        hrView.setText(fitVO.getHr());
        if (TextUtils.isEmpty(fitVO.getMoveId())) {
            statusView.setText("待同步");
            statusView.setTextColor(Color.RED);
        }else {
            statusView.setText("已同步");
            statusView.setTextColor(Color.GREEN);
        }
        speedView.setText(fitVO.getSpeed());
        titleView.setText(fitVO.getTitle());

        this.position = position;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        menu.add(Menu.NONE, position, 1, "打开garmin");
        if (TextUtils.isEmpty(fitVO.getMoveId())) {
            menu.add(Menu.NONE, position, 3, "同步move");
        } else {
            menu.add(Menu.NONE, position, 2, "打开move");
        }
    }

    public static class FootViewHolder extends FitViewHolder {

        private TextView foot_view_item_tv;

        public FootViewHolder(View itemView) {
            super(itemView);
            foot_view_item_tv = (TextView) itemView.findViewById(R.id.foot_view_item_tv);
        }

    }


}