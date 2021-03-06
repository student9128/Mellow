package com.kevin.mellow.contract;

import com.kevin.mellow.base.BasePresenter;
import com.kevin.mellow.base.BaseView;
import com.kevin.mellow.bean.TuChongDiscoverBean;
import com.kevin.mellow.bean.TuChongFeedBean;

import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/29.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class TuChongRecommendContract {

    public interface View extends BaseView<Presenter> {

        void showTips(String msg);

        void refreshData(List<TuChongFeedBean.FeedListBean> data);

        void loadMoreData(List<TuChongFeedBean.FeedListBean> data);

        void refreshFinish();

    }

    public interface DiscoverView extends BaseView<Presenter> {
        void showTips(String msg);

        void updateBanner(List<TuChongDiscoverBean.BannersBean> d);

        void setBannerAutoScroll();

        void showHotEvent(List<TuChongDiscoverBean.HotEventsBean> d);
    }

    public interface Presenter extends BasePresenter {
        //        void requestData(String type, String date);
        void requestData(String type, String postId, String page);

        void requestDiscoverData();
    }
}
