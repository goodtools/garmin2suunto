//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MetadataDTO {
    @SerializedName("isOriginal")
    @Expose
    private Boolean isOriginal;
    @SerializedName("deviceApplicationInstallationId")
    @Expose
    private Integer deviceApplicationInstallationId;
    @SerializedName("agentApplicationInstallationId")
    @Expose
    private Integer agentApplicationInstallationId;
    @SerializedName("agentString")
    @Expose
    private Object agentString;
    @SerializedName("fileFormat")
    @Expose
    private FileFormat fileFormat;
    @SerializedName("associatedCourseId")
    @Expose
    private Object associatedCourseId;
    @SerializedName("lastUpdateDate")
    @Expose
    private String lastUpdateDate;
    @SerializedName("uploadedDate")
    @Expose
    private String uploadedDate;
    @SerializedName("videoUrl")
    @Expose
    private Object videoUrl;
    @SerializedName("hasPolyline")
    @Expose
    private Boolean hasPolyline;
    @SerializedName("hasChartData")
    @Expose
    private Boolean hasChartData;
    @SerializedName("hasHrTimeInZones")
    @Expose
    private Boolean hasHrTimeInZones;
    @SerializedName("hasPowerTimeInZones")
    @Expose
    private Boolean hasPowerTimeInZones;
    @SerializedName("userInfoDto")
    @Expose
    private UserInfoDto userInfoDto;
    @SerializedName("chartAvailability")
    @Expose
    private ChartAvailability chartAvailability;
    @SerializedName("childIds")
    @Expose
    private List<Object> childIds = new ArrayList();
    @SerializedName("sensors")
    @Expose
    private Object sensors;
    @SerializedName("elevationCorrected")
    @Expose
    private Boolean elevationCorrected;
    @SerializedName("personalRecord")
    @Expose
    private Boolean personalRecord;
    @SerializedName("manualActivity")
    @Expose
    private Boolean manualActivity;
    @SerializedName("autoCalcCalories")
    @Expose
    private Boolean autoCalcCalories;
    @SerializedName("favorite")
    @Expose
    private Boolean favorite;
    @SerializedName("gcj02")
    @Expose
    private Boolean gcj02;

    public MetadataDTO() {
    }

    public Boolean getIsOriginal() {
        return this.isOriginal;
    }

    public void setIsOriginal(Boolean var1) {
        this.isOriginal = var1;
    }

    public Integer getDeviceApplicationInstallationId() {
        return this.deviceApplicationInstallationId;
    }

    public void setDeviceApplicationInstallationId(Integer var1) {
        this.deviceApplicationInstallationId = var1;
    }

    public Integer getAgentApplicationInstallationId() {
        return this.agentApplicationInstallationId;
    }

    public void setAgentApplicationInstallationId(Integer var1) {
        this.agentApplicationInstallationId = var1;
    }

    public Object getAgentString() {
        return this.agentString;
    }

    public void setAgentString(Object var1) {
        this.agentString = var1;
    }

    public FileFormat getFileFormat() {
        return this.fileFormat;
    }

    public void setFileFormat(FileFormat var1) {
        this.fileFormat = var1;
    }

    public Object getAssociatedCourseId() {
        return this.associatedCourseId;
    }

    public void setAssociatedCourseId(Object var1) {
        this.associatedCourseId = var1;
    }

    public String getLastUpdateDate() {
        return this.lastUpdateDate;
    }

    public void setLastUpdateDate(String var1) {
        this.lastUpdateDate = var1;
    }

    public String getUploadedDate() {
        return this.uploadedDate;
    }

    public void setUploadedDate(String var1) {
        this.uploadedDate = var1;
    }

    public Object getVideoUrl() {
        return this.videoUrl;
    }

    public void setVideoUrl(Object var1) {
        this.videoUrl = var1;
    }

    public Boolean getHasPolyline() {
        return this.hasPolyline;
    }

    public void setHasPolyline(Boolean var1) {
        this.hasPolyline = var1;
    }

    public Boolean getHasChartData() {
        return this.hasChartData;
    }

    public void setHasChartData(Boolean var1) {
        this.hasChartData = var1;
    }

    public Boolean getHasHrTimeInZones() {
        return this.hasHrTimeInZones;
    }

    public void setHasHrTimeInZones(Boolean var1) {
        this.hasHrTimeInZones = var1;
    }

    public Boolean getHasPowerTimeInZones() {
        return this.hasPowerTimeInZones;
    }

    public void setHasPowerTimeInZones(Boolean var1) {
        this.hasPowerTimeInZones = var1;
    }

    public UserInfoDto getUserInfoDto() {
        return this.userInfoDto;
    }

    public void setUserInfoDto(UserInfoDto var1) {
        this.userInfoDto = var1;
    }

    public ChartAvailability getChartAvailability() {
        return this.chartAvailability;
    }

    public void setChartAvailability(ChartAvailability var1) {
        this.chartAvailability = var1;
    }

    public List<Object> getChildIds() {
        return this.childIds;
    }

    public void setChildIds(List<Object> var1) {
        this.childIds = var1;
    }

    public Object getSensors() {
        return this.sensors;
    }

    public void setSensors(Object var1) {
        this.sensors = var1;
    }

    public Boolean getElevationCorrected() {
        return this.elevationCorrected;
    }

    public void setElevationCorrected(Boolean var1) {
        this.elevationCorrected = var1;
    }

    public Boolean getPersonalRecord() {
        return this.personalRecord;
    }

    public void setPersonalRecord(Boolean var1) {
        this.personalRecord = var1;
    }

    public Boolean getManualActivity() {
        return this.manualActivity;
    }

    public void setManualActivity(Boolean var1) {
        this.manualActivity = var1;
    }

    public Boolean getAutoCalcCalories() {
        return this.autoCalcCalories;
    }

    public void setAutoCalcCalories(Boolean var1) {
        this.autoCalcCalories = var1;
    }

    public Boolean getFavorite() {
        return this.favorite;
    }

    public void setFavorite(Boolean var1) {
        this.favorite = var1;
    }

    public Boolean getGcj02() {
        return this.gcj02;
    }

    public void setGcj02(Boolean var1) {
        this.gcj02 = var1;
    }
}
