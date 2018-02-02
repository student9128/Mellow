package com.kevin.mellow.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/21.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class BaseApplication extends Application {
    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}
