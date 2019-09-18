package com.kevin.mellow.presenter;

import com.kevin.mellow.R;
import com.kevin.mellow.contract.LoginContract;
import com.kevin.mellow.data.source.LoanDataSource;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/23.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View view;
    private LoanDataSource loanDataSource;

    public LoginPresenter(LoginContract.View view, LoanDataSource loanDataSource) {
        this.view = view;
        this.loanDataSource = loanDataSource;
        view.setPresenter(this);
    }

    @Override
    public void login(String account, String password) {
        //可以在这里进行账号密码校验
//        if (TextUtils.isEmpty(account) && TextUtils.isEmpty(password)) {
//            view.showTips("用户名账号不能为空");
//        } else if (TextUtils.isEmpty(account)) {
//            view.showTips("用户名不能为空");
//        } else if (TextUtils.isEmpty(password)) {
//            view.showTips("密码不能为空");
//        } else {
            loanDataSource.login(account, password);
            view.showTips(R.string.login_success_tip);
            view.finishAct();
//        }
    }
}
