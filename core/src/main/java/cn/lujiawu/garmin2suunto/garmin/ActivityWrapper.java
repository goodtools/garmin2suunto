package cn.lujiawu.garmin2suunto.garmin;

import cn.lujiawu.garmin2suunto.garmin.api.Activity;
import cn.lujiawu.garmin2suunto.garmin.api.ActivitySplits;
import cn.lujiawu.garmin2suunto.garmin.api.ActivityDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActivityWrapper {

    private String id;

    private Activity activity;

    private ActivityDetail details;

    private ActivitySplits activitySplits;

    public ActivityWrapper(String id) {
        this.id = id;
    }
}
