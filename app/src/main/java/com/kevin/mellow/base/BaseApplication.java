package com.kevin.mellow.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.KeyguardManager;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;

import com.baidu.mapapi.SDKInitializer;
import com.kevin.mellow.service.LocationService;
import com.mob.MobSDK;
import com.squareup.leakcanary.LeakCanary;

import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/21.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class BaseApplication extends Application {
    private static Context mContext;
    private static int activityCount = 0;
    public static LocationService mLocationService;
    private Vibrator mVibrator;

    public static Context getContext() {
        return mContext;
    }

    public static LocationService getLocationService() {
        return mLocationService;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initLifecycle();
        mVibrator = (Vibrator) mContext.getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(getApplicationContext());//百度地图初始化
        mLocationService = LocationService.getInstance(getApplicationContext());
        LeakCanary.install(this);
        MobSDK.init(this);
    }

    private void initLifecycle() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {
                activityCount++;
            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {
                activityCount--;
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    private boolean isBackground() {
        if (activityCount == 0) {
            return true;
        } else {
            return false;
        }
    }


}
