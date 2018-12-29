//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lujiawu.garmin2suunto.move.api;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class MoveMark implements Serializable {
    @SerializedName("DistanceFromPrevious")
    int distanceFromPrevious;
    @SerializedName("SplitTimeFromPrevious")
    Double splitTimeFromPrevious;
    @SerializedName("Type")
    int type;
    @SerializedName("Notes")
    String notes;
}
