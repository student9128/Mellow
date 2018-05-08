package com.kevin.mellow.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.dialog.BaseDialog;
import com.kevin.mellow.dialog.CommonDialog;
import com.kevin.mellow.dialog.DialogContract;
import com.kevin.mellow.dialog.DialogManager;
import com.kevin.mellow.utils.LogK;
import com.kevin.mellow.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> for Project KevinSummary on 2017/9/8.
 * <h3>Description:</h3>
 * <div>
 * <br/>Base class for all the activities in the app except AppBaseActivity.
 * </div>
 */

public abstract class BaseActivity extends AppCompatActivity implements
        ActivityCompat.OnRequestPermissionsResultCallback {
    /**
     * Tag,can be used for log or toast.
     */
    public String TAG = getClass().getSimpleName();

//    private DayNightHelper mDayNightHelper;
//    public LoadingDialog mLoadingDialog;

    //    @BindView(R.id.title_bar)
//    public LinearLayout titleTar;
    @BindView(R.id.tv_title)
    public TextView tvTitle;
    @BindView(R.id.iv_function)
    public ImageView ivFunction;
    @BindView(R.id.tool_bar)
    public Toolbar toolBar;
    public ActionBar actionBar;
    private BaseDialog mProgressDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResId());
        ButterKnife.bind(this);
        setSupportActionBar(toolBar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        initView();
//        initData();
//        initListener();

    }


    public abstract int setLayoutResId();

    public abstract void initView();

//    public abstract void initData();
//
//    public abstract void initListener();
    //===============Some Methods=================//

    //    /**
//     * init Loading Dialog.
//     */
//    public void initLoadingDialog() {
//        mLoadingDialog = new LoadingDialog();
//    }
//
//    /**
//     * show Loading Dialog.
//     */
//    public void showLoadingDialog() {
//        mLoadingDialog.show(getSupportFragmentManager(), TAG);
//    }
//
//    /**
//     * dismiss Loading Dialog.
//     */
//    public void dismissLoadingDialog() {
//        if (mLoadingDialog.isAdded()) {
//            mLoadingDialog.dismiss();
//        }
//    }
//}
//    }
    public void showToast(String message) {
        ToastUtils.showToast(this, message);
    }

    public void startNewActivity(Class<? extends BaseActivity> clazz) {
        startActivity(new Intent(this, clazz));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return true;
    }

    public void showProgressDialog() {
        showProgressDialog("");
    }

    public void showProgressDialog(String title) {
        printLogd("showLoadingDialog");
        if (mProgressDialog != mProgressDialog || isFinishing()) {
            return;
        }
       mProgressDialog= DialogManager.createProgressDialog(title);
        showFragmentDialog(mProgressDialog,"ProgressDialog");
    }

    public void dismissProgressDialog() {
        printLogd("dismissLoadingDialog");
        if (mProgressDialog != null && !isFinishing()) {
            if (mProgressDialog.isAdded()) {
                mProgressDialog.dismiss();
            } else {
                mProgressDialog.dismissAllowingStateLoss();
            }
            mProgressDialog = null;
        }
    }

    //    @Override
    public void showNormalDialog(int titleResId, int contentResId, DialogContract.DialogBtnClickListener listener) {

    }

    //    @Override
    public void showNormalDialog(String title, String content, int negativeBtn, int positiveBtn,
                                 DialogContract.DialogBtnClickListener listener) {

    }

    //    @Override
    public void showNormalDialog(int titleResId, int contentResId, int negativeBtn, int positiveBtn,
                                 DialogContract.DialogBtnClickListener listener) {
        if (isFinishing()) {
            return;
        }
        String title = getStringById(titleResId);
        String content = getStringById(contentResId);
        String negativeButton = getStringById(negativeBtn);
        String positiveButton = getStringById(positiveBtn);
        showFragmentDialog(CommonDialog.newInstance(title, content, listener, negativeButton,
                positiveButton), "NormalDialog");
    }

    @Nullable
    private String getStringById(int resId) {
        return resId == View.NO_ID || resId == 0 ? null : getString(resId);
    }

    public void showFragmentDialog(DialogFragment dialog, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(dialog, tag);
        ft.commitAllowingStateLoss();
    }


    public void printLoge(String str) {
        LogK.e(TAG, str);
    }

    public void printLogd(String str) {
        LogK.d(TAG, str);
    }

    public void printLogi(String str) {
        LogK.i(TAG, str);
    }

    public void printLogv(String str) {
        LogK.v(TAG, str);
    }

    public void printLogw(String str) {
        LogK.w(TAG, str);
    }

}
