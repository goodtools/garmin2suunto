package cn.lujiawu.garmin2suunto.move.api;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

public interface MoveApi {

    String HOST = "https://uiservices.movescount.com";

    @GET("/moves/private?appkey=uFiPE28bwLykgnTlYyvlS7GzgaAcIRP3I85FCMFJUDFwTa7hcAihvk7x9SJEC5CP")
    Observable<List<MoveItem>> moves(@Query("email") String email, @Query("userkey") String userkey);

    @GET("/moves/private?appkey=uFiPE28bwLykgnTlYyvlS7GzgaAcIRP3I85FCMFJUDFwTa7hcAihvk7x9SJEC5CP&maxcount=100")
    Observable<List<MoveItem>> moves(@Query("email") String email, @Query("userkey") String userkey ,@Query("startDate") String startDate);

    @POST("/moves?appkey=uFiPE28bwLykgnTlYyvlS7GzgaAcIRP3I85FCMFJUDFwTa7hcAihvk7x9SJEC5CP")
    Observable<MoveResult> save(@Query("email") String email, @Query("userkey") String userkey, @Body Move move);

}
