package com.kevin.mellow.presenter;

import com.google.gson.Gson;
import com.kevin.mellow.base.BaseObserver;
import com.kevin.mellow.bean.CitySearchBean;
import com.kevin.mellow.contract.CitySearchContract;
import com.kevin.mellow.data.source.RequestDataSource;
import com.kevin.mellow.utils.LogK;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/6/11.
 * <h3>
 * Describe:
 * <h3/>
 */
public class CitySearchPresenter implements CitySearchContract.Presenter {
    private CitySearchContract.View view;
    private RequestDataSource requestDataSource;
    public String TAG = getClass().getSimpleName();

    public CitySearchPresenter(CitySearchContract.View view, RequestDataSource requestDataSource) {
        this.view = view;
        this.requestDataSource = requestDataSource;
        this.view.setPresenter(this);
    }

    @Override
    public void requestData(String cityName) {
        Observable<Map<String, Object>> mapObservable = requestDataSource.requestWeatherCity
                (cityName);
        mapObservable.subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Map<String, Object>>(view, view.getUniqueTag()) {
                    @Override
                    public void onNext(Map<String, Object> stringObjectMap) {
                        super.onNext(stringObjectMap);
                        Gson gson = new Gson();
                        String responseStr = gson.toJson(stringObjectMap);
                        LogK.d(TAG, "onNext:==" + responseStr);
                        CitySearchBean citySearchBean = new Gson().fromJson(responseStr,
                                CitySearchBean.class);
                        List<CitySearchBean.HeWeather6Bean> heWeather6 = citySearchBean
                                .getHeWeather6();
                        CitySearchBean.HeWeather6Bean heWeather6Bean = citySearchBean
                                .getHeWeather6().get(0);
                        List<CitySearchBean.HeWeather6Bean.BasicBean> basic = heWeather6Bean
                                .getBasic();
                        String status = heWeather6Bean.getStatus();
                        if ("ok".equals(status)) {
                            view.showData(basic);
                        } else {
                            view.showStatus(status);
                        }

                    }
                });
    }

    @Override
    public void requestDataHot() {
        Observable<Map<String, Object>> mapObservable = requestDataSource.requestHotCity();
        mapObservable.subscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Map<String, Object>>(view, view.getUniqueTag()) {
                    @Override
                    public void onNext(Map<String, Object> stringObjectMap) {
                        super.onNext(stringObjectMap);
                        Gson gson = new Gson();
                        String responseStr = gson.toJson(stringObjectMap);
                        LogK.d(TAG, responseStr);

                    }
                });
    }
}
