//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin.v2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Device {
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("display")
    @Expose
    private String display;
    @SerializedName("displaySingular")
    @Expose
    private String displaySingular;
    @SerializedName("version")
    @Expose
    private String version;

    public Device() {
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String var1) {
        this.key = var1;
    }

    public String getDisplay() {
        return this.display;
    }

    public void setDisplay(String var1) {
        this.display = var1;
    }

    public String getDisplaySingular() {
        return this.displaySingular;
    }

    public void setDisplaySingular(String var1) {
        this.displaySingular = var1;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String var1) {
        this.version = var1;
    }
}
