package com.kevin.mellow.one;

import com.kevin.mellow.base.BasePresenter;
import com.kevin.mellow.base.AppBaseView;
import com.kevin.mellow.bean.ChineseWeekBean;

import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/28.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class ChineseContract {
    public interface View extends AppBaseView<Presenter> {

        void showTip(String msg);

        void updateData(List<ChineseWeekBean> d);
    }

    public interface Presenter extends BasePresenter {
        void requestData();

    }
}
