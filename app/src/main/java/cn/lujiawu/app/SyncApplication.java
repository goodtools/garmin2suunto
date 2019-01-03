package cn.lujiawu.app;

import android.app.Application;

import java.util.Properties;

import cn.lujiawu.app.settings.SettingManager;
import cn.lujiawu.app.settings.SettingVO;
import cn.lujiawu.garmin2suunto.garmin.AutoLogin;
import cn.lujiawu.garmin2suunto.garmin.AutoLoginInterceptor;
import cn.lujiawu.garmin2suunto.garmin.GarminConnectApi;
import cn.lujiawu.garmin2suunto.garmin.SimpleCookieJar;
import cn.lujiawu.garmin2suunto.util.OkHttpClientManager;

public class SyncApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SettingManager.init(this);

        //初始化
        SimpleCookieJar simpleCookieJar = new SimpleCookieJar();
        OkHttpClientManager.init(null, new AutoLoginInterceptor(new GarminAutoLogin(), simpleCookieJar), simpleCookieJar);
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
