package servless;

import cn.lujiawu.garmin2suunto.SyncInitializer;
import cn.lujiawu.garmin2suunto.SyncService;
import io.reactivex.Observable;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class SyncExecutor {

    public static Observable<String> startSyncFlowable(String garminUserName, String garminPasswd, String suuntoEmail, String suuntoKey) {

        SyncInitializer.init(garminUserName, garminPasswd, suuntoEmail, suuntoKey);

        SyncService syncService = new SyncService();

        Observable<String> fluxs = Observable.create(emmiter -> {
            emmiter.onNext("1.1 start get lastest move ");
            //1. 获取记录
            syncService.getLatestMove()
                    .flatMap(last -> {
                        emmiter.onNext("1.2 finish get lastest move ");
                        if (null == last.getMoveId()) {
                            emmiter.onNext("1.3 get lastest move null , start to sync latest 20 garmin records");
                            return syncService.getActivityItems("", "");
                        }

                        emmiter.onNext("1.3 finish get lastest move " + last.toString());
                        emmiter.onNext("2.1 start  get garmin history from " + last.getGarminActivityId() + " " + last.getStartDate());
                        //2. 获取garmin历史记录
                        return syncService.getActivityItems(last.getGarminActivityId(), last.getStartDate());
                    })
                    .toObservable()
                    //3. 对每条记录进行处理 foreach
                    .flatMapIterable(activityItems -> {
                        emmiter.onNext("2.2 finish get garmin history , size is " + activityItems.size());
                        if (activityItems.isEmpty()) {
                            emmiter.onNext("date is update2date");
                            emmiter.onComplete();
                        }
                        return activityItems;
                    })
                    .flatMapSingle(activityItem -> {
                        if (null == activityItem) {
                            emmiter.onNext("3.1 activity item is null, complete ");
                            emmiter.onComplete();
                        }
                        emmiter.onNext("3.1." + activityItem.getActivityId() + " start get garmin move detail ");
                        return syncService.getMoveFromGarminAct(activityItem.getActivityId());
                    })
                    .flatMapSingle(move -> {
                        emmiter.onNext("3.2." + " finish get garmin detail " + move.getLocalStartTime());
                        return syncService.saveMove(move);
                    }).doOnNext(result -> {
                emmiter.onNext("4.1." + " save move success" + result.getSelfURI());
            })
                    .doOnError(e -> {
                        emmiter.onNext("on error !!! " + ExceptionUtils.getMessage(e));
                        emmiter.onComplete();
                    })
                    .doOnComplete(() -> {
                        emmiter.onNext("on complete!!");
                        emmiter.onComplete();
                    })
                    .subscribe();

        });

        return fluxs;

    }

}
