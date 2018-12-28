package cn.lujiawu.garmin2suunto.garmin.api;

import at.meeximum.activitymoverfx.models.gson.garmin.Activity;
import at.meeximum.activitymoverfx.models.json.garmin.GActivityDetails;
import cn.lujiawu.garmin2suunto.AutoLoginer;
import cn.lujiawu.garmin2suunto.OkHttpClientManager;
import cn.lujiawu.garmin2suunto.garmin.ActivityWrapper;
import org.junit.BeforeClass;
import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

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
    public void testWrongWay() throws Exception {

        Observable<Observable<ActivityWrapper>> map = garminConnectApi.latest20()
                .flatMap(activities -> Observable.from(activities))
                .map(activity -> {
                    String activityId = activity.getActivityId().toString();
                    Observable<Activity> activityObservable = garminConnectApi.garminActivity(activityId);
                    Observable<GActivityDetails> detailsObservable = garminConnectApi.garminActivityDetails(activityId);
                    Observable<ActivityWrapper> activityWrapperObservable =
                            activityObservable.zipWith(detailsObservable, (act, detail) -> new ActivityWrapper(activityId, act, detail));
                    return activityWrapperObservable;
                }).observeOn(Schedulers.newThread());

        Observable.switchOnNext(map)
                .subscribe(item -> System.out.println(item.getActivity().getActivityName()));


    }

    @Test
    public void testParal() throws Exception {

        garminConnectApi.latest20()
                .flatMap(activities -> Observable.from(activities))
                .flatMap(activity -> {
                    String activityId = activity.getActivityId().toString();
                    Observable<Activity> activityObservable = garminConnectApi.garminActivity(activityId);
                    Observable<GActivityDetails> detailsObservable = garminConnectApi.garminActivityDetails(activityId);
                    Observable<ActivityWrapper> activityWrapperObservable =
                            activityObservable.zipWith(detailsObservable, (act, detail) -> new ActivityWrapper(activityId, act, detail));
                    return activityWrapperObservable
                            .observeOn(Schedulers.newThread())
                            .subscribeOn(Schedulers.newThread());
                })
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(wapper -> {
                    System.out.println(Thread.currentThread().getName() + ">>>" + wapper.getId());
                    System.out.println(wapper.getActivity().getActivityName());
                });

        Thread.sleep(200000);


    }


}