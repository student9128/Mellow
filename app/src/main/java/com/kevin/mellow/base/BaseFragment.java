package com.kevin.mellow.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.kevin.mellow.dialog.BaseDialog;
import com.kevin.mellow.dialog.DialogContract;
import com.kevin.mellow.dialog.DialogContract.DialogBtnClickListener;
import com.kevin.mellow.dialog.DialogManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Kevin on 2017/3/17.
 * Blog:http://blog.csdn.net/student9128.m
 * Description:
 */

public abstract class BaseFragment extends AppBaseFragment {
    protected View mView;
    public Unbinder unbinder;
    private boolean isViewCreated = false;
    private boolean isUIVisible = false;
    private BaseDialog mProgressDialog;
    private BaseDialog mFingerprintDialog;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        mView = inflater.inflate(setLayoutResId(), container, false);
        ButterKnife.bind(this, mView);
        unbinder = ButterKnife.bind(this, mView);
        initView();
        initData();
        initListener();
        printLogi("onCreateVew===========");
//        if (getUserVisibleHint()) {
//            isUIVisible = true;
//            lazyLoad();
//        } else {
//            isUIVisible = false;
//        }
        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        printLogi("onAttach===========");
    }

    @Override
    public void onStart() {
        super.onStart();
//        refreshUI();
        if (getUserVisibleHint()) {
            isUIVisible = true;
            lazyLoad();
        } else {
            isUIVisible = false;
        }
        printLogi("onStart===============");
    }

    @Override
    public void onResume() {
        super.onResume();
        printLogi("onResume=======");
    }

    @Override
    public void onPause() {
        super.onPause();
        printLogi("onPause=====");
    }

    @Override
    public void onStop() {
        super.onStop();
        printLogd("onStop======");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        printLoge("onDestroy=======");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        printLogi("onCreate==============");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        printLogi("onActivityCreated============");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        DisposableManager.removeDispose(getClass().getName());
        unbinder.unbind();
        printLogi("onDestroyView==========="+getClass().getSimpleName());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        lazyLoad();
        printLogi("onViewCreated==========");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isUIVisible = true;
            lazyLoad();
        } else {
            isUIVisible = false;
        }
    }

    public String getDisposableKey() {
//        return mActivity.getPackageName()+SEP+TAG;
        return getClass().getName();
    }

    private void lazyLoad() {
        printLogd(isUIVisible + "============isUIVisible");
        printLogd(isViewCreated + "------------isViewCreated");
        if (isViewCreated && isUIVisible) {
//            mPresenter.requestData();
            loadData();
            isUIVisible = false;
            isViewCreated = false;
        }
    }

    /**
     * set Layout Resource Id
     *
     * @return
     */
    public abstract int setLayoutResId();

    public abstract void initView();

    public abstract void initData();

    public abstract void initListener();

    public abstract void loadData();

    /**
     * refresh user interface.
     */
//    public abstract void refreshUI();


    //===============Some Methods=================//
    public void startNewActivity(Class<? extends BaseActivity> clazz) {
        startActivity(new Intent(mActivity, clazz));
    }


    public void showLoadingDialog() {
        showLoadingDialog("");
    }

    public void showLoadingDialog(String title) {
        printLogd("showLoadingDialog");
        if (mProgressDialog != null || mActivity.isFinishing()) {
            return;
        }
        if (mProgressDialog == null) {
            mProgressDialog = DialogManager.createProgressDialog(title);
            mProgressDialog.show(getFragmentManager(), "ProgressDialog");
        }

//        showFragmentDialog(mProgressDialog,"ProgressDialog");
    }

    public void dismissLoadingDialog() {
        printLogd("dismissLoadingDialog");
        if (mProgressDialog != null) {
            if (mProgressDialog.isAdded()) {
                mProgressDialog.dismiss();
            }
            mProgressDialog = null;
        }
//        if (mProgressDialog != null && !mActivity.isFinishing()) {
//            if (mProgressDialog.isAdded()) {
//                mProgressDialog.dismiss();
//            } else {
//                mProgressDialog.dismissAllowingStateLoss();
//            }
//            mProgressDialog = null;
//        }
    }

    public void showFingerprintDialog() {
        if (mFingerprintDialog != null || mActivity.isFinishing()) {
            return;
        }
        mFingerprintDialog = DialogManager.createFingerprintDialog();
        showFragmentDialog(mFingerprintDialog, "FingerprintDialog");
    }

    public void dismissFingerprintDialog() {
        if (mFingerprintDialog != null && !mActivity.isFinishing()) {
            if (mFingerprintDialog.isAdded()) {
                mFingerprintDialog.dismiss();
            }
        }
    }

    public void showFragmentDialog(DialogFragment dialog, String tag) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(dialog, tag);
        ft.commitAllowingStateLoss();
    }

    //    @Override
    public void showAlertDialog(String title, String content, DialogBtnClickListener listener) {
        DialogContract dialogContract = (DialogContract) mActivity;
        if (dialogContract != null && !isDetached()) {
            dialogContract.showAlertDialog(title, content, listener);
        }
    }

    //    @Override
    public void showAlertDialog(String title, String content) {
        showAlertDialog(title, content, null);
    }

    //    @Override
    public void showAlertDialog(int titleResId, int contentResId, DialogContract
            .DialogBtnClickListener listener) {
        DialogContract dialogContract = (DialogContract) mActivity;
        if (dialogContract != null && !isDetached()) {
            dialogContract.showAlertDialog(titleResId, contentResId, listener);
        }
    }

    //    @Override
    public void showAlertDialog(int titleResId, int contentResId) {
        DialogContract dialogContract = (DialogContract) mActivity;
        if (dialogContract != null && !isDetached()) {
            dialogContract.showAlertDialog(titleResId, contentResId);
        }
    }

    //    @Override
    public void showNormalDialog(int titleResId, int contentResId, DialogContract
            .DialogBtnClickListener listener) {
        DialogContract dialogContract = (DialogContract) mActivity;
        if (dialogContract != null && !isDetached()) {
            dialogContract.showNormalDialog(titleResId, contentResId, listener);
        }
    }

    //    @Override
    public void showNormalDialog(String title, String content, int negativeBtn, int positiveBtn,
                                 DialogContract.DialogBtnClickListener listener) {
        DialogContract dialogContract = (DialogContract) mActivity;
        if (dialogContract != null && !isDetached()) {
            dialogContract.showNormalDialog(title, content, negativeBtn, positiveBtn, listener);
        }
    }

}