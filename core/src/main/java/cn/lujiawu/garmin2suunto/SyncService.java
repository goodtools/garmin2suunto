package cn.lujiawu.garmin2suunto;

import cn.lujiawu.garmin2suunto.garmin.api.Activity;
import cn.lujiawu.garmin2suunto.garmin.api.ActivityDetail;
import cn.lujiawu.garmin2suunto.garmin.api.ActivitySplits;
import cn.lujiawu.garmin2suunto.garmin.api.ConnectApi;
import cn.lujiawu.garmin2suunto.move.api.Move;
import cn.lujiawu.garmin2suunto.move.api.MoveApi;
import cn.lujiawu.garmin2suunto.move.api.MoveResult;
import cn.lujiawu.garmin2suunto.util.Act2MoveConverter;
import io.reactivex.Single;

public class SyncService {

    private ConnectApi garminConnectApi;
    private MoveApi moveApi;

    public SyncService() {
        garminConnectApi = ApiManager.getGarminConnectApi();
        moveApi = ApiManager.getMoveApi();
    }

//    public Single<MoveItem> getLatestMove(String email, String key) {
//        return moveApi.moves(email, key, DateUtils.getLast2WeekDate())
//                .flatMap(list -> Observable.fromArray(list.toArray(new MoveItem[0])))
//                .last(new MoveItem());
//    }
//
//
//    public Single<List<ActivityItem>> getActivityItems(String id, String startDate) {
//
//        if (StringUtils.isAnyEmpty(id, startDate)) {
//            return garminConnectApi.latest20()
//                    .flatMap(activities -> Observable.fromArray(activities.toArray(new ActivityItem[0])))
//                    .toList()
//                    .map(list -> {
//                        Collections.reverse(list);
//                        return list;
//                    });
//        }
//
//        return garminConnectApi.search(startDate)
//                .flatMap(activities -> Observable.fromArray(activities.toArray(new ActivityItem[0])))
//                .toList()
//                .map(list -> {
//                    Collections.reverse(list);
//                    boolean after = false;
//                    List<ActivityItem> activityItems = new ArrayList<>(list.size());
//                    for (ActivityItem item : list) {
//                        if (item.getActivityId().equalsIgnoreCase(id)) {
//                            after = true;
//                            continue;
//                        }
//
//                        if (after && StringUtils.endsWithAny(item.getActivityType().getTypeKey(), "running", "cycling")) {
//                            activityItems.add(item);
//                        }
//                    }
//                    return activityItems;
//                });
//
//    }


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
