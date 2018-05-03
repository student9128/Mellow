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

    /**
     * @param type random,today,day
     * @param date
     * @return
     */
    Call<Map<String, Object>> requestArticle(String type, String date);

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



    Observable<Map<String, Object>> requestX(String type,String postId, String page);
}
