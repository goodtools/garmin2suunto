//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lujiawu.garmin2suunto.garmin.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Activity {

    @SerializedName("activityId")
    @Expose
    private Long activityId;
    @SerializedName("activityName")
    @Expose
    private String activityName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("userProfileId")
    @Expose
    private Integer userProfileId;
    @SerializedName("isMultiSportParent")
    @Expose
    private Boolean isMultiSportParent;
    @SerializedName("activityTypeDTO")
    @Expose
    private ActivityTypeDTO activityTypeDTO;
    @SerializedName("summaryDTO")
    @Expose
    private SummaryDTO summaryDTO;

    @Data
    public static class SummaryDTO {
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

    @Data
    public static class ActivityTypeDTO {
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

}
