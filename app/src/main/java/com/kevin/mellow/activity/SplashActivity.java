package com.kevin.mellow.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.hanks.htextview.typer.TyperTextView;
import com.kevin.mellow.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/26.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class SplashActivity extends AppCompatActivity {
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.type_text_view)
    TyperTextView typeTextView;
//    @BindView(R.id.line_text_view)
//    LineTextView lineTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);//添加防截屏功能
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        if (!this.isTaskRoot()) {
            Intent intent = getIntent();
            if (intent != null) {
                String action = intent.getAction();
                if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && intent.ACTION_MAIN.equals(action)) {
                    finish();
                    return;
                }
            }
        }
//        lineTextView.animateText(getText(R.string.app_name));
//        lineTextView.setLineColor(ContextCompat.getColor(this,R.color.white));
        typeTextView.animateText(getText(R.string.statement));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //从显示到完全透明
                Animation fadeOut = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.animation_fadeout);
                fadeOut.setFillAfter(true);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        }, 2000);
    }
}
