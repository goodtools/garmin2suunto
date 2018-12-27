//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.json.garmin;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GResults {
    @SerializedName("results")
    private GResults results;
    @SerializedName("activities")
    private List<GActivity> activities;
    @SerializedName("totalFound")
    private int totalFound;
    @SerializedName("currentPage")
    private int currentPage;
    @SerializedName("totalPages")
    private int totalPages;

    public GResults() {
    }

    public List<GActivity> getActivities() {
        return this.results.activities;
    }

    public void setActivities(List<GActivity> var1) {
        this.results.activities = var1;
    }

    public int getTotalFound() {
        return this.results.totalFound;
    }

    public void setTotalFound(int var1) {
        this.results.totalFound = var1;
    }

    public int getCurrentPage() {
        return this.results.currentPage;
    }

    public void setCurrentPage(int var1) {
        this.results.currentPage = var1;
    }

    public int getTotalPages() {
        return this.results.totalPages;
    }

    public void setTotalPages(int var1) {
        this.results.totalPages = var1;
    }
}
