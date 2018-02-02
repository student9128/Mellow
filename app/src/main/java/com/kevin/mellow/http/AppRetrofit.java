package com.kevin.mellow.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/6/11.
 * <p>Blog:http://blog.csdn.net/student9128.
 * <p>
 * <h3>Description:</h3>
 * <p>
 * <p>
 */


public class AppRetrofit {
    public static String BASE_URL = "http://v3.wufazhuce.com:8000/api/";
    public static String ONE_ARTICLE_BASE_URL = "https://interface.meiriyiwen.com/";
    public static String BASE_URL_TU_CHONG = "https://api.tuchong.com/";
    public static String BASE_URL_TOU_TIAO = "http://is.snssdk.com/";
    public static String BASE_URL_NEI_HAN = "http://lf.snssdk.com/neihan/service/tabs/";
    public static String BASE_URL_DOU_BAN = "https://api.douban.com/";
    private static int CONNET_TIME_OUT = 20;
    private static int READ_TIME_OUT = 120;
    private Retrofit retrofit;
    private static AppRetrofit appRetrofit;
    private static CacheInterceptor cacheInterceptor = new CacheInterceptor();//缓存拦截器

    public AppRetrofit() {
        retrofit = new Retrofit.Builder()
                .client(initBuilder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL_TU_CHONG)
                .build();
    }

    public <T> T create(Class<T> service) {

        return retrofit.create(service);
    }

    public AppRetrofit(String baseUrl) {
        retrofit = new Retrofit.Builder()
                .client(initBuilder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

    public AppRetrofit(int connectTimeOut) {
        CONNET_TIME_OUT = connectTimeOut;
        retrofit = new Retrofit.Builder()
                .client(initBuilder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private OkHttpClient.Builder initBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.sslSocketFactory(SSLSocketFactoryUtils.createSSLSocketFactory(), SSLSocketFactoryUtils.createTrustAllManager())
                .hostnameVerifier(new SSLSocketFactoryUtils.TrustAllHostnameVerifier());
//        builder.sslSocketFactory(TrustManager.getUnsafeOkHttpClient())
//                .hostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl oldHttpUrl = request.url();
                Request.Builder requestBuilder = request.newBuilder();
                List<String> headerValues = request.headers("url_name");
                if (headerValues != null && headerValues.size() > 0) {
                    requestBuilder.removeHeader("url_name");
                    String headerValue = headerValues.get(0);
                    HttpUrl newBaseUrl = null;
                    if ("nei_han".equals(headerValue)) {
                        newBaseUrl = HttpUrl.parse(BASE_URL_NEI_HAN);
                    } else if ("tou_tiao".equals(headerValue)) {
                        newBaseUrl = HttpUrl.parse(BASE_URL_TOU_TIAO);
                    } else if ("tu_chong".equals(headerValue)) {
                        newBaseUrl = HttpUrl.parse(BASE_URL_TU_CHONG);
                    } else if ("dou_ban".equals(headerValue)) {
                        newBaseUrl = HttpUrl.parse(BASE_URL_DOU_BAN);
                    } else {
                        newBaseUrl = oldHttpUrl;
                    }
                    HttpUrl newFullUrl = oldHttpUrl.newBuilder()
                            .scheme(newBaseUrl.scheme())
                            .host(newBaseUrl.host())
                            .port(newBaseUrl.port())
                            .build();
                    return chain.proceed(requestBuilder.url(newFullUrl).build());
                } else {
                    return chain.proceed(request);
                }
            }
        });
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);
        builder.retryOnConnectionFailure(true);//连接失败后重试
        builder.connectTimeout(20, TimeUnit.SECONDS);
        builder.readTimeout(60, TimeUnit.SECONDS);
        return builder;
    }

    public static AppRetrofit getInstance() {
        if (appRetrofit == null) {
            synchronized (AppRetrofit.class) {
                appRetrofit = new AppRetrofit();
            }
        }
        return appRetrofit;
    }

    public static AppRetrofit getInstance(String baseUrl) {
        if (appRetrofit == null) {
            synchronized (AppRetrofit.class) {
                appRetrofit = new AppRetrofit(baseUrl);
            }
        }
        return appRetrofit;
    }

    public HttpInterface getHttpService() {
        return getInstance().create(HttpInterface.class);
    }

    public HttpInterface getHttpService(String baseUrl) {
        return getInstance(baseUrl).create(HttpInterface.class);
    }


    class HttpBaseParamsLoggingInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request.Builder requestBuilder = request.newBuilder();
            RequestBody formBody = new FormBody.Builder()
                    .add("channel", "wdj")
                    .add("version", "4.0.2")
                    .add("uuid", "ffffffff-a90e-706a-63f7-ccf973aae5ee")
                    .add("platform", "android")
                    .build();
            String postBodyString = bodyToString(request.body());
            postBodyString += ((postBodyString.length() > 0) ? "&" : "") + bodyToString(formBody);
            request = requestBuilder
                    .post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"),
                            postBodyString))
                    .build();
            return chain.proceed(request);
        }

        public String bodyToString(final RequestBody request) {
            try {
                final RequestBody copy = request;
                final Buffer buffer = new Buffer();
                if (copy != null)
                    copy.writeTo(buffer);
                else
                    return "";
                return buffer.readUtf8();
            } catch (final IOException e) {
                return "did not work";
            }
        }
    }
}
