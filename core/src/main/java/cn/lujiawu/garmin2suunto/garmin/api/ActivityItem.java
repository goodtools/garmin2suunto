package cn.lujiawu.garmin2suunto.garmin.api;

import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * "calories= 345.0,
 * "averageHR= 145.0,
 * "maxHR= 170.0,
 * "averageRunningCadenceInStepsPerMinute= 178.046875,
 * "maxRunningCadenceInStepsPerMinute= 207.0,
 * "distance= 5118.5498046875,
 * "duration= 1986.9859619140625,
 * "activityId= 50453091,
 * "activityName= "杭州市 跑步"
 * "startTimeLocal= "2018-12-29 07:06:22",
 * "averageSpeed= 2.5759999752044673,
 * "maxSpeed= 4.255000114440918,
 */
@ToString
@Data
public class ActivityItem implements Serializable {

    @SerializedName("activityId")
    private String activityId;
    @SerializedName("activityName")
    private String activityName;
    private String startTimeLocal;
    private Type activityType;
    private Double calories;
    private Double averageHR;
    private Double maxHR;
    private Double averageRunningCadenceInStepsPerMinute;
    private Double maxRunningCadenceInStepsPerMinute;
    private Double distance;
    private Double duration;
    private Double averageSpeed;
    private Double maxSpeed;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof ActivityItem)) {
            return false;
        }

        ActivityItem item = (ActivityItem) o;

        return new EqualsBuilder()
                .append(getActivityId(), item.getActivityId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getActivityId())
                .toHashCode();
    }

    @ToString
    @Data
    public static class Type implements Serializable {

        private String typeKey;

    }

}
