package com.kevin.mellow.contract;

import com.kevin.mellow.base.BasePresenter;
import com.kevin.mellow.base.BaseView;
import com.kevin.mellow.bean.CitySearchBean;

import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/6/10.
 * <h3>
 * Describe:
 * <h3/>
 */
public class CitySearchContract {
    public interface View extends BaseView<Presenter> {
        void showTips(String msg);

        void showStatus(String status);

        void showData(List<CitySearchBean.HeWeather6Bean.BasicBean> d);
    }

    public interface Presenter extends BasePresenter {
        void requestData(String cityName);
        /**
         * 获取热门城市信息
         */
        void requestDataHot();
    }

}
