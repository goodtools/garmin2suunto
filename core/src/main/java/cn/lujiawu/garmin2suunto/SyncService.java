package cn.lujiawu.garmin2suunto;

import cn.lujiawu.garmin2suunto.garmin.api.*;
import cn.lujiawu.garmin2suunto.move.api.Move;
import cn.lujiawu.garmin2suunto.move.api.MoveApi;
import cn.lujiawu.garmin2suunto.move.api.MoveItem;
import cn.lujiawu.garmin2suunto.move.api.MoveResult;
import cn.lujiawu.garmin2suunto.util.Act2MoveConverter;
import cn.lujiawu.garmin2suunto.util.DateUtils;
import io.reactivex.Single;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncService {

    private ConnectApi garminConnectApi;
    private MoveApi moveApi;

    public SyncService() {
        garminConnectApi = ApiManager.getGarminConnectApi();
        moveApi = ApiManager.getMoveApi();
    }

    public Single<MoveItem> getLatestMove() {
        return moveApi.moves(ApiManager.suuntoEmail, ApiManager.suuntoKey, DateUtils.getLast2WeekDate())
                .map(list -> {
                    if (list.isEmpty()) {
                        return new MoveItem();
                    }
                    return list.get(list.size() - 1);
                });
    }

    //
//
    public Single<List<ActivityItem>> getActivityItems(String id, String startDate) {

        if (StringUtils.isAnyEmpty(id, startDate)) {
            return garminConnectApi.latest20()
                    .map(list -> {
                        Collections.reverse(list);
                        return list;
                    });
        }
//
        return garminConnectApi.search(startDate)
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


    public Single<Move> getMoveFromGarminAct(String activityId) {

        Single<Activity> activityObservable = garminConnectApi.garminActivity(activityId);
        Single<ActivityDetail> detailsObservable = garminConnectApi.garminActivityDetails(activityId);
        Single<ActivitySplits> splitsObservable = garminConnectApi.garminActivitySplits(activityId);

        Single<Move> zip = Single.zip(activityObservable, detailsObservable, splitsObservable,
                (a, b, c) -> Act2MoveConverter.convert(a, c, b));

        return zip;
    }

    public Single<MoveResult> saveMove(Move move) {
        return moveApi.save(ApiManager.suuntoEmail, ApiManager.suuntoKey, move);

    }


}
