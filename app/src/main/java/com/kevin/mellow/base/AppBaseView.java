package com.kevin.mellow.base;

/**
 * Created by <b><a style="color:#8BC34A"href="http://blog.csdn.net/student9128">Kevin</a></b> on 2017/5/26.
 * <p>Blog:http://blog.csdn.net/student9128.
 * <p><b>Description:</b>
 * </p >
 */


public interface AppBaseView<T> {
    void setPresenter(T presenter);

    String getUniqueTag();
}
