//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin.v2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("results")
    @Expose
    private Results_ results;

    public Results() {
    }

    public Results_ getResults() {
        return this.results;
    }

    public void setResults(Results_ var1) {
        this.results = var1;
    }
}
