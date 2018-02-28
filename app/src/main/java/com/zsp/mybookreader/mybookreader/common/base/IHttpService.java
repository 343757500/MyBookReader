package com.zsp.mybookreader.mybookreader.common.base;

/**
 * @author WJQ
 */

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/** Retrofit接口 */
public interface IHttpService {

    String HOST_URL = "http://" + Const.HOST_IP;

//    0: 账号密码登录
//    1：手机号码登录
//    2: 第三方应用登




    int TYPE_RECOMMEND = 0;
    int TYPE_TOPRANK = 1;
    int TYPE_RANKID = 2;
    int TYPE_FRAGMENT2 = 3;
    int TYPE_RECOMMEND2 = 4;
    int TYPE_CATE = 5;
    int TYPE_IMAGVIEW = 5;
    int TYPE_RECOMMEND3 = 6;

    @GET("book/recommend")
    Call<JsonObject> getRecommend(
            @Query("gender") String packageName);

    @GET("ranking/gender")
    Call<JsonObject> getTopRank();


    @GET("ranking/{rankingId}")
    Call<JsonObject> getRankWeek(
            @Path("rankingId") String id );


    @GET("book/{bookId}")
    Call<JsonObject> getBookDetialId(
            @Path("bookId") String id );






    @GET("/appstore/app/introduce")
    Call<JsonObject> getDetial(
            @Query("packageName") String packageName);

    @GET("/appstore/app/comment")
    Call<JsonObject> getDetialFragment3(
            @Query("packageName") String packageName);

    @GET("/appstore/app/recommend")
    Call<JsonObject> getDetialFragment4(
            @Query("packageName") String packageName);


    @GET("/appstore/category")
    Call<JsonObject> getRecommend2();


    @GET("/appstore/categorydata/subscribe")
    Call<JsonObject> getCategorySubscribe();

    @GET("/appstore/categorydata/subject")
    Call<JsonObject> getImagvieData();

    @GET("/appstore/top")
    Call<JsonObject> getRecommendPreF2();
}
