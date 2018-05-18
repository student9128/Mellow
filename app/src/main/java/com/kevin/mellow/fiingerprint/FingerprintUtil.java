package com.kevin.mellow.fiingerprint;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Handler;
import android.os.Message;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v4.os.CancellationSignal;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.kevin.mellow.R;
import com.kevin.mellow.dialog.FingerprintDialog;
import com.kevin.mellow.utils.ToastUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static com.kevin.mellow.constant.Constants.MSG_AUTH_ERROR;
import static com.kevin.mellow.constant.Constants.MSG_AUTH_FAILED;
import static com.kevin.mellow.constant.Constants.MSG_AUTH_HELP;
import static com.kevin.mellow.constant.Constants.MSG_AUTH_SUCCESS;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/17.
 * <h3>
 * Describe:
 * <h3/>
 */
@TargetApi(23)
public class FingerprintUtil {
    private static String TAG = "FingerprintUtil";
    private Handler mHandler = null;
    private FingerprintManagerCompat fingerprintManagerCompat = null;
    private CancellationSignal cancellationSignal = null;
    private MyAuthCallback myAuthCallback = null;

    private Context mContext;
    private AlertDialog alertDialog;

    public FingerprintUtil(Context context) {
        this.mContext = context;
    }

    public void initFingerprint() {
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case MSG_AUTH_SUCCESS:
                        getFingerprintInfo();
                        ToastUtils.showToast(mContext,"成功");
                        if (listener != null) {
                            listener.onAuthSuccess();
                        }
                        cancellationSignal = null;
                        break;
                    case MSG_AUTH_FAILED:
                        cancellationSignal = null;
                        break;
                    case MSG_AUTH_ERROR:
                        handleErrorCode(msg.arg1);
                        break;
                    case MSG_AUTH_HELP:
                        handleHelpCode(msg.arg1);
                        break;

                }
            }


        };
        fingerprintManagerCompat = FingerprintManagerCompat.from(mContext);
        if (!fingerprintManagerCompat.isHardwareDetected()) {
            //没有支持指纹的硬件
        } else if (!fingerprintManagerCompat.hasEnrolledFingerprints()) {
            //没有录入指纹
        } else {
            try {
                myAuthCallback = new MyAuthCallback(mHandler);
                showFingerprintDialog();
                verifyFingerprint();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void showFingerprintDialog() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_fingerprint, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setView(view);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (l != null) {
                    l.onAuthCancel();
                }
                    dialog.dismiss();

            }
        });
        alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

    public void dismissFingerprintDialog() {
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }

    public void verifyFingerprint() {
//        start fingerprint auth here.
        try {
            CryptoObjectHelper cryptoObjectHelper = new CryptoObjectHelper();
            if (cancellationSignal == null) {
                cancellationSignal = new CancellationSignal();
            }
            fingerprintManagerCompat.authenticate(cryptoObjectHelper.buildCryptoObject(), 0,
                    cancellationSignal, myAuthCallback, null);
        } catch (Exception e) {
            e.printStackTrace();
            ToastUtils.showToast(mContext, mContext.getString(R.string.fingerprint_init_failed));
        }
    }

    public void cancelFingerprint() {
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
            cancellationSignal = null;
        }
    }

    public void getFingerprintInfo() {
        try {
            FingerprintManager fingerprintManager = (FingerprintManager) mContext.getSystemService(Context.FINGERPRINT_SERVICE);
            Method method = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                method = FingerprintManager.class.getDeclaredMethod("getEnrolledFingerprints");
            }
            Object obj = method.invoke(fingerprintManager);
            if (obj != null) {
                Class<?> clazz = Class.forName("android.hardware.fingerprint.Fingerprint");
                Method getFingerId = clazz.getDeclaredMethod("getFingerId");
                for (int i = 0; i < ((List) obj).size(); i++) {
                    Object item = ((List) obj).get(i);
                    if (null == item) {
                        continue;
                    }

                    Log.d(TAG, "fingerId: " + getFingerId.invoke(item));
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void handleHelpCode(int code) {
        switch (code) {
            case FingerprintManager.FINGERPRINT_ACQUIRED_GOOD:
                setResultInfo(R.string.AcquiredGood_warning);
                break;
            case FingerprintManager.FINGERPRINT_ACQUIRED_IMAGER_DIRTY:
                setResultInfo(R.string.AcquiredImageDirty_warning);
                break;
            case FingerprintManager.FINGERPRINT_ACQUIRED_INSUFFICIENT:
                setResultInfo(R.string.AcquiredInsufficient_warning);
                break;
            case FingerprintManager.FINGERPRINT_ACQUIRED_PARTIAL:
                setResultInfo(R.string.AcquiredPartial_warning);
                break;
            case FingerprintManager.FINGERPRINT_ACQUIRED_TOO_FAST:
                setResultInfo(R.string.AcquiredTooFast_warning);
                break;
            case FingerprintManager.FINGERPRINT_ACQUIRED_TOO_SLOW:
                setResultInfo(R.string.AcquiredToSlow_warning);
                break;
        }
    }

    private void handleErrorCode(int code) {
        switch (code) {
            case FingerprintManager.FINGERPRINT_ERROR_CANCELED:
                setResultInfo(R.string.ErrorCanceled_warning);
                break;
            case FingerprintManager.FINGERPRINT_ERROR_HW_UNAVAILABLE:
                setResultInfo(R.string.ErrorHwUnavailable_warning);
                break;
            case FingerprintManager.FINGERPRINT_ERROR_LOCKOUT:
                setResultInfo(R.string.ErrorLockout_warning);
                break;
            case FingerprintManager.FINGERPRINT_ERROR_NO_SPACE:
                setResultInfo(R.string.ErrorNoSpace_warning);
                break;
            case FingerprintManager.FINGERPRINT_ERROR_TIMEOUT:
                setResultInfo(R.string.ErrorTimeout_warning);
                break;
            case FingerprintManager.FINGERPRINT_ERROR_UNABLE_TO_PROCESS:
                setResultInfo(R.string.ErrorUnableToProcess_warning);
                break;
        }
    }

    private void setResultInfo(int stringId) {
//        if (mResultInfo != null) {
        if (stringId == R.string.fingerprint_success) {
//                mResultInfo.setTextColor(getColor(R.color.success_color));
            ToastUtils.showToast(mContext, mContext.getString(stringId));
        } else {
            ToastUtils.showToast(mContext, mContext.getString(stringId));
//                mResultInfo.setTextColor(getColor(R.color.warning_color));
        }
//            mResultInfo.setText(stringId);
//        }
    }

    private OnAuthFingerprintListener listener;

    public interface OnAuthFingerprintListener {
        void onAuthSuccess();

    }

    public void setOnAuthSuccessListener(OnAuthFingerprintListener l) {
        listener = l;
    }

    private FingerprintDialog.OnAuthCancelListener l;

    public interface OnAuthCancelListener {
        void onAuthCancel();
    }

    public void setOnAuthCancelListener(FingerprintDialog.OnAuthCancelListener l) {
        this.l = l;
    }


}


