package cn.lujiawu.garmin2suunto.garmin.api;

import cn.lujiawu.garmin2suunto.AutoLoginer;
import cn.lujiawu.garmin2suunto.OkHttpClientManager;
import org.junit.BeforeClass;
import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class ConnectApiTest {

    private static ConnectApi garminConnectApi;

    @BeforeClass
    public static void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://connect.garmin.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(OkHttpClientManager.getInstance())
                .build();


        garminConnectApi = retrofit.create(ConnectApi.class);

        OkHttpClientManager.setAutoLogin(new AutoLoginer());

    }

    @Test
    public void test() throws Exception {

        garminConnectApi.latest20()
                .flatMap(activities -> Observable.from(activities))
                .map(activity -> {
                    System.out.println(activity.getActivityId());
                    System.out.println(activity.getActivityName());
                    return activity.getActivityId();
                })
                .subscribe();


    }


}