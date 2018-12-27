package cn.lujiawu.garmin2suunto.garmin.api;

import at.meeximum.activitymoverfx.models.gson.garmin.Activity;
import at.meeximum.activitymoverfx.models.json.garmin.GActivityDetails;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

import java.util.List;

public interface ConnectApi {

    @GET("/modern/proxy/activity-service/activity/{id}")
    Observable<Activity> garminActivity(@Path("id") String id);

    @GET("/modern/proxy/activity-service/activity/{id}/details")
    Observable<GActivityDetails> garminActivityDetails(@Path("id") String id);

    @GET("/modern/proxy/activitylist-service/activities/search/activities?limit=20&start=0")
    Observable<List<Activity>> latest20();

}
