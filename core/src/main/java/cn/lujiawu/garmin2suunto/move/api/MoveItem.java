package cn.lujiawu.garmin2suunto.move.api;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ToString
@Data
public class MoveItem implements Serializable {

    @SerializedName("ActivityID")
    long activityID;
    @SerializedName("MoveID")
    Integer moveId;
    @SerializedName("Notes")
    String notes;
    @SerializedName("LastModifiedDate")
    String lastModifiedDate;
    @SerializedName("LocalStartTime")
    String localStartTime;

    public String getStartDate() {
        if (StringUtils.isEmpty(localStartTime)){
            return "";
        }
        return localStartTime.substring(0, 10);
    }

    private static Pattern compile = Pattern.compile("\\d+");

    public String getGarminActivityId() {
        if (StringUtils.isEmpty(notes)){
            return "";
        }
        Matcher matcher = null;
        synchronized (compile) {
            matcher = compile.matcher(notes);
        }

        if (matcher.find()) {
            return matcher.group();
        } else {
            return "";
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MoveItem {");
        sb.append("activityID=").append(activityID);
        sb.append(", moveId=").append(moveId);
        sb.append(", notes='").append(notes).append('\'');
        sb.append(", lastModifiedDate='").append(lastModifiedDate).append('\'');
        sb.append(", localStartTime='").append(localStartTime).append('\'');
        sb.append('}');
        return sb.toString().replaceAll("\n","");
    }
}
