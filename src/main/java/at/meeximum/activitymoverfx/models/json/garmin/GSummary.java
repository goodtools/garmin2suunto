//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.json.garmin;

import at.meeximum.activitymoverfx.utils.DateUtils;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class GSummary {
    @SerializedName("SumSampleCountAirTemperature")
    GFieldSet sumSampleCountAirTemperature;
    @SerializedName("WeightedMeanNormalizedPower")
    GFieldSet weightedMeanNormalizedPower;
    @SerializedName("SumSampleCountPower")
    GFieldSet sumSampleCountPower;
    @SerializedName("MinPower")
    GFieldSet minPower;
    @SerializedName("SumSampleCountBikeCadence")
    GFieldSet sumSampleCountBikeCadence;
    @SerializedName("MinAirTemperature")
    GFieldSet minAirTemperature;
    @SerializedName("MaxAirTemperature")
    GFieldSet maxAirTemperature;
    @SerializedName("WeightedMeanAirTemperature")
    GFieldSet weightedMeanAirTemperature;
    @SerializedName("WeightedMeanBikeCadence")
    GFieldSet weightedMeanBikeCadence;
    @SerializedName("MinBikeCadence")
    GFieldSet minBikeCadence;
    @SerializedName("MaxBikeCadence")
    GFieldSet maxBikeCadence;
    @SerializedName("WeightedMeanRunCadence")
    GFieldSet weightedMeanRunCadence;
    @SerializedName("MinRunCadence")
    GFieldSet minRunCadence;
    @SerializedName("MaxRunCadence")
    GFieldSet maxRunCadence;
    @SerializedName("WeightedMeanPower")
    GFieldSet weightedMeanPower;
    @SerializedName("MaxPower")
    GFieldSet maxPower;
    @SerializedName("MaxElevation")
    GFieldSet maxElevation;
    @SerializedName("SumSampleCountMovingSpeed")
    GFieldSet sumSampleCountMovingSpeed;
    @SerializedName("EndLatitude")
    GFieldSet endLatitude;
    @SerializedName("EndLongitude")
    GFieldSet endLongitude;
    @SerializedName("WeightedMeanMovingSpeed")
    GFieldSet weightedMeanMovingSpeed;
    @SerializedName("WeightedMeanMovingPace")
    GFieldSet weightedMeanMovingPace;
    @SerializedName("MinSpeed")
    GFieldSet minSpeed;
    @SerializedName("MinPace")
    GFieldSet minPace;
    @SerializedName("MaxSpeed")
    GFieldSet maxSpeed;
    @SerializedName("MaxPace")
    GFieldSet maxPace;
    @SerializedName("BeginLatitude")
    GFieldSet beginLatitude;
    @SerializedName("SumMovingDuration")
    GFieldSet sumMovingDuration;
    @SerializedName("BeginLongitude")
    GFieldSet beginLongitude;
    @SerializedName("MinElevation")
    GFieldSet minElevation;
    @SerializedName("GainElevation")
    GFieldSet gainElevation;
    @SerializedName("SumSampleCountLongitude")
    GFieldSet sumSampleCountLongitude;
    @SerializedName("SumSampleCountLatitude")
    GFieldSet sumSampleCountLatitude;
    @SerializedName("LossElevation")
    GFieldSet lossElevation;
    @SerializedName("SumSampleCountSpeed")
    GFieldSet sumSampleCountSpeed;
    @SerializedName("SumSampleCountElevation")
    GFieldSet sumSampleCountElevation;
    @SerializedName("MaxHeartRate")
    GFieldSet maxHeartRate;
    @SerializedName("WeightedMeanHeartRate")
    GFieldSet weightedMeanHeartRate;
    @SerializedName("SumEnergy")
    GFieldSet sumEnergy;
    @SerializedName("SumElapsedDuration")
    GFieldSet sumElapsedDuration;
    @SerializedName("WeightedMeanSpeed")
    GFieldSet weightedMeanSpeed;
    @SerializedName("WeightedMeanPace")
    GFieldSet weightedMeanPace;
    @SerializedName("SumSampleCountHeartRate")
    GFieldSet sumSampleCountHeartRate;
    @SerializedName("SumDuration")
    GFieldSet sumDuration;
    @SerializedName("SumSampleCountTimestamp")
    GFieldSet sumSampleCountTimestamp;
    @SerializedName("MinHeartRate")
    GFieldSet minHeartRate;
    @SerializedName("BeginTimestamp")
    GFieldSet beginTimestamp;
    @SerializedName("EndTimestamp")
    GFieldSet endTimestamp;
    @SerializedName("SumTrainingEffect")
    GFieldSet sumTrainingEffect;
    @SerializedName("SumDistance")
    GFieldSet sumDistance;
    @SerializedName("DifferenceDuration")
    GFieldSet differenceDuration;
    @SerializedName("DifferenceElapsedDuration")
    GFieldSet differenceElapsedDuration;

    public GSummary() {
    }

    public GFieldSet getSumSampleCountAirTemperature() {
        return this.sumSampleCountAirTemperature;
    }

    public void setSumSampleCountAirTemperature(GFieldSet var1) {
        this.sumSampleCountAirTemperature = var1;
    }

    public GFieldSet getWeightedMeanNormalizedPower() {
        return this.weightedMeanNormalizedPower;
    }

    public void setWeightedMeanNormalizedPower(GFieldSet var1) {
        this.weightedMeanNormalizedPower = var1;
    }

    public GFieldSet getSumSampleCountPower() {
        return this.sumSampleCountPower;
    }

    public void setSumSampleCountPower(GFieldSet var1) {
        this.sumSampleCountPower = var1;
    }

    public GFieldSet getMinPower() {
        return this.minPower;
    }

    public void setMinPower(GFieldSet var1) {
        this.minPower = var1;
    }

    public GFieldSet getSumSampleCountBikeCadence() {
        return this.sumSampleCountBikeCadence;
    }

    public void setSumSampleCountBikeCadence(GFieldSet var1) {
        this.sumSampleCountBikeCadence = var1;
    }

    public GFieldSet getWeightedMeanRunCadence() {
        return this.weightedMeanRunCadence;
    }

    public void setWeightedMeanRunCadence(GFieldSet var1) {
        this.weightedMeanRunCadence = var1;
    }

    public GFieldSet getMinRunCadence() {
        return this.minRunCadence;
    }

    public void setMinRunCadence(GFieldSet var1) {
        this.minRunCadence = var1;
    }

    public GFieldSet getMaxRunCadence() {
        return this.maxRunCadence;
    }

    public void setMaxRunCadence(GFieldSet var1) {
        this.maxRunCadence = var1;
    }

    public GFieldSet getMinAirTemperature() {
        return this.minAirTemperature;
    }

    public void setMinAirTemperature(GFieldSet var1) {
        this.minAirTemperature = var1;
    }

    public GFieldSet getMaxAirTemperature() {
        return this.maxAirTemperature;
    }

    public void setMaxAirTemperature(GFieldSet var1) {
        this.maxAirTemperature = var1;
    }

    public GFieldSet getWeightedMeanAirTemperature() {
        return this.weightedMeanAirTemperature;
    }

    public void setWeightedMeanAirTemperature(GFieldSet var1) {
        this.weightedMeanAirTemperature = var1;
    }

    public GFieldSet getWeightedMeanBikeCadence() {
        return this.weightedMeanBikeCadence;
    }

    public void setWeightedMeanBikeCadence(GFieldSet var1) {
        this.weightedMeanBikeCadence = var1;
    }

    public GFieldSet getMinBikeCadence() {
        return this.minBikeCadence;
    }

    public void setMinBikeCadence(GFieldSet var1) {
        this.minBikeCadence = var1;
    }

    public GFieldSet getWeightedMeanPower() {
        return this.weightedMeanPower;
    }

    public void setWeightedMeanPower(GFieldSet var1) {
        this.weightedMeanPower = var1;
    }

    public GFieldSet getMaxPower() {
        return this.maxPower;
    }

    public void setMaxPower(GFieldSet var1) {
        this.maxPower = var1;
    }

    public GFieldSet getMaxHeartRate() {
        return this.maxHeartRate;
    }

    public void setMaxHeartRate(GFieldSet var1) {
        this.maxHeartRate = var1;
    }

    public GFieldSet getWeightedMeanHeartRate() {
        return this.weightedMeanHeartRate;
    }

    public void setWeightedMeanHeartRate(GFieldSet var1) {
        this.weightedMeanHeartRate = var1;
    }

    public GFieldSet getSumEnergy() {
        return this.sumEnergy;
    }

    public void setSumEnergy(GFieldSet var1) {
        this.sumEnergy = var1;
    }

    public GFieldSet getMaxBikeCadence() {
        return this.maxBikeCadence;
    }

    public void setMaxBikeCadence(GFieldSet var1) {
        this.maxBikeCadence = var1;
    }

    public GFieldSet getSumElapsedDuration() {
        return this.sumElapsedDuration;
    }

    public void setSumElapsedDuration(GFieldSet var1) {
        this.sumElapsedDuration = var1;
    }

    public GFieldSet getWeightedMeanSpeed() {
        return this.weightedMeanSpeed;
    }

    public void setWeightedMeanSpeed(GFieldSet var1) {
        this.weightedMeanSpeed = var1;
    }

    public GFieldSet getWeightedMeanPace() {
        return this.weightedMeanPace;
    }

    public void setWeightedMeanPace(GFieldSet var1) {
        this.weightedMeanPace = var1;
    }

    public GFieldSet getSumSampleCountHeartRate() {
        return this.sumSampleCountHeartRate;
    }

    public void setSumSampleCountHeartRate(GFieldSet var1) {
        this.sumSampleCountHeartRate = var1;
    }

    public GFieldSet getSumDuration() {
        return this.sumDuration;
    }

    public void setSumDuration(GFieldSet var1) {
        this.sumDuration = var1;
    }

    public GFieldSet getSumSampleCountTimestamp() {
        return this.sumSampleCountTimestamp;
    }

    public void setSumSampleCountTimestamp(GFieldSet var1) {
        this.sumSampleCountTimestamp = var1;
    }

    public GFieldSet getMinHeartRate() {
        return this.minHeartRate;
    }

    public void setMinHeartRate(GFieldSet var1) {
        this.minHeartRate = var1;
    }

    public GFieldSet getBeginTimestamp() {
        return this.beginTimestamp;
    }

    public void setBeginTimestamp(GFieldSet var1) {
        this.beginTimestamp = var1;
    }

    public GFieldSet getEndTimestamp() {
        return this.endTimestamp;
    }

    public void setEndTimestamp(GFieldSet var1) {
        this.endTimestamp = var1;
    }

    public GFieldSet getSumTrainingEffect() {
        return this.sumTrainingEffect;
    }

    public void setSumTrainingEffect(GFieldSet var1) {
        this.sumTrainingEffect = var1;
    }

    public GFieldSet getSumDistance() {
        return this.sumDistance;
    }

    public void setSumDistance(GFieldSet var1) {
        this.sumDistance = var1;
    }

    public GFieldSet getDifferenceDuration() {
        return this.differenceDuration;
    }

    public void setDifferenceDuration(GFieldSet var1) {
        this.differenceDuration = var1;
    }

    public GFieldSet getDifferenceElapsedDuration() {
        return this.differenceElapsedDuration;
    }

    public void setDifferenceElapsedDuration(GFieldSet var1) {
        this.differenceElapsedDuration = var1;
    }

    public GFieldSet getMaxElevation() {
        return this.maxElevation;
    }

    public void setMaxElevation(GFieldSet var1) {
        this.maxElevation = var1;
    }

    public GFieldSet getSumSampleCountMovingSpeed() {
        return this.sumSampleCountMovingSpeed;
    }

    public void setSumSampleCountMovingSpeed(GFieldSet var1) {
        this.sumSampleCountMovingSpeed = var1;
    }

    public GFieldSet getEndLatitude() {
        return this.endLatitude;
    }

    public void setEndLatitude(GFieldSet var1) {
        this.endLatitude = var1;
    }

    public GFieldSet getEndLongitude() {
        return this.endLongitude;
    }

    public void setEndLongitude(GFieldSet var1) {
        this.endLongitude = var1;
    }

    public GFieldSet getWeightedMeanMovingSpeed() {
        return this.weightedMeanMovingSpeed;
    }

    public void setWeightedMeanMovingSpeed(GFieldSet var1) {
        this.weightedMeanMovingSpeed = var1;
    }

    public GFieldSet getWeightedMeanMovingPace() {
        return this.weightedMeanMovingPace;
    }

    public void setWeightedMeanMovingPace(GFieldSet var1) {
        this.weightedMeanMovingPace = var1;
    }

    public GFieldSet getMinSpeed() {
        return this.minSpeed;
    }

    public void setMinSpeed(GFieldSet var1) {
        this.minSpeed = var1;
    }

    public GFieldSet getMinPace() {
        return this.minPace;
    }

    public void setMinPace(GFieldSet var1) {
        this.minPace = var1;
    }

    public GFieldSet getMaxSpeed() {
        return this.maxSpeed;
    }

    public void setMaxSpeed(GFieldSet var1) {
        this.maxSpeed = var1;
    }

    public GFieldSet getMaxPace() {
        return this.maxPace;
    }

    public void setMaxPace(GFieldSet var1) {
        this.maxPace = var1;
    }

    public GFieldSet getBeginLatitude() {
        return this.beginLatitude;
    }

    public void setBeginLatitude(GFieldSet var1) {
        this.beginLatitude = var1;
    }

    public GFieldSet getSumMovingDuration() {
        return this.sumMovingDuration;
    }

    public void setSumMovingDuration(GFieldSet var1) {
        this.sumMovingDuration = var1;
    }

    public GFieldSet getBeginLongitude() {
        return this.beginLongitude;
    }

    public void setBeginLongitude(GFieldSet var1) {
        this.beginLongitude = var1;
    }

    public GFieldSet getMinElevation() {
        return this.minElevation;
    }

    public void setMinElevation(GFieldSet var1) {
        this.minElevation = var1;
    }

    public GFieldSet getGainElevation() {
        return this.gainElevation;
    }

    public void setGainElevation(GFieldSet var1) {
        this.gainElevation = var1;
    }

    public GFieldSet getSumSampleCountLongitude() {
        return this.sumSampleCountLongitude;
    }

    public void setSumSampleCountLongitude(GFieldSet var1) {
        this.sumSampleCountLongitude = var1;
    }

    public GFieldSet getSumSampleCountLatitude() {
        return this.sumSampleCountLatitude;
    }

    public void setSumSampleCountLatitude(GFieldSet var1) {
        this.sumSampleCountLatitude = var1;
    }

    public GFieldSet getLossElevation() {
        return this.lossElevation;
    }

    public void setLossElevation(GFieldSet var1) {
        this.lossElevation = var1;
    }

    public GFieldSet getSumSampleCountSpeed() {
        return this.sumSampleCountSpeed;
    }

    public void setSumSampleCountSpeed(GFieldSet var1) {
        this.sumSampleCountSpeed = var1;
    }

    public GFieldSet getSumSampleCountElevation() {
        return this.sumSampleCountElevation;
    }

    public void setSumSampleCountElevation(GFieldSet var1) {
        this.sumSampleCountElevation = var1;
    }

    public String getBeginTime() {
        String var1 = this.getBeginTimestamp().getValue();
        Date var2 = new Date(Long.valueOf(Double.valueOf(var1).longValue()));
        return DateUtils.formatDateTimeForMoveWithMS(var2);
    }

    public String getEndTime() {
        String var1 = this.getEndTimestamp().getValue();
        Date var2 = new Date(Long.valueOf(Double.valueOf(var1).longValue()));
        return DateUtils.formatDateTimeForMoveWithMS(var2);
    }
}
