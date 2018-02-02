package com.kevin.mellow.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

import com.kevin.mellow.base.BaseApplication;
import com.kevin.mellow.fragment.OneFragment;

import java.util.UUID;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/26.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class DeviceUtils {
    private OneFragment fragment;
    private String uniqueId;

    public DeviceUtils(OneFragment fragment) {
        this.fragment = fragment;
    }

    public String getUuid(Context context) {
        final TelephonyManager tm = (TelephonyManager) BaseApplication.getContext().getSystemService(Context.TELEPHONY_SERVICE);

        final String tmDevice, tmSerial, tmPhone, androidId;
//        if (!PermissionManager.hasPermission(context, Manifest.permission.READ_PHONE_STATE)) {
//            PermissionManager.requestPermission(fragment, PermissionManager.READ_PHONE_STATE_REQUEST_CODE,
//                    0, "");
//        } else {
//            }
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
//            return TODO;
            ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, "需要授限");
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_PHONE_STATE}, 1);

            tmDevice = "" + tm.getDeviceId();
            tmSerial = "" + tm.getSimSerialNumber();
            androidId = "" + android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
            UUID deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
            uniqueId = deviceUuid.toString();
        }

        return uniqueId;
    }
}
