package com.kevin.mellow.utils;

import android.util.Log;

import com.kevin.mellow.BuildConfig;


/**
 * <p>
 * Created by <b><a style="color:#8BC34A"href="http://blog.csdn.net/student9128">Jingpeng</ a></b> on 2017/2/16.
 * <p>
 * <p>
 * <br/>the utils for log.
 * </p >
 */

public class LogK {
    /**
     * set IS_DEBUG false when release to close log.
     */
//    private static boolean IS_DEBUG = true;
    private static boolean IS_DEBUG = BuildConfig.DEBUG;
//    private static boolean IS_DEBUG = false;

    public static void i(String tag, String message) {
        if (IS_DEBUG) {
            if (null == message) {
                Log.i(tag + "-->", "message is null", new Throwable(new Throwable()));
            } else {
                Log.i(tag + "-->", message);
            }
        }
    }

    public static void e(String tag, String message) {
        if (IS_DEBUG) {
            if (null == message) {
                Log.e(tag + "-->", "message is null", new Throwable(new Throwable()));
            } else {
                Log.e(tag + "-->", message);
            }
        }
    }

    public static void w(String tag, String message) {
        if (IS_DEBUG) {
            if (null == message) {
                Log.w(tag + "-->", "message is null", new Throwable(new Throwable()));
            } else {
                Log.w(tag + "-->", message);
            }
        }
    }

    public static void v(String tag, String message) {
        if (IS_DEBUG) {
            if (null == message) {
                Log.v(tag + "-->", "message is null", new Throwable(new Throwable()));
            } else {
                Log.v(tag + "-->", message);
            }
        }
    }

    public static void d(String tag, String message) {
        if (IS_DEBUG) {
            if (null == message) {
                Log.d(tag + "-->", "message is null", new Throwable(new Throwable()));
            } else {
                Log.d(tag + "-->", message);
            }
        }
    }

}
