package com.kevin.mellow.contract;

import com.kevin.mellow.base.BasePresenter;
import com.kevin.mellow.base.BaseView;
import com.kevin.mellow.bean.DouBanMovieDetailBean;
import com.kevin.mellow.bean.DouBanMoviePhotoBean;
import com.kevin.mellow.bean.DouBanMovieReviewBean;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/16.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class DouBanDetailContract {
    public interface View extends BaseView<Presenter> {
        void showTips(String msg);

        void showData(DouBanMovieDetailBean douBanMovieDetailBean);

        void showPhotos(DouBanMoviePhotoBean douBanMoviePhotoBean);

        void showReviews(DouBanMovieReviewBean douBanMovieReviewBean);
    }

    public interface Presenter extends BasePresenter {
        void requestData(String cityName, String id);

        void requestDataPhotos(String cityName, String id);

        void requestDataReviews(String cityName, String id);
    }
}
