package cn.lujiawu.app.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.UUID;

import cn.lujiawu.garmin2suunto.SyncInitializer;

public class SettingManager {

    private static SettingVO settingVO;
    private static SharedPreferences sharedPreferences;

    public static void init(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        settingVO = new SettingVO();
        settingVO.garminUserName = sharedPreferences.getString("garminUserName", "");
        settingVO.garminPassword = sharedPreferences.getString("garminPassword", "");
        settingVO.suuntoUserName = sharedPreferences.getString("suuntoUserName", "");
        settingVO.suuntoUserKey = sharedPreferences.getString("suuntoUserKey", UUID.randomUUID().toString());
    }

    public static SettingVO getInstance() {
        return settingVO.clone();
    }

    public static boolean save(SettingVO setting) {

        SyncInitializer.update(setting.suuntoUserName, setting.suuntoUserKey);

        settingVO = setting;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("garminUserName", setting.garminUserName);
        edit.putString("garminPassword", setting.garminPassword);
        edit.putString("suuntoUserKey", setting.suuntoUserKey);
        edit.putString("suuntoUserName", setting.suuntoUserName);
        return edit.commit();
    }


}
