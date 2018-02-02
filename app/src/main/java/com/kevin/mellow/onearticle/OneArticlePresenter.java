package com.kevin.mellow.onearticle;

import android.util.Log;

import com.kevin.mellow.data.source.RequestDataSource;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/29.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class OneArticlePresenter implements OneArticleContract.Presenter {
    private OneArticleContract.View view;
    private RequestDataSource requestDataSource;

    public OneArticlePresenter(OneArticleContract.View view, RequestDataSource requestDataSource) {
        this.view = view;
        this.requestDataSource = requestDataSource;
        view.setPresenter(this);
    }

    @Override
    public void requestData(String type, String date) {
        Call<Map<String, Object>> call = requestDataSource.requestArticle(type, date);
        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {
                    Map<String, Object> body = response.body();
                    Log.d("TAG", "body===" + body);
                } else {
                    int code = response.code();
                    Log.d("code", "code: " + code);
                    ResponseBody responseBody = response.errorBody();
                    String message = response.message();
                    Log.d("code", "message: " + message);
                    view.showTips("Error::" + code + "\t" + message);
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                view.showTips("Request failed:: " + t.getMessage());
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });
    }
}
