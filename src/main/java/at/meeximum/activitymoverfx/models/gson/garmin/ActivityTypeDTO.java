//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class ActivityTypeDTO {
    @SerializedName("typeId")
    @Expose
    private Integer typeId;
    @SerializedName("typeKey")
    @Expose
    private String typeKey;
    @SerializedName("parentTypeId")
    @Expose
    private Integer parentTypeId;
    @SerializedName("sortOrder")
    @Expose
    private Integer sortOrder;
}
