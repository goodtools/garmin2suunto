//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LapDTO {
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
    @SerializedName("lapIndex")
    @Expose
    private Integer lapIndex;
    @SerializedName("lengthDTOs")
    @Expose
    private List<Object> lengthDTOs = new ArrayList();
    @SerializedName("connectIQMeasurement")
    @Expose
    private List<Object> connectIQMeasurement = new ArrayList();

    public LapDTO() {
    }

    public String getStartTimeGMT() {
        return this.startTimeGMT;
    }

    public void setStartTimeGMT(String var1) {
        this.startTimeGMT = var1;
    }

    public Double getStartLatitude() {
        return this.startLatitude;
    }

    public void setStartLatitude(Double var1) {
        this.startLatitude = var1;
    }

    public Double getStartLongitude() {
        return this.startLongitude;
    }

    public void setStartLongitude(Double var1) {
        this.startLongitude = var1;
    }

    public Double getDistance() {
        return this.distance;
    }

    public void setDistance(Double var1) {
        this.distance = var1;
    }

    public Double getDuration() {
        return this.duration;
    }

    public void setDuration(Double var1) {
        this.duration = var1;
    }

    public Double getMovingDuration() {
        return this.movingDuration;
    }

    public void setMovingDuration(Double var1) {
        this.movingDuration = var1;
    }

    public Double getElapsedDuration() {
        return this.elapsedDuration;
    }

    public void setElapsedDuration(Double var1) {
        this.elapsedDuration = var1;
    }

    public Double getElevationGain() {
        return this.elevationGain;
    }

    public void setElevationGain(Double var1) {
        this.elevationGain = var1;
    }

    public Double getElevationLoss() {
        return this.elevationLoss;
    }

    public void setElevationLoss(Double var1) {
        this.elevationLoss = var1;
    }

    public Double getMaxElevation() {
        return this.maxElevation;
    }

    public void setMaxElevation(Double var1) {
        this.maxElevation = var1;
    }

    public Double getMinElevation() {
        return this.minElevation;
    }

    public void setMinElevation(Double var1) {
        this.minElevation = var1;
    }

    public Double getAverageSpeed() {
        return this.averageSpeed;
    }

    public void setAverageSpeed(Double var1) {
        this.averageSpeed = var1;
    }

    public Double getAverageMovingSpeed() {
        return this.averageMovingSpeed;
    }

    public void setAverageMovingSpeed(Double var1) {
        this.averageMovingSpeed = var1;
    }

    public Double getMaxSpeed() {
        return this.maxSpeed;
    }

    public void setMaxSpeed(Double var1) {
        this.maxSpeed = var1;
    }

    public Double getCalories() {
        return this.calories;
    }

    public void setCalories(Double var1) {
        this.calories = var1;
    }

    public Double getAverageHR() {
        return this.averageHR;
    }

    public void setAverageHR(Double var1) {
        this.averageHR = var1;
    }

    public Double getMaxHR() {
        return this.maxHR;
    }

    public void setMaxHR(Double var1) {
        this.maxHR = var1;
    }

    public Integer getLapIndex() {
        return this.lapIndex;
    }

    public void setLapIndex(Integer var1) {
        this.lapIndex = var1;
    }

    public List<Object> getLengthDTOs() {
        return this.lengthDTOs;
    }

    public void setLengthDTOs(List<Object> var1) {
        this.lengthDTOs = var1;
    }

    public List<Object> getConnectIQMeasurement() {
        return this.connectIQMeasurement;
    }

    public void setConnectIQMeasurement(List<Object> var1) {
        this.connectIQMeasurement = var1;
    }
}
