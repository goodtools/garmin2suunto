package cn.lujiawu.garmin2suunto.garmin;

import at.meeximum.activitymoverfx.models.gson.garmin.Activity;
import at.meeximum.activitymoverfx.models.gson.garmin.Splits;
import at.meeximum.activitymoverfx.models.json.garmin.ActivityDetail;
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

    private Splits splits;

    public ActivityWrapper(String id) {
        this.id = id;
    }
}
