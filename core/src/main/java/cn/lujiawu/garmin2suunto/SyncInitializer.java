package cn.lujiawu.garmin2suunto;

import cn.lujiawu.garmin2suunto.garmin.AutoLogin;
import cn.lujiawu.garmin2suunto.garmin.AutoLoginInterceptor;
import cn.lujiawu.garmin2suunto.garmin.SimpleCookieJar;
import cn.lujiawu.garmin2suunto.util.AutoLoginer;
import cn.lujiawu.garmin2suunto.util.OkHttpClientManager;

public class SyncInitializer {

    private static boolean inited = false;

    public static void init(AutoLogin autoLogin, String suunUserEmail, String suuntoUserKey) {

        if (inited){
            return;
        }
        inited = true;

        SimpleCookieJar simpleCookieJar = new SimpleCookieJar();
        OkHttpClientManager.init(null, new AutoLoginInterceptor(autoLogin, simpleCookieJar), simpleCookieJar);

        ApiManager.init(suunUserEmail, suuntoUserKey);

    }


    public static void init(String userName, String password, String suunUserEmail, String suuntoUserKey) {

        AutoLogin autoLogin = new AutoLoginer(userName,password);

        init(autoLogin,suunUserEmail,suuntoUserKey);

    }


    public static void update(String suunUserEmail, String suuntoUserKey){
        ApiManager.updateSuunto(suunUserEmail,suuntoUserKey);
    }


}
