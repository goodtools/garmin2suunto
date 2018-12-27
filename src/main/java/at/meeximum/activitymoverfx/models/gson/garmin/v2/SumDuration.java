//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin.v2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SumDuration {
    @SerializedName("display")
    @Expose
    private String display;
    @SerializedName("minutesSeconds")
    @Expose
    private String minutesSeconds;

    public SumDuration() {
    }

    public String getDisplay() {
        return this.display;
    }

    public void setDisplay(String var1) {
        this.display = var1;
    }

    public String getMinutesSeconds() {
        return this.minutesSeconds;
    }

    public void setMinutesSeconds(String var1) {
        this.minutesSeconds = var1;
    }
}
