//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin.v2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MaxDoubleCadence {
    @SerializedName("display")
    @Expose
    private String display;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("withUnit")
    @Expose
    private String withUnit;
    @SerializedName("withUnitAbbr")
    @Expose
    private String withUnitAbbr;
    @SerializedName("uom")
    @Expose
    private String uom;
    @SerializedName("unitAbbr")
    @Expose
    private String unitAbbr;

    public MaxDoubleCadence() {
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

    public String getWithUnit() {
        return this.withUnit;
    }

    public void setWithUnit(String var1) {
        this.withUnit = var1;
    }

    public String getWithUnitAbbr() {
        return this.withUnitAbbr;
    }

    public void setWithUnitAbbr(String var1) {
        this.withUnitAbbr = var1;
    }

    public String getUom() {
        return this.uom;
    }

    public void setUom(String var1) {
        this.uom = var1;
    }

    public String getUnitAbbr() {
        return this.unitAbbr;
    }

    public void setUnitAbbr(String var1) {
        this.unitAbbr = var1;
    }
}
