//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimeZoneUnitDTO {
    @SerializedName("unitId")
    @Expose
    private Integer unitId;
    @SerializedName("unitKey")
    @Expose
    private String unitKey;
    @SerializedName("factor")
    @Expose
    private Double factor;
    @SerializedName("timeZone")
    @Expose
    private String timeZone;

    public TimeZoneUnitDTO() {
    }

    public Integer getUnitId() {
        return this.unitId;
    }

    public void setUnitId(Integer var1) {
        this.unitId = var1;
    }

    public String getUnitKey() {
        return this.unitKey;
    }

    public void setUnitKey(String var1) {
        this.unitKey = var1;
    }

    public Double getFactor() {
        return this.factor;
    }

    public void setFactor(Double var1) {
        this.factor = var1;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String var1) {
        this.timeZone = var1;
    }
}
