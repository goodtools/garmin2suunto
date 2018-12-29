package cn.lujiawu.garmin2suunto.util;

import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OkHttpClientManager {

    public static AutoLogin autoLogin;

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

            Response response = chain.proceed(request);
            if (response.code() != 200 && response.code() != 304 && response.code() != 403) {
                printResponse(response);
            }

            if (response.code() == 403 && null != OkHttpClientManager.autoLogin) {

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

        private void printResponse(Response response) throws IOException {
            ResponseBody body = response.body();
            try {
                System.err.println(response.code());
                System.err.println(response.headers());
                System.err.println(body.string());
            } finally {
                body.close();
            }
        }

    }
}
