package com.kevin.mellow.fingerprint;

import android.os.Handler;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.util.Log;

import com.kevin.mellow.constant.Constants;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyAuthCallback extends FingerprintManagerCompat.AuthenticationCallback {
    private static String TAG = "MyAuthCallback";
    private Handler handler = null;

    public MyAuthCallback(Handler handler) {
        super();

        this.handler = handler;
    }

    @Override
    public void onAuthenticationError(int errMsgId, CharSequence errString) {
        super.onAuthenticationError(errMsgId, errString);

        if (handler != null) {
            handler.obtainMessage(Constants.MSG_AUTH_ERROR, errMsgId, 0).sendToTarget();
        }
    }

    @Override
    public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
        super.onAuthenticationHelp(helpMsgId, helpString);

        if (handler != null) {
            handler.obtainMessage(Constants.MSG_AUTH_HELP, helpMsgId, 0).sendToTarget();
        }
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult result) {
        super.onAuthenticationSucceeded(result);
        try {
            Field field = result.getClass().getDeclaredField("mFingerprint");
            field.setAccessible(true);
            Object fingerPrint = field.get(result);

            Class<?> clazz = Class.forName("android.hardware.fingerprint.Fingerprint");
            Method getName = clazz.getDeclaredMethod("getName");
            Method getFingerId = clazz.getDeclaredMethod("getFingerId");
            Method getGroupId = clazz.getDeclaredMethod("getGroupId");
            Method getDeviceId = clazz.getDeclaredMethod("getDeviceId");

            CharSequence name = (CharSequence) getName.invoke(fingerPrint);
            int fingerId = (int) getFingerId.invoke(fingerPrint);
            int groupId = (int) getGroupId.invoke(fingerPrint);
            long deviceId = (long) getDeviceId.invoke(fingerPrint);

            Log.d(TAG, "name: " + name);
            Log.d(TAG, "fingerId: " + fingerId);
            Log.d(TAG, "groupId: " + groupId);
            Log.d(TAG, "deviceId: " + deviceId);
        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        if (handler != null) {
            handler.obtainMessage(Constants.MSG_AUTH_SUCCESS).sendToTarget();
        }
    }

    @Override
    public void onAuthenticationFailed() {
        super.onAuthenticationFailed();

        if (handler != null) {
            handler.obtainMessage(Constants.MSG_AUTH_FAILED).sendToTarget();
        }
    }
}
