package com.kevin.mellow.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v4.os.CancellationSignal;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kevin.mellow.Injection;
import com.kevin.mellow.MainActivity;
import com.kevin.mellow.R;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.contract.LoginContract;
import com.kevin.mellow.fiingerprint.MyAuthCallback;
import com.kevin.mellow.presenter.LoginPresenter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import butterknife.BindView;

import static com.kevin.mellow.constant.Constants.MSG_AUTH_ERROR;
import static com.kevin.mellow.constant.Constants.MSG_AUTH_FAILED;
import static com.kevin.mellow.constant.Constants.MSG_AUTH_HELP;
import static com.kevin.mellow.constant.Constants.MSG_AUTH_SUCCESS;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/22.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class LoginFragment extends BaseFragment implements LoginContract.View, View.OnClickListener {
    @BindView(R.id.tv_username)
    ImageView tvUsername;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.ll_username)
    LinearLayout llUsername;
    @BindView(R.id.tv_password)
    ImageView tvPassword;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.ll_password)
    LinearLayout llPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_forgot_password)
    TextView tvForgotPassword;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    private LoginContract.Presenter mPresenter;
    private Handler handler = null;
    private FingerprintManagerCompat fingerprintManager = null;
    private MyAuthCallback myAuthCallback = null;
    private CancellationSignal cancellationSignal = null;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这里关联了对应的Presenter（LoginPresenter），同时关联网络请求的方法
        mPresenter = new LoginPresenter(this, Injection.provideLoanRepository());
    }

    @Override
    public int setLayoutResId() {
        return R.layout.fragment_login;
    }

    @Override
    public void initView() {
        initFingerprint();

    }


    @Override
    public void initData() {
    }

    @Override
    public void initListener() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showConnectError(int index, int errorCode) {

    }

    @Override
    public void showTips(String msg) {
        showToast(msg);
    }

    @Override
    public void finishAct() {
        startActivity(new Intent(mActivity, MainActivity.class));
        mActivity.finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                mPresenter.login(username, password);


                // start fingerprint auth here.
//                try {
//                    CryptoObjectHelper cryptoObjectHelper = new CryptoObjectHelper();
//                    if (cancellationSignal == null) {
//                        cancellationSignal = new CancellationSignal();
//                    }
//                    fingerprintManager.authenticate(cryptoObjectHelper.buildCryptoObject(), 0,
//                            cancellationSignal, myAuthCallback, null);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    showToast("Fingerprint init failed! Try again!");
//                }
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
    }

    private void initFingerprint() {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                Log.d(TAG, "msg: " + msg.what + " ,arg1: " + msg.arg1);
                switch (msg.what) {
                    case MSG_AUTH_SUCCESS:
                        setResultInfo(R.string.fingerprint_success);
//                        mCancelBtn.setEnabled(false);
//                        mStartBtn.setEnabled(true);
                        getFingerprintInfo();
                        cancellationSignal = null;
                        break;
                    case MSG_AUTH_FAILED:
                        setResultInfo(R.string.fingerprint_not_recognized);
//                        mCancelBtn.setEnabled(false);
//                        mStartBtn.setEnabled(true);
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

        // init fingerprint.
        fingerprintManager = FingerprintManagerCompat.from(mActivity);

        if (!fingerprintManager.isHardwareDetected()) {
            // no fingerprint sensor is detected, show dialog to tell user.
            AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
            builder.setTitle(R.string.no_sensor_dialog_title);
            builder.setMessage(R.string.no_sensor_dialog_message);
            builder.setIcon(android.R.drawable.stat_sys_warning);
            builder.setCancelable(false);
            builder.setNegativeButton(R.string.cancel_btn_dialog, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
//                    finish();
                }
            });
            // show this dialog.
            builder.create().show();
        } else if (!fingerprintManager.hasEnrolledFingerprints()) {
            // no fingerprint image has been enrolled.
            AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
            builder.setTitle(R.string.no_fingerprint_enrolled_dialog_title);
            builder.setMessage(R.string.no_fingerprint_enrolled_dialog_message);
            builder.setIcon(android.R.drawable.stat_sys_warning);
            builder.setCancelable(false);
            builder.setNegativeButton(R.string.cancel_btn_dialog, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
//                    finish();
                }
            });
            // show this dialog
            builder.create().show();
        } else {
            try {
                myAuthCallback = new MyAuthCallback(handler);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
            showToast(getString(stringId));
        } else {
            showToast(getString(stringId));
//                mResultInfo.setTextColor(getColor(R.color.warning_color));
        }
//            mResultInfo.setText(stringId);
//        }
    }


    public void getFingerprintInfo() {
        try {
            FingerprintManager fingerprintManager = (FingerprintManager) mActivity.getSystemService(Context.FINGERPRINT_SERVICE);
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

}
