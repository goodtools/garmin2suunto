package cn.lujiawu.garmin2suunto.garmin;

import okhttp3.CookieJar;
import okhttp3.HttpUrl;

import java.util.ArrayList;
import java.util.List;

public class SimpleCookieJar implements CookieJar {

    private final List cookieStore = new ArrayList();

    @Override
    public void saveFromResponse(HttpUrl url, List cookies) {
        cookieStore.addAll(cookies);
    }

    @Override
    public List loadForRequest(HttpUrl url) {
        return cookieStore;
    }

    public void clear() {
        cookieStore.clear();
    }
}