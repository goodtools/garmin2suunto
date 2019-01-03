package cn.lujiawu.garmin2suunto.fitlist;

import cn.lujiawu.garmin2suunto.garmin.api.ActivityItem;
import cn.lujiawu.garmin2suunto.move.api.MoveItem;
import lombok.Data;

@Data
public class FitItem {
    private ActivityItem activity;
    private MoveItem move;
}
