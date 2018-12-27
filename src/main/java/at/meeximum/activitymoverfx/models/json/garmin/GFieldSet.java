//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.json.garmin;

import com.google.gson.annotations.SerializedName;

public class GFieldSet {
    @SerializedName("display")
    String display;
    @SerializedName("key")
    String key;
    @SerializedName("fieldNameDisplay")
    String fieldNameDisplay;
    @SerializedName("fieldDisplayName")
    String fieldDisplayName;
    @SerializedName("displayUnit")
    String displayUnit;
    @SerializedName("value")
    String value;
    @SerializedName("withUnit")
    String withUnit;
    @SerializedName("withUnitAbbr")
    String withUnitAbbr;
    @SerializedName("uom")
    String uom;
    @SerializedName("unitAbbr")
    String unitAbbr;
    @SerializedName("abbr")
    String abbr;
    @SerializedName("parent")
    GFieldSet parent;
    @SerializedName("zones")
    GFieldSet zones;
    @SerializedName("bpm")
    GFieldSet bpm;
    @SerializedName("percentMax")
    GFieldSet percentMax;

    public GFieldSet() {
    }

    public String getDisplay() {
        return this.display;
    }

    public void setDisplay(String var1) {
        this.display = var1;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String var1) {
        this.key = var1;
    }

    public String getFieldNameDisplay() {
        return this.fieldNameDisplay;
    }

    public void setFieldNameDisplay(String var1) {
        this.fieldNameDisplay = var1;
    }

    public String getFieldDisplayName() {
        return this.fieldDisplayName;
    }

    public void setFieldDisplayName(String var1) {
        this.fieldDisplayName = var1;
    }

    public String getDisplayUnit() {
        return this.displayUnit;
    }

    public void setDisplayUnit(String var1) {
        this.displayUnit = var1;
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

    public String getAbbr() {
        return this.abbr;
    }

    public void setAbbr(String var1) {
        this.abbr = var1;
    }

    public void setUnitAbbr(String var1) {
        this.unitAbbr = var1;
    }

    public GFieldSet getParent() {
        return this.parent;
    }

    public void setParent(GFieldSet var1) {
        this.parent = var1;
    }

    public GFieldSet getZones() {
        return this.zones;
    }

    public void setZones(GFieldSet var1) {
        this.zones = var1;
    }

    public GFieldSet getBpm() {
        return this.bpm;
    }

    public void setBpm(GFieldSet var1) {
        this.bpm = var1;
    }

    public GFieldSet getPercentMax() {
        return this.percentMax;
    }

    public void setPercentMax(GFieldSet var1) {
        this.percentMax = var1;
    }
}
