//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventDTO {
    @SerializedName("startTimeGMT")
    @Expose
    private String startTimeGMT;
    @SerializedName("sectionTypeDTO")
    @Expose
    private SectionTypeDTO sectionTypeDTO;

    public EventDTO() {
    }

    public String getStartTimeGMT() {
        return this.startTimeGMT;
    }

    public void setStartTimeGMT(String var1) {
        this.startTimeGMT = var1;
    }

    public SectionTypeDTO getSectionTypeDTO() {
        return this.sectionTypeDTO;
    }

    public void setSectionTypeDTO(SectionTypeDTO var1) {
        this.sectionTypeDTO = var1;
    }
}
