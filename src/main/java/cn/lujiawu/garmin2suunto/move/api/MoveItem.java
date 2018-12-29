package cn.lujiawu.garmin2suunto.move.api;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

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
        return localStartTime.substring(0, 10);
    }

    private static Pattern compile = Pattern.compile("\\d+");

    public String getGarminActivityId() {
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



}
