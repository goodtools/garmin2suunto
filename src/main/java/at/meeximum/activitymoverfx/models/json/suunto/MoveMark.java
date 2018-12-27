//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.json.suunto;

import com.google.gson.annotations.SerializedName;

public class MoveMark {
    @SerializedName("DistanceFromPrevious")
    int distanceFromPrevious;
    @SerializedName("SplitTimeFromPrevious")
    Double splitTimeFromPrevious;
    @SerializedName("Type")
    int type;
    @SerializedName("Notes")
    String notes;

    public MoveMark() {
    }

    public void setDistanceFromPrevious(int var1) {
        this.distanceFromPrevious = var1;
    }

    public void setSplitTimeFromPrevious(Double var1) {
        this.splitTimeFromPrevious = var1;
    }

    public void setType(int var1) {
        this.type = var1;
    }

    public void setNotes(String var1) {
        this.notes = var1;
    }
}
