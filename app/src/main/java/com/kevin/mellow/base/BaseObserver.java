package com.kevin.mellow.base;


import com.google.gson.JsonParseException;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.kevin.mellow.http.HttpStatusCode;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/4.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public abstract class BaseObserver<T> implements Observer<T> {
    /***自定义编码****/
    private static final int CONNECT_EXCEPTION = 1001;
    private static final int INTERRUPTED_IO_EXCEPTION = 1002;
    private static final int PARSE_CEPTION = 1003;
    private static final int UNKNOW_ERROR = 1004;
    private BaseView baseView;

    public BaseObserver(BaseView baseView) {
        this.baseView = baseView;
    }


    public BaseObserver() {
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
    }

    @Override
    public void onError(Throwable e) {
        baseView.dismissProgressDialog();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            baseView.showError(HttpStatusCode.getErrorDesResId(httpException.code()));
        } else if (e instanceof ConnectException ||
                e instanceof UnknownHostException) {
            //连接错误
            baseView.showError(HttpStatusCode.getErrorDesResId(CONNECT_EXCEPTION));
        } else if (e instanceof InterruptedIOException)

        {
            //连接中断
            baseView.showError(HttpStatusCode.getErrorDesResId(INTERRUPTED_IO_EXCEPTION));
        } else if (e instanceof JsonParseException ||
                e instanceof JSONException ||
                e instanceof ParseException)

        {
            //解析错误
            baseView.showError(HttpStatusCode.getErrorDesResId(PARSE_CEPTION));
        } else

        {
            //未知错误
            baseView.showError(HttpStatusCode.getErrorDesResId(UNKNOW_ERROR));
        }

    }

    @Override
    public void onComplete() {

    }
}
