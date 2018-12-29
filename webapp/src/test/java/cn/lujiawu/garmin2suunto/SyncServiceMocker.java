package cn.lujiawu.garmin2suunto;

import cn.lujiawu.garmin2suunto.garmin.api.ActivityItem;
import cn.lujiawu.garmin2suunto.move.api.Move;
import cn.lujiawu.garmin2suunto.move.api.MoveItem;
import cn.lujiawu.garmin2suunto.move.api.MoveResult;
import org.apache.commons.lang3.StringUtils;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SyncServiceMocker extends SyncService {

    @Override
    public Observable<MoveItem> getLatestMove(String email, String key) {
        return Observable.fromCallable(() -> {
            sleep(100);
            if (StringUtils.isEmpty(email)){
                return new MoveItem();
            }
            MoveItem moveItem = new MoveItem();
            moveItem.setMoveId(1);
            return moveItem;
        });
    }

    @Override
    public Observable<List<ActivityItem>> getActivityItems(String id, String startDate) {
        return Observable.fromCallable(() -> {
            sleep(300);
            List<ActivityItem> list = new ArrayList<>();
            list.add(new ActivityItem());
            list.add(new ActivityItem());
            list.add(new ActivityItem());
            return list;
        });
    }

    @Override
    public Observable<Move> getMoveFromGarminAct(String activityId) {
        return Observable.fromCallable(() -> {
            sleep(100);
            return new Move();
        });
    }

    @Override
    public Observable<MoveResult> saveMove(String email, String key, Move move) {
        return Observable.fromCallable(() -> {
            sleep(200);
            return new MoveResult();
        });
    }

    protected void sleep(long ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
