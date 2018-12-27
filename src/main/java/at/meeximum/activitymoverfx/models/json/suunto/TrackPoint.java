//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.json.suunto;

import com.google.gson.annotations.SerializedName;

public class TrackPoint {
    @SerializedName("Altitude")
    Float altitude;
    @SerializedName("Bearing")
    Float bearing;
    @SerializedName("EHPE")
    Float ehpe;
    @SerializedName("Latitude")
    Double latitude;
    @SerializedName("LocalTime")
    String localTime;
    @SerializedName("Longitude")
    Double longitude;
    @SerializedName("Speed")
    Double speed;

    public TrackPoint() {
    }

    public void setAltitude(Float var1) {
        this.altitude = var1;
    }

    public void setBearing(Float var1) {
        this.bearing = var1;
    }

    public void setEhpe(Float var1) {
        this.ehpe = var1;
    }

    public void setLatitude(Double var1) {
        this.latitude = var1;
    }

    public void setLocalTime(String var1) {
        this.localTime = var1;
    }

    public String getLocalTime() {
        return this.localTime;
    }

    public void setLongitude(Double var1) {
        this.longitude = var1;
    }

    public void setSpeed(Double var1) {
        this.speed = var1;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }
}
