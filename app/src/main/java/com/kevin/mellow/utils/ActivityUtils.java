package com.kevin.mellow.utils;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/5/26.
 * <p>Blog:http://blog.csdn.net/student9128.
 * <p>
 * <h3>Description:</h3>
 * <p>This provides methods to help Activities load their UI.
 * <p>
 */


public class ActivityUtils {
    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, int frameId) {
//        checkNotNull(fragmentManager);
//        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }
}
