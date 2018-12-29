package cn.lujiawu.garmin2suunto.move.api;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MoveResult {
    @SerializedName("MoveID")
    String moveID;
    @SerializedName("SelfURI")
    String selfURI;
}