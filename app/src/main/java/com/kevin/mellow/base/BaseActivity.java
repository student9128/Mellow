package com.kevin.mellow.base;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.dialog.BaseDialog;
import com.kevin.mellow.dialog.CommonDialog;
import com.kevin.mellow.dialog.DialogContract;
import com.kevin.mellow.dialog.DialogManager;
import com.kevin.mellow.receiver.KeyReceiver;
import com.kevin.mellow.utils.FastBlur;
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

public abstract class BaseActivity extends AppBaseActivity implements
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
    @BindView(R.id.ll_title)
    public LinearLayout llTitle;
    @BindView(R.id.iv_arrow_down)
    public ImageView ivArrowDown;
    @BindView(R.id.tool_bar)
    public Toolbar toolBar;

    public ActionBar actionBar;
    private BaseDialog mProgressDialog;
    private BaseDialog mFingerprintDialog;
    private KeyReceiver keyReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(setLayoutResId());
        ButterKnife.bind(this);
        setSupportActionBar(toolBar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        initView();
//        initData();
//        initListener();
//        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
//        keyReceiver = new KeyReceiver();
//        registerReceiver(keyReceiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(keyReceiver);
    }

    public abstract int setLayoutResId();

    public abstract void initView();

//    public abstract void initData();
//
//    public abstract void initListener();
    //===============Some Methods=================//


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

    public void showLoadingDialog() {
        showLoadingDialog("");
    }

    public void showLoadingDialog(String title) {
        printLogd("showLoadingDialog");
        if (mProgressDialog != null || isFinishing()) {
            return;
        }
        if (mProgressDialog == null) {
            mProgressDialog = DialogManager.createProgressDialog(title);
            showFragmentDialog(mProgressDialog, "ProgressDialog");
        }
//        mProgressDialog.show(getSupportFragmentManager(),"");
    }

    public void dismissLoadingDialog() {
        printLogd("dismissLoadingDialog");
        if (mProgressDialog != null && !isFinishing()) {
            if (mProgressDialog.isAdded()) {
                mProgressDialog.dismiss();
            }
        }
    }

    public void showFingerprintDialog() {
        if (mFingerprintDialog != null || isFinishing()) {
            return;
        }
        mFingerprintDialog = DialogManager.createFingerprintDialog();
        showFragmentDialog(mFingerprintDialog, "FingerprintDialog");
    }

    public void dismissFingerprintDialog() {
        if (mFingerprintDialog != null && !isFinishing()) {
            if (mFingerprintDialog.isAdded()) {
                mFingerprintDialog.dismiss();
            }
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



    public void showFragmentDialog(DialogFragment dialog, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(dialog, tag);
        ft.commitAllowingStateLoss();
    }




}
