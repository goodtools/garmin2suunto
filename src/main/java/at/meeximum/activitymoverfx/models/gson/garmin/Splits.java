//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Splits {
    @SerializedName("activityId")
    @Expose
    private Long activityId;
    @SerializedName("lapDTOs")
    @Expose
    private List<LapDTO> lapDTOs = new ArrayList();
    @SerializedName("eventDTOs")
    @Expose
    private List<EventDTO> eventDTOs = new ArrayList();
    @SerializedName("wrbflag")
    @Expose
    private String wrbflag;

    public Splits() {
    }

    public Long getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Long var1) {
        this.activityId = var1;
    }

    public List<LapDTO> getLapDTOs() {
        return this.lapDTOs;
    }

    public void setLapDTOs(List<LapDTO> var1) {
        this.lapDTOs = var1;
    }

    public List<EventDTO> getEventDTOs() {
        return this.eventDTOs;
    }

    public void setEventDTOs(List<EventDTO> var1) {
        this.eventDTOs = var1;
    }

    public String getWrbflag() {
        return this.wrbflag;
    }

    public void setWrbflag(String var1) {
        this.wrbflag = var1;
    }
}
