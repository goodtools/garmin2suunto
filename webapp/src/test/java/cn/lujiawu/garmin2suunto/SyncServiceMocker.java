package cn.lujiawu.garmin2suunto;

import cn.lujiawu.garmin2suunto.garmin.api.ActivityItem;
import cn.lujiawu.garmin2suunto.move.api.Move;
import cn.lujiawu.garmin2suunto.move.api.MoveItem;
import cn.lujiawu.garmin2suunto.move.api.MoveResult;
import io.reactivex.Single;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SyncServiceMocker extends SyncService {

    @Override
    public Single<MoveItem> getLatestMove() {
        return Single.fromCallable(() -> {
            sleep(100);
            MoveItem moveItem = new MoveItem();
            moveItem.setMoveId(1);
            return moveItem;
        });
    }

    @Override
    public Single<List<ActivityItem>> getActivityItems(String id, String startDate) {
        return Single.fromCallable(() -> {
            sleep(300);
            List<ActivityItem> list = new ArrayList<>();
            list.add(new ActivityItem());
            list.add(new ActivityItem());
            list.add(new ActivityItem());
            return list;
        });
    }

    @Override
    public Single<Move> getMoveFromGarminAct(String activityId) {
        return Single.fromCallable(() -> {
            sleep(100);
            return new Move();
        });
    }

    @Override
    public Single<MoveResult> saveMove(Move move) {
        return Single.fromCallable(() -> {
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
