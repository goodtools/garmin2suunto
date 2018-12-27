//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Activity {
    @SerializedName("activityId")
    @Expose
    private Long activityId;
    @SerializedName("activityName")
    @Expose
    private String activityName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("userProfileId")
    @Expose
    private Integer userProfileId;
    @SerializedName("isMultiSportParent")
    @Expose
    private Boolean isMultiSportParent;
    @SerializedName("activityTypeDTO")
    @Expose
    private ActivityTypeDTO activityTypeDTO;
    @SerializedName("eventTypeDTO")
    @Expose
    private EventTypeDTO eventTypeDTO;
    @SerializedName("accessControlRuleDTO")
    @Expose
    private AccessControlRuleDTO accessControlRuleDTO;
    @SerializedName("timeZoneUnitDTO")
    @Expose
    private TimeZoneUnitDTO timeZoneUnitDTO;
    @SerializedName("metadataDTO")
    @Expose
    private MetadataDTO metadataDTO;
    @SerializedName("summaryDTO")
    @Expose
    private SummaryDTO summaryDTO;

    public Activity() {
    }

    public Long getActivityId() {
        return this.activityId;
    }

    public void setActivityId(Long var1) {
        this.activityId = var1;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public void setActivityName(String var1) {
        this.activityName = var1;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String var1) {
        this.description = var1;
    }

    public Integer getUserProfileId() {
        return this.userProfileId;
    }

    public void setUserProfileId(Integer var1) {
        this.userProfileId = var1;
    }

    public Boolean getIsMultiSportParent() {
        return this.isMultiSportParent;
    }

    public void setIsMultiSportParent(Boolean var1) {
        this.isMultiSportParent = var1;
    }

    public ActivityTypeDTO getActivityTypeDTO() {
        return this.activityTypeDTO;
    }

    public void setActivityTypeDTO(ActivityTypeDTO var1) {
        this.activityTypeDTO = var1;
    }

    public EventTypeDTO getEventTypeDTO() {
        return this.eventTypeDTO;
    }

    public void setEventTypeDTO(EventTypeDTO var1) {
        this.eventTypeDTO = var1;
    }

    public AccessControlRuleDTO getAccessControlRuleDTO() {
        return this.accessControlRuleDTO;
    }

    public void setAccessControlRuleDTO(AccessControlRuleDTO var1) {
        this.accessControlRuleDTO = var1;
    }

    public TimeZoneUnitDTO getTimeZoneUnitDTO() {
        return this.timeZoneUnitDTO;
    }

    public void setTimeZoneUnitDTO(TimeZoneUnitDTO var1) {
        this.timeZoneUnitDTO = var1;
    }

    public MetadataDTO getMetadataDTO() {
        return this.metadataDTO;
    }

    public void setMetadataDTO(MetadataDTO var1) {
        this.metadataDTO = var1;
    }

    public SummaryDTO getSummaryDTO() {
        return this.summaryDTO;
    }

    public void setSummaryDTO(SummaryDTO var1) {
        this.summaryDTO = var1;
    }
}
