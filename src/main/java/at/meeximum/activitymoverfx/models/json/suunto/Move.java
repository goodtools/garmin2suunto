//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.json.suunto;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.Iterator;

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

    public Move() {
    }

    public void setActivityID(int var1) {
        this.activityID = var1;
    }

    public void setAscentAltitude(Double var1) {
        this.ascentAltitude = var1;
    }

    public void setAscentTime(Double var1) {
        this.ascentTime = var1;
    }

    public void setAvgBikeCadence(Float var1) {
        this.avgBikeCadence = var1;
    }

    public void setAvgRunningCadence(Float var1) {
        this.avgRunningCadence = var1;
    }

    public void setAvgHR(Integer var1) {
        this.avgHR = var1;
    }

    public void setAvgSpeed(Float var1) {
        this.avgSpeed = var1;
    }

    public void setAvgTemp(Float var1) {
        this.avgTemp = var1;
    }

    public void setAvgPower(Float var1) {
        this.avgPower = var1;
    }

    public void setDescentAltitude(Double var1) {
        this.descentAltitude = var1;
    }

    public void setDescentTime(Double var1) {
        this.descentTime = var1;
    }

    public void setDistance(Integer var1) {
        this.distance = var1;
    }

    public void setDuration(Double var1) {
        this.duration = var1;
    }

    public void setEnergy(Integer var1) {
        this.energy = var1;
    }

    public void setFeeling(Integer var1) {
        this.feeling = var1;
    }

    public void setFlatTime(Double var1) {
        this.flatTime = var1;
    }

    public Double getFlatTime() {
        return this.flatTime;
    }

    public void setHighAltitude(Float var1) {
        this.highAltitude = var1;
    }

    public void setLastModifiedDate(String var1) {
        this.lastModifiedDate = var1;
    }

    public void setLocalStartTime(String var1) {
        this.localStartTime = var1;
    }

    public void setLowAltitude(Float var1) {
        this.lowAltitude = var1;
    }

    public void setMaxBikeCadence(Float var1) {
        this.maxBikeCadence = var1;
    }

    public void setMaxRunningCadence(Float var1) {
        this.maxRunningCadence = var1;
    }

    public void setMaxSpeed(Float var1) {
        this.maxSpeed = var1;
    }

    public void setMaxTemp(Float var1) {
        this.maxTemp = var1;
    }

    public Float getAvgTemp() {
        return this.avgTemp;
    }

    public Float getMaxTemp() {
        return this.maxTemp;
    }

    public Float getMinTemp() {
        return this.minTemp;
    }

    public void setMinTemp(Float var1) {
        this.minTemp = var1;
    }

    public void setMaxPower(Float var1) {
        this.maxPower = var1;
    }

    public void setMemberId(Integer var1) {
        this.memberId = var1;
    }

    public void setMinHR(Integer var1) {
        this.minHR = var1;
    }

    public void setMIntegeremp(Float var1) {
        this.mIntegeremp = var1;
    }

    public void setMoveId(Integer var1) {
        this.moveId = var1;
    }

    public void setNotes(String var1) {
        this.notes = var1;
    }

    public String getNotes() {
        return this.notes;
    }

    public String getLocalStartTime() {
        return this.localStartTime;
    }

    public void setPeakHR(Integer var1) {
        this.peakHR = var1;
    }

    public void setSessionName(String var1) {
        this.sessionName = var1;
    }

    public void setStartLatitude(Double var1) {
        this.startLatitude = var1;
    }

    public Double getStartLatitude() {
        return this.startLatitude;
    }

    public void setStartLongitute(Double var1) {
        this.startLongitute = var1;
    }

    public Double getStartLongitute() {
        return this.startLongitute;
    }

    public void setTags(String var1) {
        this.tags = var1;
    }

    public void setTrainingEffect(Float var1) {
        this.trainingEffect = var1;
    }

    public void setWeather(Integer var1) {
        this.weather = var1;
    }

    public void setDeviceName(String var1) {
        this.deviceName = var1;
    }

    public void setDeviceSerialNumber(String var1) {
        this.deviceSerialNumber = var1;
    }

    public void setSamples(Move.Samples var1) {
        this.samples = var1;
    }

    public void setTrack(Move.Track var1) {
        this.track = var1;
    }

    public void setSamples(Collection<SampleSet> var1) {
        this.samples = new Move.Samples(var1);
    }

    public void setTrack(Collection<TrackPoint> var1) {
        this.track = new Move.Track(var1);
    }

    public void setMarks(Collection<MoveMark> var1) {
        this.marks = var1;
    }

    public void correct() {
        Integer var1 = 0;
        Float var2 = 0.0F;
        if (this.samples != null && this.samples.sampleSets != null) {
            Iterator var3 = this.samples.sampleSets.iterator();

            label38:
            while(true) {
                while(true) {
                    if (!var3.hasNext()) {
                        break label38;
                    }

                    SampleSet var4 = (SampleSet)var3.next();
                    Integer var5 = var4.power;
                    if (var5 != null && var5 <= 2000) {
                        var1 = var5;
                    } else {
                        var4.power = var1;
                    }

                    Float var6 = var4.energy;
                    if (var6 != null && var6 <= 1000.0F) {
                        var2 = var6;
                    } else {
                        var4.energy = var2;
                    }
                }
            }
        }

        if (this.energy != null && this.energy > 30000) {
            this.energy = 30000;
        }

    }

    class Track {
        @SerializedName("TrackPoints")
        Collection<TrackPoint> trackPoints;

        public Track(Collection<TrackPoint> var2) {
            this.trackPoints = var2;
        }
    }

    class Samples {
        @SerializedName("SampleSets")
        Collection<SampleSet> sampleSets;

        public Samples(Collection<SampleSet> var2) {
            this.sampleSets = var2;
        }
    }
}
