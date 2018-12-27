package cn.lujiawu.garmin2suunto;

import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

import java.util.ArrayList;
import java.util.List;

public class OkHttpClientManager {

    private static OkHttpClient okHttpClient;

    public static synchronized OkHttpClient getInstance() {

        if (null != okHttpClient) {
            return okHttpClient;
        }

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        okHttpClient = builder
                .cookieJar(new SimpleCookieJar())
                .followSslRedirects(true)
                .followRedirects(false)
                .build();

        return okHttpClient;

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
}
