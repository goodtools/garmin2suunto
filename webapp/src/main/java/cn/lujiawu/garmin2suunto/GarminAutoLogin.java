package cn.lujiawu.garmin2suunto;

import cn.lujiawu.garmin2suunto.garmin.GarminConnectApi;
import cn.lujiawu.garmin2suunto.util.OkHttpClientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GarminAutoLogin implements OkHttpClientManager.AutoLogin {

    @Autowired
    private SyncConfig syncConfig;

    @Override
    public boolean autoLogin(String url) {
        try {
            String userName = syncConfig.getGarminUserName();
            String password = syncConfig.getGarminPasswd();
            return new GarminConnectApi().login(userName, password);
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        }
    }
}
