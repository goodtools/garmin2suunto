//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin.v2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UploadDate {
    @SerializedName("display")
    @Expose
    private String display;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("withDay")
    @Expose
    private String withDay;
    @SerializedName("abbr")
    @Expose
    private String abbr;
    @SerializedName("millis")
    @Expose
    private String millis;

    public UploadDate() {
    }

    public String getDisplay() {
        return this.display;
    }

    public void setDisplay(String var1) {
        this.display = var1;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String var1) {
        this.value = var1;
    }

    public String getWithDay() {
        return this.withDay;
    }

    public void setWithDay(String var1) {
        this.withDay = var1;
    }

    public String getAbbr() {
        return this.abbr;
    }

    public void setAbbr(String var1) {
        this.abbr = var1;
    }

    public String getMillis() {
        return this.millis;
    }

    public void setMillis(String var1) {
        this.millis = var1;
    }
}
