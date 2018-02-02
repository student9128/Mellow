package com.kevin.mellow.one;

import android.util.Log;

import com.google.gson.Gson;
import com.kevin.mellow.data.source.RequestDataSource;

import java.util.ArrayList;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/27.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;
    private RequestDataSource requestDataSource;

    public HomePresenter(HomeContract.View view, RequestDataSource requestDataSource) {
        this.view = view;
        this.requestDataSource = requestDataSource;
        view.setPresenter(this);
    }


    @Override
    public void requestData() {

        Call<Map<String, Object>> call = requestDataSource.requestTouTiao();
        call.enqueue(new Callback<Map<String, Object>>() {
            private ArrayList<String> data;

            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {
                    Map<String, Object> body = response.body();
                    Log.d("TAG", "body===" + body);
//                    Gson gson = new Gson();
//                    String s = gson.toJson(body);
//                    Log.d("TAG", "s===" + body);
//                    Iterator<Map.Entry<String, Object>> iterator = body.entrySet().iterator();
//                    while (iterator.hasNext()) {
//                        Map.Entry<String, Object> next = iterator.next();
//                        Log.d("TAG", "key===" + next.getKey());
//                        Log.d("TAG", "value===" + next.getValue());
//                        data = (ArrayList<String>) body.get("data");
//                    }
//                    view.loadMoreData(data);
//                    Log.d("DATA", "onResponse: " + data.size());
//                    for (String x : data) {
//                        Log.d("XXX", "onResponse: " + x);
//                    }
                } else {
                    int code = response.code();
                    Log.d("code", "code: " + code);
                    ResponseBody responseBody = response.errorBody();
                    String message = response.message();
                    Log.d("code", "message: " + message);
                    view.showTip("Error::" + code + "\t" + message);
                }

            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                view.showTip("Request failed:: " + t.getMessage());
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
        });
    }

    @Override
    public void requestOneList(String data) {
        Call<Map<String, Object>> call = requestDataSource.requestOnList(data);
        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {

                    Map<String, Object> body = response.body();
                    Gson gson = new Gson();
                    String s = gson.toJson(body);
                } else {
                    int code = response.code();
                    Log.d("code", "code: " + code);
                    ResponseBody responseBody = response.errorBody();
                    String message = response.message();
                    Log.d("code", "message: " + message);
                    view.showTip("Error::" + code + "\t" + message);
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                view.showTip("Request failed:: " + t.getMessage());
            }
        });
    }
}
