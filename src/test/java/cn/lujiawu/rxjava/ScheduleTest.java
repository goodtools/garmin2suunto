package cn.lujiawu.rxjava;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.Random;

public class ScheduleTest {

    public static void main(String[] args) throws InterruptedException {
        Observable.just("long", "longer", "longest")
                .flatMap(v ->
                        performLongOperation(v)
                                .doOnNext(s -> System.out.println("processing item on thread " + Thread.currentThread().getName()))
                                )
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(length -> System.out.println(">>> print received item length " + length + " on thread " + Thread.currentThread().getName()));

        Thread.sleep(10000);
    }
    /**
     * Returns length of each param wrapped into an Observable.
     */
    protected static Observable<Integer> performLongOperation(String v) {
        System.out.println("<<< performLongOperation " + Thread.currentThread().getName() + "_" + Thread.currentThread().getId());
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(3) * 1000);
            return Observable.just(v.length());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


}
