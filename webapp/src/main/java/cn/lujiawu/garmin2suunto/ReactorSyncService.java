package cn.lujiawu.garmin2suunto;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import rx.Observable;

@Service
public class ReactorSyncService {

    @Autowired
    protected SyncService syncService;

    @Autowired
    protected SyncConfig syncConfig;

    public Flux<String> startSync() {

        Flux<String> fluxs = Flux.create(emmiter -> {

            emmiter.next("1.1 start get lastest move ");
            //1. 获取记录
            syncService.getLatestMove(syncConfig.getSuuntoUserName(), syncConfig.getSuuntoUserKey())
                    .flatMap(last -> {
                        emmiter.next("1.2 finish get lastest move ");
                        if (null == last.getMoveId()) {
                            emmiter.next("1.3 get lastest move null");
                            emmiter.complete();
                            return Observable.empty();
                        }
                        emmiter.next("1.3 finish get lastest move " + last.getGarminActivityId());
                        emmiter.next("2.1 start  get garmin history from " + last.getGarminActivityId() + " " + last.getStartDate());
                        //2. 获取garmin历史记录
                        return syncService.getActivityItems(last.getGarminActivityId(), last.getStartDate());
                    })
                    //3. 对每条记录进行处理 foreach
                    .flatMapIterable(activityItems -> {
                        emmiter.next("2.2 finish get garmin history , size is " + activityItems.size());
                        if (activityItems.isEmpty()) {
                            emmiter.next("date is update2date");
                            emmiter.complete();
                        }
                        return activityItems;
                    })
                    .flatMap(activityItem -> {
                        if (null == activityItem) {
                            emmiter.next("3.1 activity item is null, complete ");
                            emmiter.complete();
                        }
                        emmiter.next("3.1." + activityItem.getActivityId() + " start get garmin move detail ");
                        return syncService.getMoveFromGarminAct(activityItem.getActivityId());
                    })
                    .flatMap(move -> {
                        emmiter.next("3.2." + " finish get garmin detail " + move.getLocalStartTime());
                        return syncService.saveMove(syncConfig.getSuuntoUserName(), syncConfig.getSuuntoUserKey(), move);
                    }).doOnNext(result -> {
                emmiter.next("4.1." + " save move success" + result.getSelfURI());
            })
                    .doOnError(e -> {
                        emmiter.next("on error !!! " + ExceptionUtils.getMessage(e));
                        emmiter.complete();
                    })
                    .doOnCompleted(() -> {
                        emmiter.next("on complete!!");
                        emmiter.complete();
                    })
                    .subscribe();

        }, FluxSink.OverflowStrategy.DROP);

        return fluxs;

    }

    @Service
    public static class SpringSyncService extends SyncService implements InitializingBean {

        @Override
        public void afterPropertiesSet() throws Exception {

            super.init();

        }


    }

}
