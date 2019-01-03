//package cn.lujiawu.garmin2suunto;
//
//import com.google.gson.Gson;
//
//import org.junit.Test;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//import cn.lujiawu.garmin2suunto.garmin.api.ActivityItem;
//import cn.lujiawu.garmin2suunto.util.AutoLoginer;
//
//public class SyncServiceTest {
//
//    static {
//        Properties properties = new Properties();
//        try {
//            properties.load(new FileInputStream("config.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        String userName = properties.getProperty("email");
//        String key = properties.getProperty("key");
//        SyncInitializer.init(new AutoLoginer(), userName, key);
//    }
//
//    @Test
//    public void test() {
//        SyncService syncService = new SyncService();
//        syncService.getActivityItems("48802665", "2018-11-25")
//                .subscribe(list -> {
//                    for (ActivityItem item : list) {
//                        System.out.println(item);
//                    }
//                });
//    }
//
//    String activityIdOutdoor = "50453091";
//    String activityIdIndoor = "50360706";
//
//    @Test
//    public void testGetOutdoorMove() {
//        SyncService syncService = new SyncService();
//        syncService.getMoveFromGarminAct(activityIdIndoor)
//                .subscribe(move -> {
//                    System.out.println(new Gson().toJson(move));
//                });
//
//    }
//
//    String email = "jiawu.lu@gmail.com";
//    String key = "";
//
//    @Test
//    public void testMoves() {
//        SyncService syncService = new SyncService();
//
////        syncService.getLatestMove(email, key)
////                .subscribe(move -> {
////                    System.out.println(move);
////                });
//
//
//        syncService.getMoveFromGarminAct(activityIdOutdoor)
//                .subscribe(result -> {
//                    System.out.println(result);
//                }, e -> {
//                    e.printStackTrace();
//                });
//
////        syncService.getLatestMove(email, key)
////                .subscribe(move -> {
////                    System.out.println(move);
////                });
//
//
//    }
//
//}