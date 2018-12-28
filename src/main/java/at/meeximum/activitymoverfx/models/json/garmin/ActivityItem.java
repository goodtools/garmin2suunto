package at.meeximum.activitymoverfx.models.json.garmin;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

@ToString
@Data
public class ActivityItem implements Serializable {

    @SerializedName("activityId")
    private String activityId;
    @SerializedName("activityName")
    private String activityName;

    private String startTimeLocal;

    private Type activityType;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ActivityItem)) return false;

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
