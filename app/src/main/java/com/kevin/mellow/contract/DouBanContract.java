package com.kevin.mellow.contract;

import com.kevin.mellow.base.BasePresenter;
import com.kevin.mellow.base.BaseView;
import com.kevin.mellow.bean.DouBanMovieBean;

import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/3.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class DouBanContract {
    public interface View extends BaseView<Presenter> {
        void showTips(String msg);

        void refreshFinish();

        void loadMoreData(List<DouBanMovieBean.SubjectsBean> data);

        void refreshData(List<DouBanMovieBean.SubjectsBean> data);
    }

    public interface Presenter extends BasePresenter {
        /**
         * @param cityName
         * @param page
         * @param type     refresh or load more.
         */
        void requestData(String cityName, String page, String type);
    }

}
