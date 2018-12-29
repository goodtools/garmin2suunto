package cn.lujiawu.garmin2suunto;

import cn.lujiawu.garmin2suunto.garmin.AutoLogin;
import cn.lujiawu.garmin2suunto.garmin.GarminConnectApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GarminAutoLogin implements AutoLogin {

    @Autowired
    private SyncConfig syncConfig;

    @Override
    public boolean autoLogin(String url) {
        try {
            String userName = syncConfig.getGarminUserName();
            String password = syncConfig.getGarminPasswd();
            return new GarminConnectApi().login(userName, password);
        } catch (Throwable e) {
            log.error("login exception", e);
            return false;
        }
    }
}
