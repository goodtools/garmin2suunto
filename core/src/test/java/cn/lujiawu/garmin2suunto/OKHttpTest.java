package cn.lujiawu.garmin2suunto;

import cn.lujiawu.garmin2suunto.util.AutoLoginer;
import cn.lujiawu.garmin2suunto.util.OkHttpClientManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Assert;
import org.junit.Test;

public class OKHttpTest {


    @Test
    public void logonGarmin() throws Exception {

        OkHttpClientManager.init();
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

    @Test
    public void testSuunto() throws Exception {

        OkHttpClient client = OkHttpClientManager.getInstance();
        String url = "https://uiservices.movescount.com/moves/private?version=1.1.0&appkey=uFiPE28bwLykgnTlYyvlS7GzgaAcIRP3I85FCMFJUDFwTa7hcAihvk7x9SJEC5CP&email=jiawu.lu@gmail.com&userkey=e4acbce2-4a3e-4f34-b806-d81694f59384";
        Request request = new Request.Builder().get().url(url).build();
        Response activity = client.newCall(request).execute();
        int code2 = activity.code();
        System.out.println(code2);
        System.out.println(activity);
        Assert.assertTrue(activity.isSuccessful());

//        Assert.assertTrue(new GarminConnectApi().login(userName,password));
    }

}
