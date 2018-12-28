package cn.lujiawu.garmin2suunto.util;

import cn.lujiawu.garmin2suunto.garmin.GarminConnectApi;
import cn.lujiawu.garmin2suunto.util.OkHttpClientManager;

import java.io.FileInputStream;
import java.util.Properties;

public class AutoLoginer implements OkHttpClientManager.AutoLogin {

    @Override
    public boolean autoLogin(String url) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("config.properties"));
            String userName = properties.getProperty("username");
            String password = properties.getProperty("password");
            return new GarminConnectApi().login(userName, password);
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        }
    }
}
