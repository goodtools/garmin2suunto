//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin.v2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Query {
    @SerializedName("filters")
    @Expose
    private Filters filters;
    @SerializedName("sortOrder")
    @Expose
    private String sortOrder;
    @SerializedName("sortField")
    @Expose
    private String sortField;
    @SerializedName("activityStart")
    @Expose
    private String activityStart;
    @SerializedName("activitiesPerPage")
    @Expose
    private String activitiesPerPage;
    @SerializedName("explore")
    @Expose
    private String explore;
    @SerializedName("ignoreUntitled")
    @Expose
    private String ignoreUntitled;
    @SerializedName("ignoreNonGPS")
    @Expose
    private String ignoreNonGPS;

    public Query() {
    }

    public Filters getFilters() {
        return this.filters;
    }

    public void setFilters(Filters var1) {
        this.filters = var1;
    }

    public String getSortOrder() {
        return this.sortOrder;
    }

    public void setSortOrder(String var1) {
        this.sortOrder = var1;
    }

    public String getSortField() {
        return this.sortField;
    }

    public void setSortField(String var1) {
        this.sortField = var1;
    }

    public String getActivityStart() {
        return this.activityStart;
    }

    public void setActivityStart(String var1) {
        this.activityStart = var1;
    }

    public String getActivitiesPerPage() {
        return this.activitiesPerPage;
    }

    public void setActivitiesPerPage(String var1) {
        this.activitiesPerPage = var1;
    }

    public String getExplore() {
        return this.explore;
    }

    public void setExplore(String var1) {
        this.explore = var1;
    }

    public String getIgnoreUntitled() {
        return this.ignoreUntitled;
    }

    public void setIgnoreUntitled(String var1) {
        this.ignoreUntitled = var1;
    }

    public String getIgnoreNonGPS() {
        return this.ignoreNonGPS;
    }

    public void setIgnoreNonGPS(String var1) {
        this.ignoreNonGPS = var1;
    }
}
