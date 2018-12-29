//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lujiawu.garmin2suunto.move.api;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
public class Move {
    @SerializedName("ActivityID")
    int activityID;
    @SerializedName("AscentAltitude")
    Double ascentAltitude;
    @SerializedName("AscentTime")
    Double ascentTime;
    @SerializedName("AvgBikeCadence")
    Float avgBikeCadence;
    @SerializedName("AvgRunningCadence")
    Float avgRunningCadence;
    @SerializedName("AvgHR")
    Integer avgHR;
    @SerializedName("AvgSpeed")
    Float avgSpeed;
    @SerializedName("AvgTemp")
    Float avgTemp;
    @SerializedName("AvgPower")
    Float avgPower;
    @SerializedName("DescentAltitude")
    Double descentAltitude;
    @SerializedName("DescentTime")
    Double descentTime;
    @SerializedName("Distance")
    Integer distance;
    @SerializedName("Duration")
    Double duration;
    @SerializedName("Energy")
    Integer energy;
    @SerializedName("Feeling")
    Integer feeling;
    @SerializedName("FlatTime")
    Double flatTime;
    @SerializedName("HighAltitude")
    Float highAltitude;
    @SerializedName("LastModifiedDate")
    String lastModifiedDate;
    @SerializedName("LocalStartTime")
    String localStartTime;
    @SerializedName("LowAltitude")
    Float lowAltitude;
    @SerializedName("MaxBikeCadence")
    Float maxBikeCadence;
    @SerializedName("MaxRunningCadence")
    Float maxRunningCadence;
    @SerializedName("MaxSpeed")
    Float maxSpeed;
    @SerializedName("MaxTemp")
    Float maxTemp;
    @SerializedName("MinTemp")
    Float minTemp;
    @SerializedName("MaxPower")
    Float maxPower;
    @SerializedName("MemberID")
    Integer memberId;
    @SerializedName("MinHR")
    Integer minHR;
    @SerializedName("MIntegeremp")
    Float mIntegeremp;
    @SerializedName("MoveID")
    Integer moveId;
    @SerializedName("Notes")
    String notes;
    @SerializedName("PeakHR")
    Integer peakHR;
    @SerializedName("SessionName")
    String sessionName;
    @SerializedName("StartLatitude")
    Double startLatitude;
    @SerializedName("StartLongitute")
    Double startLongitute;
    @SerializedName("Tags")
    String tags;
    @SerializedName("TrainingEffect")
    Float trainingEffect;
    @SerializedName("Weather")
    Integer weather;
    @SerializedName("DeviceName")
    String deviceName;
    @SerializedName("DeviceSerialNumber")
    String deviceSerialNumber;
    @SerializedName("Samples")
    Move.Samples samples;
    @SerializedName("Track")
    Move.Track track;
    @SerializedName("Marks")
    Collection<MoveMark> marks;

    @AllArgsConstructor
    @Data
    public static class Track {
        @SerializedName("TrackPoints")
        Collection<TrackPoint> trackPoints;
    }

    @AllArgsConstructor
    @Data
    public static class Samples {
        @SerializedName("SampleSets")
        Collection<SampleSet> sampleSets;
    }
}
