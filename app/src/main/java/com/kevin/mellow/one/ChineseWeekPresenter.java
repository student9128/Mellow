package com.kevin.mellow.one;

import android.util.Log;

import com.google.gson.Gson;
import com.kevin.mellow.bean.ChineseWeekBean;
import com.kevin.mellow.data.source.RequestDataSource;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/28.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class ChineseWeekPresenter implements ChineseContract.Presenter {
    private ChineseContract.View view;
    private RequestDataSource requestDataSource;

    public ChineseWeekPresenter(ChineseContract.View view, RequestDataSource requestDataSource) {
        this.view = view;
        this.requestDataSource = requestDataSource;
        view.setPresenter(this);
    }

    @Override
    public void requestData() {
        Call<Map<String, Object>> call = requestDataSource.requestItemList();
        call.enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful()) {
                    Map<String, Object> body = response.body();
                    Gson gson = new Gson();
                    String s = gson.toJson(body);
                    Log.d("TAG", "s===" + body);
                    Gson gson1 = new Gson();
                    ChineseWeekBean chineseWeekBean = gson.fromJson(s, ChineseWeekBean.class);
//                    view.refreshData();
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
                view.showTip("RequestFailed:: " + t.getMessage());
            }
        });
        call.cancel();
    }
}
