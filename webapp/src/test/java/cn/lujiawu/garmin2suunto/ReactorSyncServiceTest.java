package cn.lujiawu.garmin2suunto;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class ReactorSyncServiceTest {
    @Test
    public void test() throws InterruptedException {


        demo().subscribe(System.out::println);

//        Thread.sleep(20000);

    }

    private Flux<String> demo() {
        SyncConfig syncConfig = new SyncConfig();
        syncConfig.setSuuntoUserName("123");
        syncConfig.setSuuntoUserKey("123");

        ReactorSyncService reactorSyncService = new ReactorSyncService();
        reactorSyncService.syncService = new SyncServiceMocker();
        reactorSyncService.syncConfig = syncConfig;
        return reactorSyncService.startSync();
    }

}