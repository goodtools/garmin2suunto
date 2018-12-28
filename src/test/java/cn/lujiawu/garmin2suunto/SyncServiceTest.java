package cn.lujiawu.garmin2suunto;

import at.meeximum.activitymoverfx.models.json.garmin.ActivityItem;
import cn.lujiawu.garmin2suunto.move.api.MoveApi;
import org.junit.Test;

public class SyncServiceTest {

    @Test
    public void test() {
        SyncService syncService = new SyncService();
        syncService.init();
        syncService.getActivityItems("48802665", "2018-11-25")
                .subscribe(list -> {
                    for (ActivityItem item : list) {
                        System.out.println(item);
                    }
                });
    }

    @Test
    public void testGetMove() {
        SyncService syncService = new SyncService();
        syncService.init();
        syncService.getMove("50360706")
                .subscribe(move -> {
                    System.out.println(move);
                });

    }

    String email = "jiawu.lu@gmail.com";
    String key = MoveApi.USER_KEY;

    @Test
    public void testMoves() {
        SyncService syncService = new SyncService();
        syncService.init();

//        syncService.getLatestMove(email, key)
//                .subscribe(move -> {
//                    System.out.println(move);
//                });


        syncService.getMove("50327639")
                .flatMap(move -> {
                    return syncService.saveMove(email, key, move);
                })
                .subscribe(result -> {
                    System.out.println(result);
                }, e -> {
                    e.printStackTrace();
                });

        System.out.println(123);
//        syncService.getLatestMove(email, key)
//                .subscribe(move -> {
//                    System.out.println(move);
//                });


    }

}