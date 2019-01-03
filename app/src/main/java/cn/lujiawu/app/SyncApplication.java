package cn.lujiawu.app;

import android.app.Application;

import cn.lujiawu.app.settings.SettingManager;
import cn.lujiawu.app.settings.SettingVO;
import cn.lujiawu.garmin2suunto.SyncInitializer;
import cn.lujiawu.garmin2suunto.garmin.AutoLogin;
import cn.lujiawu.garmin2suunto.garmin.GarminConnectApi;

public class SyncApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SettingManager.init(this);

        //初始化
        SettingVO instance = SettingManager.getInstance();
        SyncInitializer.init(new GarminAutoLogin(), instance.suuntoUserName, instance.suuntoUserKey);
    }


    public static class GarminAutoLogin implements AutoLogin {

        @Override
        public boolean autoLogin(String url) {
            try {
                SettingVO instance = SettingManager.getInstance();
                return new GarminConnectApi().login(instance.garminUserName, instance.garminPassword);
            } catch (Throwable e) {
                e.printStackTrace();
                return false;
            }
        }

    }

}
