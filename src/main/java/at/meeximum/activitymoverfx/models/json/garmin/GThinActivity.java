//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.json.garmin;

import at.meeximum.activitymoverfx.utils.DateUtils;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.TimeZone;

public class GThinActivity {
    @SerializedName("activityId")
    String activityId;
    @SerializedName("activityName")
    String activityName;
    @SerializedName("activityDescription")
    String activityDescription;
    @SerializedName("activityType")
    GFieldSet activityType;
    @SerializedName("eventType")
    GFieldSet eventType;
    @SerializedName("isFavorite")
    boolean favorite;
    @SerializedName("userId")
    String userId;
    @SerializedName("activityStartTime")
    GFieldSet activityStartTime;
    @SerializedName("distance")
    GFieldSet distance;
    @SerializedName("duration")
    GFieldSet duration;
    @SerializedName("calories")
    GFieldSet calories;
    @SerializedName("averageSpeed")
    GFieldSet averageSpeed;
    @SerializedName("averagePace")
    GFieldSet averagePace;
    @SerializedName("elevationGain")
    GFieldSet elevationGain;
    @SerializedName("elevationLoss")
    GFieldSet elevationLoss;

    public GThinActivity() {
    }

    public String getActivityId() {
        return this.activityId;
    }

    public void setActivityId(String var1) {
        this.activityId = var1;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public void setActivityName(String var1) {
        this.activityName = var1;
    }

    public String getActivityDescription() {
        return this.activityDescription;
    }

    public void setActivityDescription(String var1) {
        this.activityDescription = var1;
    }

    public GFieldSet getActivityType() {
        return this.activityType;
    }

    public void setActivityType(GFieldSet var1) {
        this.activityType = var1;
    }

    public GFieldSet getEventType() {
        return this.eventType;
    }

    public void setEventType(GFieldSet var1) {
        this.eventType = var1;
    }

    public boolean isFavorite() {
        return this.favorite;
    }

    public void setFavorite(boolean var1) {
        this.favorite = var1;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String var1) {
        this.userId = var1;
    }

    public GFieldSet getActivityStartTime() {
        return this.activityStartTime;
    }

    public void setActivityStartTime(GFieldSet var1) {
        this.activityStartTime = var1;
    }

    public GFieldSet getDistance() {
        return this.distance;
    }

    public void setDistance(GFieldSet var1) {
        this.distance = var1;
    }

    public GFieldSet getDuration() {
        return this.duration;
    }

    public void setDuration(GFieldSet var1) {
        this.duration = var1;
    }

    public GFieldSet getCalories() {
        return this.calories;
    }

    public void setCalories(GFieldSet var1) {
        this.calories = var1;
    }

    public GFieldSet getAverageSpeed() {
        return this.averageSpeed;
    }

    public void setAverageSpeed(GFieldSet var1) {
        this.averageSpeed = var1;
    }

    public GFieldSet getAveragePace() {
        return this.averagePace;
    }

    public void setAveragePace(GFieldSet var1) {
        this.averagePace = var1;
    }

    public GFieldSet getElevationGain() {
        return this.elevationGain;
    }

    public void setElevationGain(GFieldSet var1) {
        this.elevationGain = var1;
    }

    public GFieldSet getElevationLoss() {
        return this.elevationLoss;
    }

    public void setElevationLoss(GFieldSet var1) {
        this.elevationLoss = var1;
    }

    public String getLocalStartTime() {
        String var1 = this.getActivityStartTime().getValue();
        String var2 = this.getActivityStartTime().getUom();
        Date var3 = new Date(Long.valueOf(Double.valueOf(var1).longValue()));
        return DateUtils.formatDateTimeForMoveWithMS(var3, TimeZone.getTimeZone(var2));
    }

    public String toString() {
        return "Activity (thin): " + this.getActivityId() + " " + this.getActivityName();
    }
}
