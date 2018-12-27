//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package at.meeximum.activitymoverfx.models.gson.garmin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfoDto {
    @SerializedName("userProfilePk")
    @Expose
    private Integer userProfilePk;
    @SerializedName("displayname")
    @Expose
    private String displayname;
    @SerializedName("fullname")
    @Expose
    private String fullname;
    @SerializedName("profileImageUrlLarge")
    @Expose
    private Object profileImageUrlLarge;
    @SerializedName("profileImageUrlMedium")
    @Expose
    private Object profileImageUrlMedium;
    @SerializedName("profileImageUrlSmall")
    @Expose
    private Object profileImageUrlSmall;
    @SerializedName("userPro")
    @Expose
    private Boolean userPro;

    public UserInfoDto() {
    }

    public Integer getUserProfilePk() {
        return this.userProfilePk;
    }

    public void setUserProfilePk(Integer var1) {
        this.userProfilePk = var1;
    }

    public String getDisplayname() {
        return this.displayname;
    }

    public void setDisplayname(String var1) {
        this.displayname = var1;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String var1) {
        this.fullname = var1;
    }

    public Object getProfileImageUrlLarge() {
        return this.profileImageUrlLarge;
    }

    public void setProfileImageUrlLarge(Object var1) {
        this.profileImageUrlLarge = var1;
    }

    public Object getProfileImageUrlMedium() {
        return this.profileImageUrlMedium;
    }

    public void setProfileImageUrlMedium(Object var1) {
        this.profileImageUrlMedium = var1;
    }

    public Object getProfileImageUrlSmall() {
        return this.profileImageUrlSmall;
    }

    public void setProfileImageUrlSmall(Object var1) {
        this.profileImageUrlSmall = var1;
    }

    public Boolean getUserPro() {
        return this.userPro;
    }

    public void setUserPro(Boolean var1) {
        this.userPro = var1;
    }
}
