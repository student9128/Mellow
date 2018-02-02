package com.kevin.mellow.base;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/4.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public interface BaseView<T> extends AppBaseView<T> {
    void showProgressDialog();

    void dismissProgressDialog();

    void showError(int resId);
}
