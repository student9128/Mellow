package com.kevin.mellow.presenter;


import android.util.Log;

import com.google.gson.Gson;
import com.kevin.mellow.base.BaseObserver;
import com.kevin.mellow.bean.TuChongFeedBean;
import com.kevin.mellow.contract.TuChongContract;
import com.kevin.mellow.contract.TuChongRecommendContract;
import com.kevin.mellow.data.source.RequestDataSource;

import java.util.List;
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


public class TuChongRecommendPresenter implements TuChongRecommendContract.Presenter {
    private TuChongRecommendContract.View view;
    private RequestDataSource requestDataSource;
    public String TAG = getClass().getSimpleName();

    public TuChongRecommendPresenter(TuChongRecommendContract.View view, RequestDataSource requestDataSource) {
        this.view = view;
        this.requestDataSource = requestDataSource;
        view.setPresenter(this);
    }


    @Override
    public void requestData(String type, String postId, String page) {


        Observable<Map<String, Object>> mapObservable = requestDataSource.requestX(type, postId, page);
        mapObservable.subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {

                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Map<String, Object>>() {
                    @Override
                    public void onNext(Map<String, Object> stringObjectMap) {
                        super.onNext(stringObjectMap);
                        Gson gson = new Gson();
                        String s = gson.toJson(stringObjectMap);
                        Log.d(TAG, "onNext: ");

                        TuChongFeedBean tuChongFeedBean = gson.fromJson(new Gson()
                                .toJson(stringObjectMap), TuChongFeedBean.class);
                        List<TuChongFeedBean.FeedListBean> feedList = tuChongFeedBean.getFeedList();
                        view.refreshData(feedList);

                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }
                });

    }


}
