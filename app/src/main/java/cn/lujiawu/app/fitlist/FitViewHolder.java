package cn.lujiawu.app.fitlist;

import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
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
    ImageView statusView;
    TextView titleView;
    ImageView typeView;

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
        typeView = itemView.findViewById(R.id.fit_type);

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
            statusView.setVisibility(View.INVISIBLE);
        } else {
            statusView.setVisibility(View.VISIBLE);
        }
        speedView.setText(fitVO.getSpeed());
        titleView.setText(fitVO.getTitle());

        switch (fitVO.getType()) {
            case TREADMILL:
                typeView.setImageResource(R.drawable.data_list_icon_treadmill);
                break;
            case CYCLING:
                typeView.setImageResource(R.drawable.data_list_icon_cycle);
                break;
            default:
                typeView.setImageResource(R.drawable.data_list_icon_run);
        }

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