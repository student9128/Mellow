package com.kevin.mellow.http;

import com.kevin.mellow.bean.DouBanMovieBean;

import java.util.Map;

import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/27.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public interface HttpInterface {

//    @GET("onelist/idlist/?channel=wdj&version=4.0.2&uuid=ffffffff-a90e-706a-63f7-ccf973aae5ee&platform=android")
//    Call<Map<String, Object>> getIdList();

    @GET("onelist/idlist/")
    Call<Map<String, Object>> getIdList(@QueryMap Map<String, String> map);

    @GET("onelist/idlist/{data}/0")
    Call<Map<String, Object>> getOneList(@Path("data") String data, @QueryMap Map<String, String> map);

    @GET("essay/1713")
    Call<Map<String, Object>> getItemList(@QueryMap Map<String, String> map);

//type:today,random, date:20171219
//    @GET("article/{type}")
//    Call<Map<String, Object>> getArticle(@Path("type") String type, @Query("dev") String dev,
//
//                                  @Query("date") String date);

    @Headers("url_name:tu_chong")
    @GET("discover-app")
    Observable<Map<String, Object>> getTuChongDiscover(@QueryMap Map<String, String> map);

    @Headers("url_name:tu_chong")
    @GET("feed-app")
    Observable<Map<String, Object>> getTuChongRecommend(@QueryMap Map<String, String> map);

    @Headers("url_name:tou_tiao")
    @GET("api/news/feed/v51/")
    Call<Map<String, Object>> getTouTiao(@QueryMap Map<String, String> map);


    @Headers("url_name:dou_ban")
    @GET("v2/movie/in_theaters?")
    Observable<DouBanMovieBean> getMovie(@QueryMap Map<String, String> map);

    @Headers("url_name:dou_ban")
    @GET("v2/movie/subject/{id}")
    Observable<Map<String, Object>> getMovieDetail(@Path("id") String id,
                                                   @QueryMap Map<String, String> map);

    @Headers("url_name:dou_ban")
    @GET("v2/movie/subject/{id}/photos")
    Observable<Map<String, Object>> getMoviePhotos(@Path("id") String id,
                                                   @QueryMap Map<String, String> map);

    @Headers("url_name:dou_ban")
    @GET("v2/movie/subject/{id}/reviews")
    Observable<Map<String, Object>> getMovieReviews(@Path("id") String id,
                                                    @QueryMap Map<String, String> map);

    /**
     * 城市查找
     * @param map
     * @return
     */
    @Headers("url_name:weather_search_city")
    @GET("find?")
    Observable<Map<String, Object>> getWeatherCity(@QueryMap Map<String,String> map);

    /**
     * 热门城市
     *
     * @return
     */
    @Headers("url_name:weather_search_city")
    @GET("top?")
    Observable<Map<String, Object>> getHotCity();

    /**
     * 3天预报
     * @param map
     * @return
     */
    @Headers("url_name:he_weather")
    @GET("s6/weather/forecast?")
    Observable<Map<String, Object>> getCityWeather(@QueryMap Map<String, String> map);

    /**
     * 获取当前实况信息
     * @param map
     * @return
     */
    @Headers("url_name:he_weather")
    @GET("s6/weather/now?")
    Observable<Map<String, Object>> getCurrentWeather(@QueryMap Map<String, String> map);

//    @Headers("url_name:dou_ban")
//    @GET("v2/movie/in_theaters?")
//    Observable<BaseResponse<DouBanMovieBean>> getDouBanMovie(@QueryMap Map<String, String> map);

}
