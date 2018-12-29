package cn.lujiawu.garmin2suunto;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.tck.PublisherVerification;
import org.reactivestreams.tck.TestEnvironment;
import reactor.core.publisher.Flux;

public class FluxVerification extends PublisherVerification<String> {

    public FluxVerification() {
        super(new TestEnvironment());
    }


    @Override
    public Publisher<String> createPublisher(long elements) {
        return demo();
    }

    @Override
    public Publisher<String> createFailedPublisher() {
        return demo();
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


