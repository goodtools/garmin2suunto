//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin.v2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActivityTimeZone {
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("offset")
    @Expose
    private String offset;
    @SerializedName("display")
    @Expose
    private String display;
    @SerializedName("abbr")
    @Expose
    private String abbr;

    public ActivityTimeZone() {
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String var1) {
        this.key = var1;
    }

    public String getOffset() {
        return this.offset;
    }

    public void setOffset(String var1) {
        this.offset = var1;
    }

    public String getDisplay() {
        return this.display;
    }

    public void setDisplay(String var1) {
        this.display = var1;
    }

    public String getAbbr() {
        return this.abbr;
    }

    public void setAbbr(String var1) {
        this.abbr = var1;
    }
}
