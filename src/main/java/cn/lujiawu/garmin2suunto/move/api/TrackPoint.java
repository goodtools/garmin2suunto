//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lujiawu.garmin2suunto.move.api;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class TrackPoint implements Serializable {
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

}
