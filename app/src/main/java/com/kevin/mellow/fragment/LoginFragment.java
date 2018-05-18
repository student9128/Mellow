package com.kevin.mellow.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.support.v4.os.CancellationSignal;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
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
import com.kevin.mellow.dialog.FingerprintDialog;
import com.kevin.mellow.fiingerprint.CryptoObjectHelper;
import com.kevin.mellow.fiingerprint.FingerprintUtil;
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


public class LoginFragment extends BaseFragment implements LoginContract.View, View.OnClickListener, FingerprintUtil.OnAuthFingerprintListener, FingerprintDialog.OnAuthCancelListener {
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
    private FingerprintUtil fingerprintUtil;
    private FingerprintDialog fingerprintDialog;

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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        fingerprintUtil = new FingerprintUtil(mActivity);
        fingerprintUtil.initFingerprint();
        fingerprintDialog = FingerprintDialog.newInstance();
        }
    }


    @Override
    public void initData() {
    }

    @Override
    public void initListener() {
        btnLogin.setOnClickListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        fingerprintUtil.setOnAuthSuccessListener(this);
        fingerprintDialog.setOnAuthCancelListener(this);
        }
    }

    @Override
    public void loadData() {

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

    }

    @Override
    public void showProgress() {
        showLoadingDialog();
    }

    @Override
    public void dismissProgress() {
        dismissLoadingDialog();
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
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (fingerprintUtil != null) {
            fingerprintUtil.cancelFingerprint();
        }
    }

    @Override
    public void onAuthSuccess() {
        fingerprintUtil.dismissFingerprintDialog();
        finishAct();
    }

    @Override
    public void onAuthCancel() {
        fingerprintUtil.cancelFingerprint();
        fingerprintUtil.dismissFingerprintDialog();
    }


}
