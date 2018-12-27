package cn.lujiawu.garmin2suunto;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

public interface Search {

    @GET("/")
    Call<Index> search();

    @GET("/")
    Observable<Index> searchRx();

    static class Index{
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Index{" +
                    "url='" + url + '\'' +
                    '}';
        }
    }

}