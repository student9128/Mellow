package com.kevin.mellow.base;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/23.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public interface LoanBaseView<T> extends AppBaseView<T> {
    void showProgress();

    void dismissProgress();

    void showConnectError(int index,int errorCode);
}
