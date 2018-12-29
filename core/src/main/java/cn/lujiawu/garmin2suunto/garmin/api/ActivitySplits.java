//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lujiawu.garmin2suunto.garmin.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ActivitySplits implements Serializable {

    @SerializedName("activityId")
    @Expose
    private Long activityId;
    @SerializedName("lapDTOs")
    @Expose
    private List<Lap> laps = new ArrayList();

    @Data
    public class Lap implements Serializable {

        @SerializedName("distance")
        @Expose
        private Double distance;
        @SerializedName("duration")
        @Expose
        private Double duration;

    }

}
