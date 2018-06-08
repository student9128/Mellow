package com.kevin.mellow.presenter;


import android.util.Log;

import com.google.gson.Gson;
import com.kevin.mellow.base.BaseObserver;
import com.kevin.mellow.contract.TuChongContract;
import com.kevin.mellow.data.source.RequestDataSource;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/3.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class TuChongPresenter implements TuChongContract.Presenter {
    private TuChongContract.View view;
    private RequestDataSource requestDataSource;
    public String TAG = getClass().getSimpleName();
    public TuChongPresenter(TuChongContract.View view, RequestDataSource requestDataSource) {
        this.view = view;
        this.requestDataSource = requestDataSource;
        view.setPresenter(this);
    }


    @Override
    public void requestData(String type,String postId,String page,boolean isFirst) {


        Observable<Map<String, Object>> mapObservable = requestDataSource.requestTuChongRecommend(type,postId,page);
        mapObservable.subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Map<String,Object>>(view,view.getUniqueTag()) {
                    @Override
                    public void onNext(Map<String, Object> stringObjectMap) {
                        super.onNext(stringObjectMap);
                        Gson gson = new Gson();
                        String s = gson.toJson(stringObjectMap);
                        Log.d(TAG, "onNext: ");
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }
                });
        
    }




}
