package cn.lujiawu.rxjava;

import org.junit.Test;
import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;

import java.util.Random;

public class RxJavaTest {

    @Test
    public void test() throws InterruptedException {
        Subscription subscribe = Observable.just("long", "longer", "longest")
                .doOnNext(c -> System.out.println("processing item on thread " + Thread.currentThread().getName()))
                .subscribeOn(Schedulers.newThread())
                .map(String::length)
                .subscribe(length -> System.out.println("item length " + length + "received on " + Thread.currentThread().getName()));

        Thread.sleep(3000);
    }

    @Test
    public void test2() throws InterruptedException {
        Subscription subscribe = Observable.just("long", "longer", "longest")
                .doOnNext(c -> System.out.println("processing item on thread " + Thread.currentThread().getName()))
                .subscribeOn(Schedulers.immediate())
                .map(String::length)
                .observeOn(Schedulers.immediate())
                .subscribe(length -> System.out.println("item length " + length + "received on " + Thread.currentThread().getName()));

        Thread.sleep(3000);
    }

    @Test
    public void test3() throws InterruptedException {
        Observable.just("long", "longer", "longest")
                .flatMap(v -> performLongOperation(v)
                                .doOnNext(s -> System.out.println("processing item on thread " + Thread.currentThread().getName()))
                                .subscribeOn(Schedulers.newThread()))
                .subscribe(length -> System.out.println("received item length " + length + " on thread " + Thread.currentThread().getName()));

        Thread.sleep(10000);
    }
    /**
     * Returns length of each param wrapped into an Observable.
     */
    protected Observable<Integer> performLongOperation(String v) {
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
