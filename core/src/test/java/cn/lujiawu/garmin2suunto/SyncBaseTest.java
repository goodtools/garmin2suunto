package cn.lujiawu.garmin2suunto;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import cn.lujiawu.garmin2suunto.util.AutoLoginer;
import okhttp3.logging.HttpLoggingInterceptor;

public class SyncBaseTest {

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String userName = properties.getProperty("email");
        String key = properties.getProperty("key");

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);


        SyncInitializer.init(new AutoLoginer(), userName, key, logging);
    }

}
