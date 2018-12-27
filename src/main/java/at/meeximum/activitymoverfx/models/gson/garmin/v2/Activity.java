//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin.v2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Activity {
    @SerializedName("activity")
    @Expose
    private Activity_ activity;

    public Activity() {
    }

    public Activity_ getActivity() {
        return this.activity;
    }

    public void setActivity(Activity_ var1) {
        this.activity = var1;
    }
}
