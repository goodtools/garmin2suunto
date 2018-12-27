//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChartAvailability {
    @SerializedName("showElevation")
    @Expose
    private Boolean showElevation;
    @SerializedName("showHeartRate")
    @Expose
    private Boolean showHeartRate;
    @SerializedName("showMovingSpeed")
    @Expose
    private Boolean showMovingSpeed;
    @SerializedName("showSpeed")
    @Expose
    private Boolean showSpeed;
    @SerializedName("showTimestamp")
    @Expose
    private Boolean showTimestamp;

    public ChartAvailability() {
    }

    public Boolean getShowElevation() {
        return this.showElevation;
    }

    public void setShowElevation(Boolean var1) {
        this.showElevation = var1;
    }

    public Boolean getShowHeartRate() {
        return this.showHeartRate;
    }

    public void setShowHeartRate(Boolean var1) {
        this.showHeartRate = var1;
    }

    public Boolean getShowMovingSpeed() {
        return this.showMovingSpeed;
    }

    public void setShowMovingSpeed(Boolean var1) {
        this.showMovingSpeed = var1;
    }

    public Boolean getShowSpeed() {
        return this.showSpeed;
    }

    public void setShowSpeed(Boolean var1) {
        this.showSpeed = var1;
    }

    public Boolean getShowTimestamp() {
        return this.showTimestamp;
    }

    public void setShowTimestamp(Boolean var1) {
        this.showTimestamp = var1;
    }
}
