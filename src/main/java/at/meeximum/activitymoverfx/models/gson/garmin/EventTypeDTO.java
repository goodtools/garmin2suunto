//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventTypeDTO {
    @SerializedName("typeId")
    @Expose
    private Integer typeId;
    @SerializedName("typeKey")
    @Expose
    private String typeKey;
    @SerializedName("sortOrder")
    @Expose
    private Integer sortOrder;

    public EventTypeDTO() {
    }

    public Integer getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Integer var1) {
        this.typeId = var1;
    }

    public String getTypeKey() {
        return this.typeKey;
    }

    public void setTypeKey(String var1) {
        this.typeKey = var1;
    }

    public Integer getSortOrder() {
        return this.sortOrder;
    }

    public void setSortOrder(Integer var1) {
        this.sortOrder = var1;
    }
}
