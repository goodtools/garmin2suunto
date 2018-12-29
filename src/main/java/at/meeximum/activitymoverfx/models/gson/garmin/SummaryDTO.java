//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SummaryDTO {
    @SerializedName("startTimeLocal")
    @Expose
    private String startTimeLocal;
    @SerializedName("startTimeGMT")
    @Expose
    private String startTimeGMT;
    @SerializedName("startLatitude")
    @Expose
    private Double startLatitude;
    @SerializedName("startLongitude")
    @Expose
    private Double startLongitude;
    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("duration")
    @Expose
    private Double duration;
    @SerializedName("movingDuration")
    @Expose
    private Double movingDuration;
    @SerializedName("elapsedDuration")
    @Expose
    private Double elapsedDuration;
    @SerializedName("elevationGain")
    @Expose
    private Double elevationGain;
    @SerializedName("elevationLoss")
    @Expose
    private Double elevationLoss;
    @SerializedName("maxElevation")
    @Expose
    private Double maxElevation;
    @SerializedName("minElevation")
    @Expose
    private Double minElevation;
    @SerializedName("averageSpeed")
    @Expose
    private Double averageSpeed;
    @SerializedName("averageMovingSpeed")
    @Expose
    private Double averageMovingSpeed;
    @SerializedName("maxSpeed")
    @Expose
    private Double maxSpeed;
    @SerializedName("calories")
    @Expose
    private Double calories;
    @SerializedName("averageHR")
    @Expose
    private Double averageHR;
    @SerializedName("maxHR")
    @Expose
    private Double maxHR;
    @SerializedName("averageTemperature")
    @Expose
    private Double averageTemperature;
    @SerializedName("minTemperature")
    @Expose
    private Double minTemperature;
    @SerializedName("maxTemperature")
    @Expose
    private Double maxTemperature;
    @SerializedName("trainingEffect")
    @Expose
    private Double trainingEffect;
    @SerializedName("averageBikeCadence")
    @Expose
    private Double averageBikeCadence;
    @SerializedName("maxBikeCadence")
    @Expose
    private Double maxBikeCadence;
    @SerializedName("averagePower")
    @Expose
    private Double averagePower;
    @SerializedName("maxPower")
    @Expose
    private Double maxPower;
    @SerializedName("averageRunCadence")
    @Expose
    private Double averageRunCadence;
    @SerializedName("maxRunCadence")
    @Expose
    private Double maxRunCadence;

}
