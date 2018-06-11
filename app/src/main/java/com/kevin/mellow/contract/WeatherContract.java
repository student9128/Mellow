package com.kevin.mellow.contract;

import com.kevin.mellow.base.BasePresenter;
import com.kevin.mellow.base.BaseView;
import com.kevin.mellow.bean.WeatherBean;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/6/8.
 * <h3>
 * Describe:
 * <h3/>
 */
public class WeatherContract {
    public interface View extends BaseView<Presenter> {
        void showTips(String msg);

        void showData(WeatherBean.HeWeather6Bean data);
    }
    public interface Presenter extends BasePresenter {
        void requestData(String cityName);
    }
}
