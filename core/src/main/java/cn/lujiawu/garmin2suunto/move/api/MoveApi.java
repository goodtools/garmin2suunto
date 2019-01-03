package cn.lujiawu.garmin2suunto.move.api;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MoveApi {

    String HOST = "https://uiservices.movescount.com";

    @GET("/moves/private?appkey=uFiPE28bwLykgnTlYyvlS7GzgaAcIRP3I85FCMFJUDFwTa7hcAihvk7x9SJEC5CP")
    Single<List<MoveItem>> moves(@Query("email") String email, @Query("userkey") String userkey);

    /**
     * 按历史记录的时间顺序排序，最新的记录在末尾
     *
     * @param email
     * @param userkey
     * @param startDate
     * @return
     */
    @GET("/moves/private?appkey=uFiPE28bwLykgnTlYyvlS7GzgaAcIRP3I85FCMFJUDFwTa7hcAihvk7x9SJEC5CP&maxcount=100")
    Single<List<MoveItem>> moves(@Query("email") String email, @Query("userkey") String userkey, @Query("startDate") String startDate);

    @GET("/moves/private?appkey=uFiPE28bwLykgnTlYyvlS7GzgaAcIRP3I85FCMFJUDFwTa7hcAihvk7x9SJEC5CP")
    Single<List<MoveItem>> moves(@Query("email") String email, @Query("userkey") String userkey, @Query("startDate") String startDate, @Query("maxcount") int maxcount);

    @POST("/moves?appkey=uFiPE28bwLykgnTlYyvlS7GzgaAcIRP3I85FCMFJUDFwTa7hcAihvk7x9SJEC5CP")
    Single<MoveResult> save(@Query("email") String email, @Query("userkey") String userkey, @Body Move move);

}
