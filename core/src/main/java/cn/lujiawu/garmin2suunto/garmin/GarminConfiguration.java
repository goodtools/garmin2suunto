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

//        HttpUrl.Builder urlBuilder = HttpUrl.parse(SSO_GARMIN_CN + "/sso/signin")
//                .newBuilder().addQueryParameter("service", MODERN_URL).
//                        addQueryParameter("clientId", "GarminConnect").
//                        addQueryParameter("gauthHost", SSO_GARMIN_CN + "/sso").
//                        addQueryParameter("consumeServiceTicket", "false");
//
//        return urlBuilder.build().toString();
        return "https://sso.garmin.cn/sso/signin?service=https%3A%2F%2Fconnect.garmin.cn%2Fmodern%2F&webhost=https%3A%2F%2Fconnect.garmin.com&source=https%3A%2F%2Fconnect.garmin.cn%2Fzh-CN%2Fsignin%2F&redirectAfterAccountLoginUrl=https%3A%2F%2Fconnect.garmin.cn%2Fmodern%2F&redirectAfterAccountCreationUrl=https%3A%2F%2Fconnect.garmin.cn%2Fmodern%2F&gauthHost=https%3A%2F%2Fsso.garmin.cn%2Fsso&locale=zh&id=gauth-widget&cssUrl=https%3A%2F%2Fstatic.garmin.cn%2Fcom.garmin.connect%2Fui%2Fcss%2Fgauth-custom-cn-v1.3-min.css&privacyStatementUrl=%2F%2Fconnect.garmin.cn%2Fzh-CN%2Fprivacy%2F&clientId=GarminConnect&rememberMeShown=true&rememberMeChecked=false&createAccountShown=true&openCreateAccount=false&displayNameShown=false&consumeServiceTicket=false&initialFocus=true&embedWidget=false&generateExtraServiceTicket=false&generateTwoExtraServiceTickets=false&generateNoServiceTicket=false&globalOptInShown=true&globalOptInChecked=false&mobile=false&connectLegalTerms=true&locationPromptShown=true&showPassword=true";

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

    public static Request getLoginSubmitPostRequest(String userName, String password, String csrf) {

        String url = getSsoLoginPageUrl();

        FormBody.Builder builder = new FormBody.Builder()
                .add("_csrf", csrf)
                .add("embed", "true")
                .add("username", userName)
                .add("password", password);
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder().url(url).post(requestBody)
                .build();

        return request;

    }

}
