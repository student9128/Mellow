package com.kevin.mellow.contract;

import com.kevin.mellow.base.BasePresenter;
import com.kevin.mellow.base.LoanBaseView;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/23.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class LoginContract {
    public interface View extends LoanBaseView<Presenter> {
        void showTips(String msg);

        void finishAct();
    }

    public interface Presenter extends BasePresenter {
        void login(String account, String password);
    }

}
