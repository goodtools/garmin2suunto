package cn.lujiawu.garmin2suunto;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Assert;
import org.junit.Test;

public class OKHttpTest {


    @Test
    public void logonGarmin() throws Exception {

        OkHttpClientManager.setAutoLogin(new AutoLoginer());
        OkHttpClient client = OkHttpClientManager.getInstance();

        String url = "https://connect.garmin.cn/modern/proxy/activity-service/activity/50360706";
        Request request = new Request.Builder().get().url(url).build();
        Response activity = client.newCall(request).execute();
        int code2 = activity.code();
        System.out.println(code2);
        System.out.println(activity);
        Assert.assertTrue(activity.isSuccessful());

//        Assert.assertTrue(new GarminConnectApi().login(userName,password));
    }

}
