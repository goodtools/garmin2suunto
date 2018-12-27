//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccessControlRuleDTO {
    @SerializedName("typeId")
    @Expose
    private Integer typeId;
    @SerializedName("typeKey")
    @Expose
    private String typeKey;

    public AccessControlRuleDTO() {
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
}
