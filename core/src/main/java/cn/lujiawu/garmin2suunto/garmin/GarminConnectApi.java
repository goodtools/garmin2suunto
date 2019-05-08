package cn.lujiawu.garmin2suunto.garmin;

import cn.lujiawu.garmin2suunto.util.OkHttpClientManager;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GarminConnectApi {

    public boolean login(String userName, String password) throws Exception {

        OkHttpClient client = OkHttpClientManager.getInstance();

        String csrf = "";
        try(Response response = client.newCall(GarminConfiguration.getLoginPageRequest()).execute();){
            if (!response.isSuccessful()) {
                return false;
            }

            String string = response.body().string();
            String prefix = "<input type=\"hidden\" name=\"_csrf\" value=\"";
            int length = prefix.length();
            int start = string.indexOf(prefix) + length;
            int end = string.indexOf("\"",start);
            csrf = string.substring(start,end);
        }

        try(Response submit = client.newCall(GarminConfiguration.getLoginSubmitPostRequest(userName, password,csrf)).execute();){
            if (!submit.isSuccessful()) {
                return false;
            }
        }

        String afterLoginUrl = GarminConfiguration.MODERN_URL;
        int times = 0;
        while (true) {
            Request afterRequest = new Request.Builder().get().url(afterLoginUrl).build();
            Call call = client.newCall(afterRequest);
            try(Response redirectResponse = call.execute();){
                if (!redirectResponse.isRedirect()) {
                    break;
                }
                afterLoginUrl = redirectResponse.header("Location");
                if (afterLoginUrl.startsWith("/")) {
                    afterLoginUrl = GarminConfiguration.GARMIN_CN + afterLoginUrl;
                }
                if (times++ > 5) {
                    return false;
                }
            }
        }

        return true;

    }

}
