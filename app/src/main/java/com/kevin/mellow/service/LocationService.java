package com.kevin.mellow.service;

import android.content.Context;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/18.
 * <h3>
 * Describe:
 * <h3/>
 */
public class LocationService {
    private  LocationClient mClient = null;
    private  LocationClientOption mOption, mDIYOption;
    private Object mObjLock = new Object();
    private volatile static LocationService mLocationService;

    public LocationService(Context context) {
        synchronized (LocationService.class) {
            if (mClient == null) {
                mClient = new LocationClient(context);
                mClient.setLocOption(getDefaultLocationClientOption());
            }
        }
    }

    public static LocationService getInstance(Context context) {
        if (mLocationService == null) {
            synchronized (LocationService.class) {
                if (mLocationService == null) {
                mLocationService = new LocationService(context);
                }
            }
        }
        return mLocationService;
    }


    public boolean registerListener(BDAbstractLocationListener listener) {
        boolean isSuccess = false;
        if (listener != null) {
            mClient.registerLocationListener(listener);
            isSuccess = true;
        }
        return isSuccess;
    }

    public void unregisterListener(BDAbstractLocationListener listener) {
        if (listener != null) {
            mClient.unRegisterLocationListener(listener);
        }
    }

    public boolean setLocationOption(LocationClientOption option) {
        boolean isSuccess = false;
        if (option != null) {
            if (mClient.isStarted()) {
                mClient.stop();
                mDIYOption = option;
                mClient.setLocOption(option);
            }
        }
        return isSuccess;
    }

    /***
     *
     * @return DefaultLocationClientOption  默认O设置
     */
    public LocationClientOption getDefaultLocationClientOption() {
        if (mOption == null) {
            mOption = new LocationClientOption();
            mOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
            mOption.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系，如果配合百度地图使用，建议设置为bd09ll;
            mOption.setScanSpan(3000);//可选，默认0，即仅定位一次，设置发起连续定位请求的间隔需要大于等于1000ms才是有效的
            mOption.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
            mOption.setIsNeedLocationDescribe(true);//可选，设置是否需要地址描述
            mOption.setNeedDeviceDirect(false);//可选，设置是否需要设备方向结果
            mOption.setLocationNotify(false);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
            mOption.setIgnoreKillProcess(true);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
            mOption.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
            mOption.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
            mOption.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
            mOption.setOpenGps(true);//可选，默认false，设置是否开启Gps定位
            mOption.setIsNeedAltitude(false);//可选，默认false，设置定位时是否需要海拔信息，默认不需要，除基础定位版本都可用

        }
        return mOption;
    }

    public LocationClientOption getOption() {
        if (mDIYOption == null) {
            mDIYOption = new LocationClientOption();
        }
        return mDIYOption;
    }

    public void start() {
        synchronized (LocationService.class) {
            if (mClient != null && !mClient.isStarted()) {
                mClient.start();
            }
        }
    }

    public void stop() {
        synchronized (LocationService.class) {
            if (mClient != null && mClient.isStarted()) {
                mClient.stop();
            }
        }
    }

    public boolean isStart() {
        return mClient.isStarted();
    }

    public boolean requestHotSpotState() {
        return mClient.requestHotSpotState();
    }
}
