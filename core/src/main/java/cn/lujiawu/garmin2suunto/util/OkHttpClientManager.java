package cn.lujiawu.garmin2suunto.util;

import cn.lujiawu.garmin2suunto.garmin.AutoLoginInterceptor;
import cn.lujiawu.garmin2suunto.garmin.SimpleCookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

public class OkHttpClientManager {

    private static Interceptor autoLoginInterceptor;
    private static Interceptor loggingInterceptor;
    private static SimpleCookieJar cookieJar;

    private static OkHttpClient okHttpClient;

    public static void init(Interceptor loggingInterceptor, Interceptor autoLoginInterceptor, SimpleCookieJar simpleCookieJar) {
        OkHttpClientManager.autoLoginInterceptor = autoLoginInterceptor;
        OkHttpClientManager.loggingInterceptor = loggingInterceptor;
        OkHttpClientManager.cookieJar = simpleCookieJar;
    }

    public static void init() {
        SimpleCookieJar simpleCookieJar = new SimpleCookieJar();
        OkHttpClientManager.init(null, new AutoLoginInterceptor(new AutoLoginer(), simpleCookieJar), simpleCookieJar);
    }

    public static synchronized OkHttpClient getInstance() {


        if (null != okHttpClient) {
            return okHttpClient;
        }

        if (null == cookieJar){
            OkHttpClientManager.init();
        }

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cookieJar(cookieJar)
                .followSslRedirects(true)
                .followRedirects(false);

        if (null != loggingInterceptor) {
            builder.addInterceptor(loggingInterceptor);
        }
        if (null != autoLoginInterceptor) {
            builder.addInterceptor(autoLoginInterceptor);
        }

        okHttpClient = builder.build();

        return okHttpClient;
    }


}
