package cn.lujiawu.rxjava;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.Callable;

public class FlatMapTest {

    @Test
    public void test() throws InterruptedException {

        performLongOperation("hello")
                //设置发布者线程
                .subscribeOn(Schedulers.single())
                //设置订阅者线程
                .observeOn(Schedulers.newThread())
                .subscribe(i -> {
                    printThreadName("subscribe");
                });

        Thread.sleep(1000);

    }

    @Test
    public void testFlatMap() throws InterruptedException {

        performLongOperation("hello")
                //设置第一个 onsuccess 对应的线程
                .observeOn(Schedulers.newThread())
                .doOnSuccess(integer -> {
                    printThreadName("onSuccess1");
                })
                .flatMap(this::performLongOperation2)
                //设置发布者线程
                .subscribeOn(Schedulers.single())
                //设置订阅者线程
                .observeOn(Schedulers.newThread())
                .doOnSuccess(integer -> {
                    printThreadName("onSuccess2");
                })
                .subscribe(i -> {
                    printThreadName("subscribe");
                });

        Thread.sleep(1000);

    }

    private void printThreadName(String tag) {
        System.out.println(tag + ">>>" + System.currentTimeMillis() % 10000 + ">>" + Thread.currentThread().getName());
    }


    protected Single<Integer> performLongOperation(String v) {
        return Single.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                try {
                    Thread.sleep(random.nextInt(3) * 10);
                    printThreadName("performLongOperation");
                    return v.length();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }

    protected Single<Integer> performLongOperation2(Integer v) {
        return Single.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                try {
                    Thread.sleep(random.nextInt(3) * 10);
                    printThreadName("performLongOperation2");
                    return v * 2;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }

}
