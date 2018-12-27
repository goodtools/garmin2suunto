package cn.lujiawu.garmin2suunto.garmin;

import cn.lujiawu.garmin2suunto.OkHttpClientManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GarminConnectApi {

    public boolean login(String userName, String password) throws Exception {

        OkHttpClient client = OkHttpClientManager.getInstance();

        Response response = client.newCall(GarminConfiguration.getLoginPageRequest()).execute();

        if (!response.isSuccessful()) {
            return false;
        }

        Response submit = client.newCall(GarminConfiguration.getLoginSubmitPostRequest(userName, password)).execute();
        if (!submit.isSuccessful()) {
            return false;
        }

        String afterLoginUrl = GarminConfiguration.MODERN_URL;
        int times = 0;
        while (true) {
            Request afterRequest = new Request.Builder().get().url(afterLoginUrl).build();
            Response execute = client.newCall(afterRequest).execute();
            if (!execute.isRedirect()) {
                break;
            }
            afterLoginUrl = execute.header("Location");
            if (afterLoginUrl.startsWith("/")) {
                afterLoginUrl = GarminConfiguration.GARMIN_CN + afterLoginUrl;
            }
            if (times++ > 5) {
                return false;
            }
        }

        return true;

    }

}
