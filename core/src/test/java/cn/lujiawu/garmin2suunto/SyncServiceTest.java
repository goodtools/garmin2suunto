package cn.lujiawu.garmin2suunto;

import cn.lujiawu.garmin2suunto.garmin.AutoLoginInterceptor;
import cn.lujiawu.garmin2suunto.garmin.SimpleCookieJar;
import cn.lujiawu.garmin2suunto.garmin.api.ActivityItem;
import cn.lujiawu.garmin2suunto.util.AutoLoginer;
import cn.lujiawu.garmin2suunto.util.OkHttpClientManager;
import com.google.gson.Gson;
import org.junit.Test;

public class SyncServiceTest {

    static {
        SimpleCookieJar simpleCookieJar = new SimpleCookieJar();
        OkHttpClientManager.init(null, new AutoLoginInterceptor(new AutoLoginer(), simpleCookieJar), simpleCookieJar);
    }

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

    String activityIdOutdoor = "50453091";
    String activityIdIndoor = "50360706";

    @Test
    public void testGetOutdoorMove() {
        SyncService syncService = new SyncService();
        syncService.init();
        syncService.getMoveFromGarminAct(activityIdIndoor)
                .subscribe(move -> {
                    System.out.println(new Gson().toJson(move));
                });

    }

    String email = "jiawu.lu@gmail.com";
    String key = "";

    @Test
    public void testMoves() {
        SyncService syncService = new SyncService();
        syncService.init();

//        syncService.getLatestMove(email, key)
//                .subscribe(move -> {
//                    System.out.println(move);
//                });


        syncService.getMoveFromGarminAct(activityIdOutdoor)
                .flatMap(move -> {
                    return syncService.saveMove(email, key, move);
                })
                .subscribe(result -> {
                    System.out.println(result);
                }, e -> {
                    e.printStackTrace();
                });

//        syncService.getLatestMove(email, key)
//                .subscribe(move -> {
//                    System.out.println(move);
//                });


    }

}