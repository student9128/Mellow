package com.kevin.mellow.onearticle;

import com.kevin.mellow.base.BasePresenter;
import com.kevin.mellow.base.AppBaseView;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/29.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class OneArticleContract {
    public interface View extends AppBaseView<Presenter> {

        void showTips(String msg);

    }

    public interface Presenter extends BasePresenter {
        void requestData(String type, String date);

    }
}
