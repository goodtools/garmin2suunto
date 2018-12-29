//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lujiawu.garmin2suunto.move.api;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class SampleSet implements Serializable {
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

}
