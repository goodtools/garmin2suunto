package cn.lujiawu.garmin2suunto.util;

import cn.lujiawu.garmin2suunto.garmin.AutoLogin;
import cn.lujiawu.garmin2suunto.garmin.GarminConnectApi;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class AutoLoginer implements AutoLogin {

    private String userName;
    private String password;

    public AutoLoginer(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public AutoLoginer() {
    }

    @Override
    public boolean autoLogin(String url) {
        try {
            if (StringUtils.isEmpty(userName)) {
                Properties properties = new Properties();
                properties.load(new FileInputStream("config.properties"));
                userName = properties.getProperty("username");
                password = properties.getProperty("password");
            }
            return new GarminConnectApi().login(userName, password);
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        }
    }


}
