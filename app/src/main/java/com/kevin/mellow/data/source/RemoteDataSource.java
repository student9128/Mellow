package com.kevin.mellow.data.source;

import com.kevin.mellow.bean.DouBanMovieBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/27.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public interface RemoteDataSource {

    Call<Map<String, Object>> requestData();

    Call<Map<String, Object>> requestOnList(String data);

    Call<Map<String, Object>> requestItemList();


    Call<Map<String, Object>> requestTouTiao();

    /**
     * @param cityName city name
     * @param start    the page code
     * @return
     */
    Observable<DouBanMovieBean> requestDouBan(String cityName, String start);

    //    Observable<BaseResponse<DouBanMovieBean>> requestDouBanM(String cityName, String start);
    Observable<Map<String, Object>> requestDouBanMovieDetail(String cityName, String id);

    Observable<Map<String, Object>> requestDouBanMoviePhotos(String cityName, String id);

    Observable<Map<String, Object>> requestDouBanMovieReviews(String cityName, String id);


    /**
     * 图虫推荐界面
     * @param type
     * @param postId
     * @param page
     * @return
     */
    Observable<Map<String, Object>> requestTuChongRecommend(String type, String postId, String page);

    /**
     * 图虫发现界面
     * @return
     */
    Observable<Map<String, Object>> requestTuDiscover();

    /**
     * 获取城市信息
     * @param cityName
     * @return
     */
    Observable<Map<String, Object>> requestWeatherCity(String cityName);

    /**
     * 获取热门城市信息
     * @return
     */
    Observable<Map<String, Object>> requestHotCity();

    /**
     * 根据城市名字获取天气预报信息
     * @param cityName
     * @return
     */
    Observable<Map<String, Object>> requestCityWeather(String cityName);

    /**
     * 获取某个城市当前天气信息
     * @param cityName
     * @return
     */
    Observable<Map<String, Object>> requestCurrentWeather(String cityName);
}
