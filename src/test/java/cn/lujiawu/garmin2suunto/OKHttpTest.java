package cn.lujiawu.garmin2suunto;

import cn.lujiawu.garmin2suunto.garmin.GarminConfiguration;
import cn.lujiawu.garmin2suunto.garmin.GarminConnectApi;
import okhttp3.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OKHttpTest {


    @Test
    public void logonGarmin() throws Exception {

        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));

        String userName = properties.getProperty("username");
        String password = properties.getProperty("password");

        OkHttpClient client = OkHttpClientManager.getInstance();
        Assert.assertTrue(new GarminConnectApi().login(userName,password));

        String url = "https://connect.garmin.cn/modern/proxy/activity-service/activity/50360706";
        Request request = new Request.Builder().get().url(url).build();
        Response activity = client.newCall(request).execute();
        int code2 = activity.code();
        System.out.println(code2);
        System.out.println(activity.body().string());

//        client.newCall(request)
//
//
//        System.out.println(userName);
//
////
////
////
////
////        String var2 = var1.getUserGarmin();
////        String var3 = var1.getPassGarmin();
////        if (StringUtils.isNotBlank(var2) && !this.garminLoggedIn) {
//            BasicHttpParams var6 = new BasicHttpParams();
//            var6.setParameter("http.protocol.handle-redirects", false);
//            DefaultHttpClient var7 = new DefaultHttpClient();
//            var7.setParams(var6);
//            DecompressingHttpClient var8 = new DecompressingHttpClient(var7);
//            this.garminExecutor = Executor.newInstance(var8);
//            URIBuilder var9 = new URIBuilder();
//            var9.setScheme("https").setHost("sso.garmin.cn").setPath("/sso/login").
//                    setParameter("service", "http://connect.garmin.cn/modern").
//                    setParameter("clientId", "GarminConnect").
//                    setParameter("gauthHost", "https://sso.garmin.cn/sso").
//                    setParameter("consumeServiceTicket", "false");
//            URI var10 = var9.build();
//            Request var11 = Request.Get(var10).version(HttpVersion.HTTP_1_1);
//            HttpResponse var4 = this.garminExecute(var11).returnResponse();
//            //跳转到sso地址页面
//            System.out.println(">>>> " + var4.getStatusLine().getStatusCode());
//
//            HttpEntity var5 = var4.getEntity();
//            String var12 = EntityUtils.toString(var5, Consts.UTF_8);
//            ArrayList var13 = new ArrayList();
//            var13.add(new BasicNameValuePair("_eventId", "submit"));
//            var13.add(new BasicNameValuePair("embed", "true"));
//            var13.add(new BasicNameValuePair("password", var3));
//            var13.add(new BasicNameValuePair("username", var2));
//            var11 = Request.Post(var10).body(new UrlEncodedFormEntity(var13, Consts.UTF_8));
//            var4 = this.garminExecute(var11).returnResponse();
//
//            System.out.println(var4);
//            if (var4.getStatusLine().getStatusCode() != 200){
//                System.out.println("error!!!!");
//            }
//
//            var5 = var4.getEntity();
//
//            var12 = EntityUtils.toString(var5, Consts.UTF_8);
//            var9 = new URIBuilder();
//            var9.setScheme("https").setHost("connect.garmin.cn").setPath("/modern");
//            var10 = var9.build();
//            var11 = Request.Get(var10);
//
//            for(var4 = this.garminExecute(var11).returnResponse(); var4.getStatusLine().getStatusCode() == 302; var4 = this.garminExecute(var11).returnResponse()) {
//                String var14 = var4.getFirstHeader("Location").getValue();
//                if (var14.startsWith("/")) {
//                    var14 = "https://connect.garmin.cn" + var14;
//                }
//
//                var11 = Request.Get(var14);
//            }
//
//            int var15 = var4.getStatusLine().getStatusCode();
//            if (var15 != 200 && var15 != 404) {
//                throw new Exception(var4.getStatusLine().toString());
//            }
//
//            this.garminLoggedIn = true;


    }

}
