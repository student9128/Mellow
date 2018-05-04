package com.kevin.mellow.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/4.
 * <h3>
 * Describe:
 * <h3/>
 */
public class WebViewActivity extends BaseActivity implements View.OnKeyListener {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.web_view)
    WebView webView;
    @BindView(R.id.pb_progress_bar)
    ProgressBar pbProgressBar;
    private String webTitle;

    @Override
    public int setLayoutResId() {
        return R.layout.activity_webview;
    }

    @Override
    public void initView() {
        toolBar.setNavigationIcon(R.drawable.ic_close_activity);
        Intent intent = getIntent();
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webTitle = view.getTitle();
                actionBar.setTitle(webTitle);
            }
        });
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    pbProgressBar.setAlpha(0);
                } else {
                    pbProgressBar.setAlpha(1);
                    pbProgressBar.setVisibility(View.VISIBLE);
                    pbProgressBar.setProgress(newProgress);
                }
            }
        });
        String url = intent.getStringExtra("url");
        webView.loadUrl(url);

        webView.setOnKeyListener(this);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        } else {
            return false;
        }
    }
}
