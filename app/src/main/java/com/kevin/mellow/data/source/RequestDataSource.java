package com.kevin.mellow.data.source;

import android.support.annotation.NonNull;

import com.kevin.mellow.bean.DouBanMovieBean;
import com.kevin.mellow.http.AppRetrofit;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/27.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class RequestDataSource implements RemoteDataSource {
    private static RequestDataSource INSTANCE;

    private RequestDataSource() {

    }

    public static RequestDataSource getInstance() {
        if (INSTANCE == null) {
            synchronized (RequestDataSource.class) {
                INSTANCE = new RequestDataSource();
            }
        }
        return INSTANCE;

    }

    @Override
    public Call<Map<String, Object>> requestData() {
        Map<String, String> map = getStringStringMap();
        return new AppRetrofit().getHttpService().getIdList(map);
    }

    @Override
    public Call<Map<String, Object>> requestOnList(String data) {
        Map<String, String> map = getStringStringMap();
        return new AppRetrofit().getHttpService().getOneList(data, map);
    }

    @NonNull
    private Map<String, String> getStringStringMap() {
        Map<String, String> map = new HashMap<>();
        map.put("channel", "mi");
        map.put("version", "4.5.0");
        map.put("uuid", "ffffffff-a90e-706a-63f7-ccf973aae5ee");
        map.put("platform", "android");
        return map;
    }

    @Override
    public Call<Map<String, Object>> requestItemList() {
        Map<String, String> map = new HashMap<>();
        map.put("channel", "mi");
        map.put("version", "4.5.0");
        map.put("uuid", "ffffffff-a90e-706a-63f7-ccf973aae5ee");
        map.put("platform", "android");
        map.put("source", "summary");
        map.put("source_id", "9261");
        return new AppRetrofit().getHttpService().getItemList(map);
    }
    
//    @Override
//    public Call<Map<String, Object>> requestOneArticle() {
////        Map<String, String> map = new HashMap<>();
//        return new AppRetrofit().getHttpService().getOneArticle();
//    }


    @Override
    public Call<Map<String, Object>> requestTouTiao() {
        Map<String, String> map = new HashMap<>();
        map.put("category", "news_hot");
        map.put("refer", "1");
        map.put("count", "20");
        map.put("min_behot_time", "1491981025");
        map.put("last_refresh_sub_entrance_interval", "1491981165");
        map.put("loc_mode", "");
        map.put("loc_time", "1491981000");
        map.put("latitude", "");
        map.put("longitude", "");
        map.put("city", "");
        map.put("tt_from", "pull");
        map.put("lac", "");
        map.put("cid", "");
        map.put("cp", "");
        map.put("iid", "0123456789");
        map.put("device_id", "1234567892");
        map.put("ac", "wifi");
        map.put("channel", "");
        map.put("app_name", "");
        map.put("version_code", "");
        map.put("version_name", "");
        map.put("device_platform", "");
        map.put("ab_version", "");
        map.put("ab_client", "");
        map.put("ab_group", "");
        map.put("ab_feature", "");
        map.put("abflag", "");
        map.put("ssmix", "a");
        map.put("device_type", "");
        map.put("device_brand", "");
        map.put("language", "zh");
        map.put("os_api", "");
        map.put("os_version", "");
        map.put("resolution", "");
        map.put("dpi", "");
        map.put("update_version_code", "");
        map.put("_rticket", "");

        return new AppRetrofit().getHttpService().getTouTiao(map);
    }

    @Override
    public Observable<DouBanMovieBean> requestDouBan(String cityName, String start) {
        Map<String, String> map = new HashMap<>();
        map.put("apikey", "0b2bdeda43b5688921839c8ecb20399b");
        map.put("city", "上海");
        map.put("start", start);
        map.put("count", "10");
        map.put("client", "");
        map.put("udid", "");
        return AppRetrofit.getInstance().getHttpService().getMovie(map);
    }

    @Override
    public Observable<Map<String, Object>> requestDouBanMovieDetail(String cityName, String id) {
        Map<String, String> map = new HashMap<>();
        map.put("apikey", "0b2bdeda43b5688921839c8ecb20399b");
        map.put("city", "上海");
        map.put("client", "");
        map.put("udid", "");
        return AppRetrofit.getInstance().getHttpService().getMovieDetail(id, map);
    }

    @Override
    public Observable<Map<String, Object>> requestDouBanMoviePhotos(String cityName, String id) {
        Map<String, String> map = new HashMap<>();
        map.put("apikey", "0b2bdeda43b5688921839c8ecb20399b");
        map.put("city", "上海");
        map.put("client", "");
        map.put("udid", "");
        map.put("start", "0");
        return AppRetrofit.getInstance().getHttpService().getMoviePhotos(id, map);
    }

    @Override
    public Observable<Map<String, Object>> requestDouBanMovieReviews(String cityName, String id) {
        Map<String, String> map = new HashMap<>();
        map.put("apikey", "0b2bdeda43b5688921839c8ecb20399b");
        map.put("city", "上海");
        map.put("client", "");
        map.put("udid", "");
        map.put("start", "0");
        return AppRetrofit.getInstance().getHttpService().getMovieReviews(id, map);
    }


    @Override
    public Observable<Map<String, Object>> requestTuChongRecommend(String type, String postId, String page) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("os_api", "22");
        map.put("device_type", "");
        map.put("device_platform", "android");
        map.put("ssmix", "a");
        map.put("manifest_version_code", "232");
        map.put("dpi", "400");
        map.put("abflag", "0");
        map.put("uuid", "");
        map.put("version_code", "232");
        map.put("openudid", "");
        map.put("resolution", "");
        map.put("os_version", "");
        map.put("ac", "wifi");
        map.put("aid", "0");
        map.put("app_name", "");
        map.put("version_name", "");
//        if (isFirst) {
////如果是第一页则不需要添加该字段。否则，需要加上该字段，该字段的值为上一页最后一个 json 中的 post_id 值
//        } else {
//            map.put("post_id", postId);
//        }
        map.put("post_id",postId);
        map.put("page", page);
        map.put("type", type);
        return AppRetrofit.getInstance().getHttpService().getTuChongRecommend(map);
    }

    @Override
    public Observable<Map<String, Object>> requestTuDiscover() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("os_api", "22");
        map.put("device_type", "");
        map.put("device_platform", "android");
        map.put("ssmix", "a");
        map.put("manifest_version_code", "232");
        map.put("dpi", "400");
        map.put("abflag", "0");
        map.put("uuid", "");
        map.put("version_code", "232");
        map.put("openudid", "");
        map.put("resolution", "");
        map.put("os_version", "");
        map.put("ac", "wifi");
        map.put("aid", "0");
        map.put("app_name", "");
        map.put("version_name", "");
        return AppRetrofit.getInstance().getHttpService().getTuChongDiscover(map);
    }


}
