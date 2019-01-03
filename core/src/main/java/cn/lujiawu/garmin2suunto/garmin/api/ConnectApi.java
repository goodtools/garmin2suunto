package cn.lujiawu.garmin2suunto.garmin.api;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ConnectApi {

    @GET("/modern/proxy/activity-service/activity/{id}")
    Single<Activity> garminActivity(@Path("id") String id);

    @GET("/modern/proxy/activity-service/activity/{id}/details")
    Single<ActivityDetail> garminActivityDetails(@Path("id") String id);

    @GET("/modern/proxy/activity-service/activity/{id}/splits")
    Single<ActivitySplits> garminActivitySplits(@Path("id") String id);

    @GET("/modern/proxy/activitylist-service/activities/search/activities?limit=20&start=0")
    Single<List<ActivityItem>> latest20();

    @GET("/modern/proxy/activitylist-service/activities/search/activities")
    Single<List<ActivityItem>> search(@Query("limit") int limit, @Query("start") int start);

    @GET("/modern/proxy/activitylist-service/activities/search/activities?limit=1000")
    Single<List<ActivityItem>> search(@Query("startDate") String startDate);


}
