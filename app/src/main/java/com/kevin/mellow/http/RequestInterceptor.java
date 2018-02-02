package com.kevin.mellow.http;

import android.util.Log;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 请求拦截器，修改请求header
 */
public class RequestInterceptor implements Interceptor {
    private static Map<String, String> map;

    public RequestInterceptor() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder mBuild = original.newBuilder();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                mBuild.header(entry.getKey(), entry.getValue());
            }
        }
        Request request = mBuild.build();
        Log.d("RequestInterceptor", "request:" + request.toString());
        Log.d("RequestInterceptor", "request headers:" + request.headers().toString());
        return chain.proceed(request);
    }
}