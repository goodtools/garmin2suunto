package cn.lujiawu.garmin2suunto.garmin;

import at.meeximum.activitymoverfx.models.gson.garmin.Activity;
import at.meeximum.activitymoverfx.models.json.garmin.GActivityDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActivityWrapper {

    private String id;

    private Activity activity;

    private GActivityDetails details;

    public ActivityWrapper(String id) {
        this.id = id;
    }
}
