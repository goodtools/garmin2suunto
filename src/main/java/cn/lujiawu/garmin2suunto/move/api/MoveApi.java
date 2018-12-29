package cn.lujiawu.garmin2suunto.move.api;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

import java.util.List;

public interface MoveApi {

    String HOST = "https://uiservices.movescount.com";
    String APP_KEY = "uFiPE28bwLykgnTlYyvlS7GzgaAcIRP3I85FCMFJUDFwTa7hcAihvk7x9SJEC5CP";
    String USER_KEY = "e4acbce2-4a3e-4f34-b806-d81694f59384";

    @GET("/moves/private?appkey=uFiPE28bwLykgnTlYyvlS7GzgaAcIRP3I85FCMFJUDFwTa7hcAihvk7x9SJEC5CP")
    Observable<List<MoveItem>> moves(@Query("email") String email, @Query("userkey") String userkey);

    @POST("/moves?appkey=uFiPE28bwLykgnTlYyvlS7GzgaAcIRP3I85FCMFJUDFwTa7hcAihvk7x9SJEC5CP")
    Observable<MoveResult> save(@Query("email") String email, @Query("userkey") String userkey, @Body Move move);

}
