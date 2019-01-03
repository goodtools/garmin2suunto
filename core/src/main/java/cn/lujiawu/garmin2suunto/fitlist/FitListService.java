package cn.lujiawu.garmin2suunto.fitlist;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cn.lujiawu.garmin2suunto.ApiManager;
import cn.lujiawu.garmin2suunto.garmin.api.ActivityItem;
import cn.lujiawu.garmin2suunto.move.api.MoveItem;
import io.reactivex.Single;

public class FitListService {

    public Single<List<FitItem>> getActivityPaged(int start, int limit) {

        return ApiManager.getGarminConnectApi()
                .search(limit, start)
                .map(this::filter)
                .flatMap(this::convert);

    }

    private List<ActivityItem> filter(List<ActivityItem> list) {
        return list.stream().filter(item -> {
            return StringUtils.endsWithAny(item.getActivityType().getTypeKey(), "running", "cycling");
        }).collect(Collectors.toList());
    }

    private Single<List<FitItem>> convert(List<ActivityItem> activityItemList) {

        if (activityItemList.isEmpty()) {
            return Single.just(new ArrayList<>());
        }

        String startTimeLocal = activityItemList.get(activityItemList.size() - 1).getStartTimeLocal();
        String startDate = startTimeLocal.split(" ")[0];

        Single<List<MoveItem>> moves = getMoves(startDate, activityItemList.size());

        return moves.map(moveItems -> {

            List<FitItem> fitItemList = new ArrayList<>();

            Map<String, MoveItem> map = moveItems.stream().collect(Collectors.toMap(MoveItem::getGarminActivityId, item -> item));

            for (ActivityItem activityItem : activityItemList) {
                FitItem fitItem = new FitItem();
                fitItem.setActivity(activityItem);
                fitItem.setMove(map.get(activityItem.getActivityId()));
                fitItemList.add(fitItem);
            }

            return fitItemList;

        });

    }


    public Single<List<MoveItem>> getMoves(String date, int limit) {
        return ApiManager.getMoveApi().moves(ApiManager.suuntoEmail, ApiManager.suuntoKey, date, limit);
    }

}
