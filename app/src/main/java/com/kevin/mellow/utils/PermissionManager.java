package com.kevin.mellow.utils;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.kevin.mellow.R;
import com.kevin.mellow.base.BaseActivity;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.dialog.DialogContract;

import java.util.ArrayList;
import java.util.List;

/**
 * A util class that use to check whether have some permissions that granted by android system.
 */
public class PermissionManager {


    // external storage permission request code.
    public static final int EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE = 1;
    public static final int LOCATION_PERMISSION_REQUEST_CODE = 2;
    public static final int CAMERA_PERMISSION_REQUEST_CODE = 3;
    public static final int CAMERA_STORAGE_PERMISSION_REQUEST_CODE = 4;
    public static final int READ_PHONE_STATE_REQUEST_CODE = 5;

    public static boolean hasLocationPermission(Context context) {
        return hasPermission(context, Manifest.permission.ACCESS_FINE_LOCATION);
    }

    public static boolean hasExternalStoragePermission(Context context) {
        return hasPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    public static boolean hasCameraPermission(Context context) {
        return hasPermission(context, Manifest.permission.CAMERA);
    }

    public static boolean hasPermission(Context context, String permissionName) {
        int permissionCheck = ContextCompat.checkSelfPermission(context, permissionName);
        return permissionCheck == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestLocationPermission(BaseActivity activity, int requestCode) {
        requestPermission(activity, requestCode, R.string.permission_location_rationale, Manifest.permission.ACCESS_FINE_LOCATION);
    }

    public static void requestExternalStoragePermission(BaseActivity activity, int requestCode) {
        requestPermission(activity, requestCode, R.string.permission_external_storage_rationale, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    public static void requestPermission(final BaseActivity activity, final int requestCode, int rationaleResId, final String... permissionName) {
        List<String> shouldShowRationale = getShouldShowRequestPermissionRationale(activity, permissionName);
        if (shouldShowRationale != null && shouldShowRationale.size() > 0) {
            if (rationaleResId <= 0) {
                rationaleResId = R.string.permission_common_rationale;
            }
            activity.showNormalDialog(-1, rationaleResId, new DialogContract.DialogBtnClickListener() {
                @Override
                public void onClickNegativeButton(DialogInterface dialog, Object data) {
                    ActivityCompat.requestPermissions(activity, permissionName, requestCode);
                }

                @Override
                public void onClickPositiveButton(DialogInterface dialog, Object data) {

                }

                @Override
                public void onClickConfirmButton(DialogInterface dialog, Object data) {

                }
            }
            );
        } else {
            ActivityCompat.requestPermissions(activity, permissionName, requestCode);
        }

    }

    private static List<String> getShouldShowRequestPermissionRationale(BaseActivity activity, String... permissionNames) {
        if (activity == null || permissionNames == null) {
            return null;
        }

        List<String> permissions = new ArrayList<>();
        for (String permission : permissionNames) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                permissions.add(permission);
            }
        }

        return permissions;
    }

    public static void requestLocationPermission(BaseFragment fragment, int requestCode) {
        requestPermission(fragment, requestCode, R.string.permission_location_rationale, Manifest.permission.ACCESS_FINE_LOCATION);
    }

    public static void requestPermission(final BaseFragment fragment, final int requestCode, int rationaleResId, final String... permissionName) {
        List<String> shouldShowRationale = getShouldShowRequestPermissionRationale(fragment, permissionName);
        if (shouldShowRationale != null && shouldShowRationale.size() > 0) {
            if (rationaleResId <= 0) {
                rationaleResId = R.string.permission_common_rationale;
            }
            fragment.showNormalDialog(-1, rationaleResId, new DialogContract.DialogBtnClickListener(){

                @Override
                public void onClickNegativeButton(DialogInterface dialog, Object data) {
                    fragment.requestPermissions(permissionName, requestCode);

                }

                @Override
                public void onClickPositiveButton(DialogInterface dialog, Object data) {

                }

                @Override
                public void onClickConfirmButton(DialogInterface dialog, Object data) {
                    // Nothing to do.
                }
            });
        } else {
            fragment.requestPermissions(permissionName, requestCode);
        }

    }

    private static List<String> getShouldShowRequestPermissionRationale(BaseFragment fragment, String... permissionNames) {
        if (fragment == null || permissionNames == null) {
            return null;
        }

        List<String> permissions = new ArrayList<>();
        for (String permission : permissionNames) {
            if (fragment.shouldShowRequestPermissionRationale(permission)) {
                permissions.add(permission);
            }
        }

        return permissions;
    }
}
