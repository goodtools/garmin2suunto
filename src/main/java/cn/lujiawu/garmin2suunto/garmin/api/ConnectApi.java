package cn.lujiawu.garmin2suunto.garmin.api;

import at.meeximum.activitymoverfx.models.gson.garmin.Activity;
import at.meeximum.activitymoverfx.models.gson.garmin.Splits;
import at.meeximum.activitymoverfx.models.json.garmin.ActivityDetail;
import at.meeximum.activitymoverfx.models.json.garmin.ActivityItem;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import java.util.List;

public interface ConnectApi {

    @GET("/modern/proxy/activity-service/activity/{id}")
    Observable<Activity> garminActivity(@Path("id") String id);

    @GET("/modern/proxy/activity-service/activity/{id}/details")
    Observable<ActivityDetail> garminActivityDetails(@Path("id") String id);

    @GET("/modern/proxy/activity-service/activity/{id}/splits")
    Observable<Splits> garminActivitySplits(@Path("id") String id);

    @GET("/modern/proxy/activitylist-service/activities/search/activities?limit=20&start=0")
    Observable<List<ActivityItem>> latest20();

    @GET("/modern/proxy/activitylist-service/activities/search/activities")
    Observable<List<ActivityItem>> search(@Query("limit") int limit, @Query("start") int start);

    @GET("/modern/proxy/activitylist-service/activities/search/activities?limit=1000")
    Observable<List<ActivityItem>> search(@Query("startDate") String startDate);


}
