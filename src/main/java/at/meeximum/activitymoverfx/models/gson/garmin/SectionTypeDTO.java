//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SectionTypeDTO {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("sectionTypeKey")
    @Expose
    private String sectionTypeKey;

    public SectionTypeDTO() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer var1) {
        this.id = var1;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String var1) {
        this.key = var1;
    }

    public String getSectionTypeKey() {
        return this.sectionTypeKey;
    }

    public void setSectionTypeKey(String var1) {
        this.sectionTypeKey = var1;
    }
}
