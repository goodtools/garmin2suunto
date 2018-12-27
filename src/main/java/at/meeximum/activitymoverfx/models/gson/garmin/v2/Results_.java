//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin.v2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results_ {
    @SerializedName("activities")
    @Expose
    private List<Activity> activities = null;
    @SerializedName("search")
    @Expose
    private Search search;

    public Results_() {
    }

    public List<Activity> getActivities() {
        return this.activities;
    }

    public void setActivities(List<Activity> var1) {
        this.activities = var1;
    }

    public Search getSearch() {
        return this.search;
    }

    public void setSearch(Search var1) {
        this.search = var1;
    }
}
