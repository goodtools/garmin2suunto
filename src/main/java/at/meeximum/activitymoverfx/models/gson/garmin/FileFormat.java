//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FileFormat {
    @SerializedName("formatId")
    @Expose
    private Integer formatId;
    @SerializedName("formatKey")
    @Expose
    private String formatKey;

    public FileFormat() {
    }

    public Integer getFormatId() {
        return this.formatId;
    }

    public void setFormatId(Integer var1) {
        this.formatId = var1;
    }

    public String getFormatKey() {
        return this.formatKey;
    }

    public void setFormatKey(String var1) {
        this.formatKey = var1;
    }
}
