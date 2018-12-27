//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.json.suunto;

import com.google.gson.annotations.SerializedName;

public class SampleSet {
    @SerializedName("Altitude")
    Float altitude;
    @SerializedName("BikeCadence")
    Float bikeCadence;
    @SerializedName("Distance")
    Integer distance;
    @SerializedName("EnergyConsumption")
    Float energy;
    @SerializedName("HeartRate")
    Integer heartRate;
    @SerializedName("LocalTime")
    String localTime;
    @SerializedName("Power")
    Integer power;
    @SerializedName("RunningCadence")
    Float runningCadence;
    @SerializedName("Speed")
    Float speed;
    @SerializedName("Temperature")
    Float temperature;
    @SerializedName("VerticalSpeed")
    Float verticalSpeed;

    public SampleSet() {
    }

    public void setAltitude(Float var1) {
        this.altitude = var1;
    }

    public void setBikeCadence(Float var1) {
        this.bikeCadence = var1;
    }

    public void setDistance(Integer var1) {
        this.distance = var1;
    }

    public void setEnergy(Float var1) {
        this.energy = var1;
    }

    public void setHeartRate(Integer var1) {
        this.heartRate = var1;
    }

    public void setLocalTime(String var1) {
        this.localTime = var1;
    }

    public String getLocalTime() {
        return this.localTime;
    }

    public void setPower(Integer var1) {
        this.power = var1;
    }

    public void setRunningCadence(Float var1) {
        this.runningCadence = var1;
    }

    public void setSpeed(Float var1) {
        this.speed = var1;
    }

    public void setTemperature(Float var1) {
        this.temperature = var1;
    }

    public void setVerticalSpeed(Float var1) {
        this.verticalSpeed = var1;
    }

    public Float getAltitude() {
        return this.altitude;
    }
}
