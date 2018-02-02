package com.kevin.mellow.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.kevin.mellow.utils.ActivityUtils;
import com.kevin.mellow.R;
import com.kevin.mellow.base.BaseActivity;
import com.kevin.mellow.fragment.LoginFragment;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/22.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class LoginActivity extends BaseActivity {
    @Override
    public int setLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        toolBar.setVisibility(View.GONE);
        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.fl_content);
        if (null == loginFragment) {
            loginFragment = LoginFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), loginFragment, R.id.fl_content);
        }
    }

}
