package com.kevin.mellow.one;

import com.kevin.mellow.base.BasePresenter;
import com.kevin.mellow.base.AppBaseView;

import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/27.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class HomeContract {
    public interface View extends AppBaseView<Presenter> {
        void addData(List<String> data);

        void showTip(String msg);
    }

    public interface Presenter extends BasePresenter {
        void requestData();

        void requestOneList(String data);
    }

}
