package cn.lujiawu.garmin2suunto;

import at.meeximum.activitymoverfx.converter.GarminConverter;
import cn.lujiawu.garmin2suunto.garmin.api.Activity;
import cn.lujiawu.garmin2suunto.garmin.api.ActivitySplits;
import cn.lujiawu.garmin2suunto.garmin.api.ActivityDetail;
import cn.lujiawu.garmin2suunto.garmin.api.ActivityItem;
import at.meeximum.activitymoverfx.models.json.suunto.Move;
import at.meeximum.activitymoverfx.models.json.suunto.MoveItem;
import cn.lujiawu.garmin2suunto.garmin.GarminConfiguration;
import cn.lujiawu.garmin2suunto.garmin.api.ConnectApi;
import cn.lujiawu.garmin2suunto.move.api.MoveApi;
import cn.lujiawu.garmin2suunto.move.api.MoveResult;
import cn.lujiawu.garmin2suunto.util.AutoLoginer;
import cn.lujiawu.garmin2suunto.util.OkHttpClientManager;
import cn.lujiawu.garmin2suunto.util.RetrofitHelper;
import org.apache.commons.lang3.StringUtils;
import rx.Observable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncService {

    private ConnectApi garminConnectApi;
    private MoveApi moveApi;

    public void init() {
        OkHttpClientManager.setAutoLogin(new AutoLoginer());
        garminConnectApi = RetrofitHelper.createApi(GarminConfiguration.GARMIN_CN, ConnectApi.class);
        moveApi = RetrofitHelper.createApi(MoveApi.HOST, MoveApi.class);
    }

    public Observable<MoveItem> getLatestMove(String email, String key) {
        return moveApi.moves(email, key)
                .flatMap(Observable::from)
                .firstOrDefault(new MoveItem());
    }


    public Observable<List<ActivityItem>> getActivityItems(String id, String startDate) {

        return garminConnectApi.search(startDate)
                .flatMap(activities -> Observable.from(activities))
                .toList()
                .map(list -> {
                    Collections.reverse(list);
                    boolean after = false;
                    List<ActivityItem> activityItems = new ArrayList<>(list.size());
                    for (ActivityItem item : list) {
                        if (item.getActivityId().equalsIgnoreCase(id)) {
                            after = true;
                            continue;
                        }

                        if (after && StringUtils.endsWithAny(item.getActivityType().getTypeKey(), "running", "cycling")) {
                            activityItems.add(item);
                        }
                    }
                    return activityItems;
                });

    }


    public Observable<Move> getMove(String activityId) {

        Observable<Activity> activityObservable = garminConnectApi.garminActivity(activityId);
        Observable<ActivityDetail> detailsObservable = garminConnectApi.garminActivityDetails(activityId);
        Observable<ActivitySplits> splitsObservable = garminConnectApi.garminActivitySplits(activityId);

        return Observable.zip(activityObservable, detailsObservable, splitsObservable,
                (a, b, c) -> GarminConverter.convert(a, c, b));


    }

    public Observable<MoveResult> saveMove(String email, String key, Move move) {
        Observable<MoveResult> save = moveApi.save(email, key, move);
        return save;

    }


}
