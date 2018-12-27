//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin.v2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActivityName {
    @SerializedName("value")
    @Expose
    private String value;

    public ActivityName() {
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String var1) {
        this.value = var1;
    }
}
