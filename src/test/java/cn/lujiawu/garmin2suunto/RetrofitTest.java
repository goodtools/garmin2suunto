package cn.lujiawu.garmin2suunto;

import org.junit.BeforeClass;
import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitTest {

    private static Search search;

    @BeforeClass
    public static void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://s.m.taobao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        search = retrofit.create(Search.class);
    }

    @Test
    public void test() throws Exception {
        Search.Index index = search
                .search()
                .execute()
                .body();

        System.out.println(index);
    }

    @Test
    public void testRx(){

        search.searchRx().map(Search.Index::getUrl).subscribe(System.out::println);

    }
}
