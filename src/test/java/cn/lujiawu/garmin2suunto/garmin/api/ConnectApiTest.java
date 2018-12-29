package cn.lujiawu.garmin2suunto.garmin.api;

import at.meeximum.activitymoverfx.converter.GarminConverter;
import at.meeximum.activitymoverfx.models.json.suunto.Move;
import cn.lujiawu.garmin2suunto.util.AutoLoginer;
import cn.lujiawu.garmin2suunto.util.OkHttpClientManager;
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
                    Observable<ActivityDetail> detailsObservable = garminConnectApi.garminActivityDetails(activityId);
                    Observable<ActivityWrapper> activityWrapperObservable =
                            activityObservable.zipWith(detailsObservable, (act, detail) -> new ActivityWrapper(activityId, act, detail,null));
                    return activityWrapperObservable;
                }).observeOn(Schedulers.newThread());

        Observable.switchOnNext(map)
                .subscribe(item -> System.out.println(item.getActivity().getActivityName()));


    }

    @Test
    public void testParal() throws Exception {

        garminConnectApi.latest20()
                .flatMap(activities -> Observable.from(activities))
                .first()
                .flatMap(activity -> {
                    String activityId = activity.getActivityId().toString();

                    Observable<Activity> activityObservable = garminConnectApi.garminActivity(activityId);
                    Observable<ActivityDetail> detailsObservable = garminConnectApi.garminActivityDetails(activityId);
                    Observable<ActivitySplits> splitsObservable = garminConnectApi.garminActivitySplits(activityId);

                    Observable<ActivityWrapper> activityWrapperObservable =
                            Observable.zip(activityObservable, detailsObservable, splitsObservable,
                                    (a, b, c) -> new ActivityWrapper(activityId, a, b, c));

                    return activityWrapperObservable
                            .observeOn(Schedulers.newThread())
                            .subscribeOn(Schedulers.newThread());
                })
                .observeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(wapper -> {
                    System.out.println(Thread.currentThread().getName() + ">>>" + wapper.getId());
                    System.out.println(wapper.getActivity().getActivityName());
                    System.out.println(wapper.getActivity().getSummaryDTO().getStartTimeGMT());
                    System.out.println(wapper.getActivity().getSummaryDTO().getStartTimeLocal());

                    try {
                        Move move = GarminConverter.convert(wapper.getActivity(),wapper.getActivitySplits(),wapper.getDetails());
                        System.out.println(move);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                });

        Thread.sleep(200000);


    }


    @Test
    public void test3() throws Exception {

//        garminConnectApi.search("2018-08-08")
//                .flatMap(activities -> Observable.from(  activities))
//                .toList().subscribe()
//                .subscribe(activity -> {
//                    System.out.println(Thread.currentThread().getName() + ">>>" + activity.getActivityId());
//                    System.out.println(activity);
//                });



    }


}