package com.kevin.mellow.contract;

import com.kevin.mellow.base.BasePresenter;
import com.kevin.mellow.base.AppBaseView;
import com.kevin.mellow.base.BaseView;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/29.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class TuChongContract {

    public interface View extends BaseView<Presenter> {

        void showTips(String msg);

    }

    public interface Presenter extends BasePresenter {
//        void requestData(String type, String date);
        void requestData(String type,String postId,String page,boolean isFirst);

    }
}
