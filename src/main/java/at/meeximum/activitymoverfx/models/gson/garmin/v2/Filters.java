//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin.v2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Filters {
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("userId_oper")
    @Expose
    private String userIdOper;

    public Filters() {
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String var1) {
        this.userId = var1;
    }

    public String getUserIdOper() {
        return this.userIdOper;
    }

    public void setUserIdOper(String var1) {
        this.userIdOper = var1;
    }
}
