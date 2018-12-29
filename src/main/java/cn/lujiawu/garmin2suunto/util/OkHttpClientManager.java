package cn.lujiawu.garmin2suunto.util;

import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OkHttpClientManager {

    private static AutoLogin autoLogin;

    private static OkHttpClient okHttpClient;

    public static void setAutoLogin(AutoLogin autoLogin) {
        OkHttpClientManager.autoLogin = autoLogin;
    }

    public static synchronized OkHttpClient getInstance() {

        if (null != okHttpClient) {
            return okHttpClient;
        }

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        okHttpClient = builder
                .cookieJar(new SimpleCookieJar())
                .followSslRedirects(true)
                .followRedirects(false)
                .addInterceptor(new AutoLoginResponseInterceptor())
                .build();

        return okHttpClient;

    }

    public static interface AutoLogin {
        public boolean autoLogin(String url);
    }

    private static class SimpleCookieJar implements CookieJar {

        private final List cookieStore = new ArrayList();

        @Override
        public void saveFromResponse(HttpUrl url, List cookies) {
//                        cookieStore.clear();
            cookieStore.addAll(cookies);
        }

        @Override
        public List loadForRequest(HttpUrl url) {
//            System.out.println(">>>>> " + url.toString());
//                        cookieStore.stream().forEach(System.out::println);
            return cookieStore;
        }
    }

    private static class AutoLoginResponseInterceptor implements Interceptor {

        private final String TAG = getClass().getSimpleName();

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

//            System.out.println(" >>> request " + request.url().toString());
            Response response = chain.proceed(request);
//            System.out.println(" <<< response " + request.url().toString());

//            System.out.println(" >>>> intercepter " );
//            System.out.println(response);

            if (response.code() == 400){
                System.err.println(response.headers());
                System.err.println(response.body().string());
            }

            if (response.code() == 403 && null != OkHttpClientManager.autoLogin) {

                System.err.println(response);
                boolean success = OkHttpClientManager.autoLogin.autoLogin(request.url().host());

                if (success) {
                    System.out.println("auto login success! ");
                    response = chain.proceed(request);
                } else {
                    System.err.println("auto login fail! ");
                }
            }

            return response;
        }

    }
}
