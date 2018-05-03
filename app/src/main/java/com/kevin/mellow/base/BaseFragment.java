package com.kevin.mellow.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevin.mellow.dialog.DialogContract;
import com.kevin.mellow.dialog.DialogContract.DialogBtnClickListener;

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
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(setLayoutResId(), container, false);
        ButterKnife.bind(this, mView);
        unbinder = ButterKnife.bind(this, mView);
        initView();
        initData();
        initListener();
        printLogi("onCreateVew");
        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
//        refreshUI();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        lazyLoad();
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
    private void lazyLoad() {
        if (isViewCreated && isUIVisible) {
//            mPresenter.requestData();
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

    /**
     * refresh user interface.
     */
//    public abstract void refreshUI();


    //===============Some Methods=================//
    public void startNewActivity(Class<? extends BaseActivity> clazz) {
        startActivity(new Intent(mActivity, clazz));
    }



    public void showProgressDialog() {
        printLogd("showProgressDialog");
    }

    public void dismissProgressDialog() {
        printLogd("dismissProgressDialog");
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
    public void showAlertDialog(int titleResId, int contentResId, DialogContract.DialogBtnClickListener listener) {
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
    public void showNormalDialog(int titleResId, int contentResId, DialogContract.DialogBtnClickListener listener) {
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