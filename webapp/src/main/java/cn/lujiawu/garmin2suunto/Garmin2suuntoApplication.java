package cn.lujiawu.garmin2suunto;

import cn.lujiawu.garmin2suunto.util.AutoLoginer;
import cn.lujiawu.garmin2suunto.util.OkHttpClientManager;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.logging.Level;
import java.util.logging.Logger;

@EnableConfigurationProperties
@SpringBootApplication
public class Garmin2suuntoApplication implements InitializingBean {

    @Autowired
    private SyncConfig syncConfig;
    @Autowired
    private GarminAutoLogin autoLogin;


    public static void main(String[] args) {
        SpringApplication.run(Garmin2suuntoApplication.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (!syncConfig.validate()){
            throw new RuntimeException("sync config is error " + syncConfig);
        }

        OkHttpClientManager.setAutoLogin(autoLogin);

        Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);
    }

}

