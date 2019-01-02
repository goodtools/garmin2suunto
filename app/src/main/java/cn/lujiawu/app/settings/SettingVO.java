package cn.lujiawu.app.settings;

import java.io.Serializable;

public class SettingVO implements Serializable,Cloneable {

    public String garminUserName = "";
    public String garminPassword = "";
    public String suuntoUserName = "";
    public String suuntoUserKey = "";

    @Override
    public SettingVO clone() {
        try {
            return (SettingVO) super.clone();
        } catch (CloneNotSupportedException e) {
            return new SettingVO();
        }
    }
}
