package cn.lujiawu.garmin2suunto.garmin;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

public class GarminConfiguration {

    public static final String MODERN_URL = "https://connect.garmin.cn/modern";
    public static final String GARMIN_CN = "https://connect.garmin.cn";
    public static final String SSO_GARMIN_CN = "https://sso.garmin.cn";

    public static String getSsoLoginPageUrl() {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(SSO_GARMIN_CN + "/sso/login")
                .newBuilder().addQueryParameter("service", MODERN_URL).
                        addQueryParameter("clientId", "GarminConnect").
                        addQueryParameter("gauthHost", SSO_GARMIN_CN + "/sso").
                        addQueryParameter("consumeServiceTicket", "false");

        return urlBuilder.build().toString();

    }

    public static Request getLoginPageRequest() {
        return new Request.Builder().get().url(getSsoLoginPageUrl()).build();
    }

    public static Request getLoginSubmitPostRequest(String userName, String password) {

        String url = getSsoLoginPageUrl();

        FormBody.Builder builder = new FormBody.Builder()
                .add("_eventId", "submit")
                .add("embed", "true")
                .add("username", userName)
                .add("password", password);
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder().url(url).post(requestBody)
                .build();

        return request;

    }

}
