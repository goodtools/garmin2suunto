//package cn.lujiawu.garmin2suunto;
//
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import cn.lujiawu.garmin2suunto.garmin.api.Activity;
//import cn.lujiawu.garmin2suunto.garmin.api.ActivityDetail;
//import cn.lujiawu.garmin2suunto.garmin.api.ActivityItem;
//import cn.lujiawu.garmin2suunto.garmin.api.ActivitySplits;
//import cn.lujiawu.garmin2suunto.garmin.api.ConnectApi;
//import cn.lujiawu.garmin2suunto.move.api.Move;
//import cn.lujiawu.garmin2suunto.move.api.MoveApi;
//import cn.lujiawu.garmin2suunto.move.api.MoveItem;
//import cn.lujiawu.garmin2suunto.move.api.MoveResult;
//import cn.lujiawu.garmin2suunto.util.Act2MoveConverter;
//import cn.lujiawu.garmin2suunto.util.DateUtils;
//import io.reactivex.Observable;
//import io.reactivex.Single;
//
//public class SyncService {
//
//    private ConnectApi garminConnectApi;
//    private MoveApi moveApi;
//
//    public SyncService() {
//        garminConnectApi = ApiManager.getGarminConnectApi();
//        moveApi = ApiManager.getMoveApi();
//    }
//
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
//
//
//    public Single<Move> getMoveFromGarminAct(String activityId) {
//
//        Observable<Activity> activityObservable = garminConnectApi.garminActivity(activityId);
//        Observable<ActivityDetail> detailsObservable = garminConnectApi.garminActivityDetails(activityId);
//        Observable<ActivitySplits> splitsObservable = garminConnectApi.garminActivitySplits(activityId);
//
//        return Observable.zip(activityObservable, detailsObservable, splitsObservable,
//                (a, b, c) -> Act2MoveConverter.convert(a, c, b)).singleOrError();
//
//
//    }
//
//    public Observable<MoveResult> saveMove(String email, String key, Move move) {
//        Observable<MoveResult> save = moveApi.save(email, key, move);
//        return save;
//
//    }
//
//
//}
