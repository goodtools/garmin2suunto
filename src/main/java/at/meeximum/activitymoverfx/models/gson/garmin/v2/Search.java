//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin.v2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Search {
    @SerializedName("query")
    @Expose
    private Query query;
    @SerializedName("currentPage")
    @Expose
    private String currentPage;
    @SerializedName("totalFound")
    @Expose
    private String totalFound;
    @SerializedName("totalPages")
    @Expose
    private String totalPages;

    public Search() {
    }

    public Query getQuery() {
        return this.query;
    }

    public void setQuery(Query var1) {
        this.query = var1;
    }

    public String getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(String var1) {
        this.currentPage = var1;
    }

    public String getTotalFound() {
        return this.totalFound;
    }

    public void setTotalFound(String var1) {
        this.totalFound = var1;
    }

    public String getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(String var1) {
        this.totalPages = var1;
    }
}
