package com.kevin.mellow.presenter;


import android.util.Log;

import com.google.gson.Gson;
import com.kevin.mellow.base.BaseObserver;
import com.kevin.mellow.bean.TuChongDiscoverBean;
import com.kevin.mellow.bean.TuChongFeedBean;
import com.kevin.mellow.contract.TuChongRecommendContract;
import com.kevin.mellow.data.source.RequestDataSource;
import com.kevin.mellow.utils.LogK;

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
    private TuChongRecommendContract.DiscoverView discoverView;

    public TuChongRecommendPresenter(TuChongRecommendContract.View view, RequestDataSource requestDataSource) {
        this.view = view;
        this.requestDataSource = requestDataSource;
        view.setPresenter(this);
    }

    public TuChongRecommendPresenter(TuChongRecommendContract.DiscoverView view, RequestDataSource requestDataSource) {
        this.discoverView = view;
        this.requestDataSource = requestDataSource;
        view.setPresenter(this);
    }


    @Override
    public void requestData(final String type, String postId, String page) {


        Observable<Map<String, Object>> mapObservable = requestDataSource.requestTuChongRecommend(type, postId, page);
        mapObservable.subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        view.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Map<String, Object>>(view,view.getUniqueTag()) {
                    @Override
                    public void onNext(Map<String, Object> stringObjectMap) {
                        super.onNext(stringObjectMap);
                        Gson gson = new Gson();
                        String s = gson.toJson(stringObjectMap);
                        Log.d(TAG, "onNext: ");

                        TuChongFeedBean tuChongFeedBean = gson.fromJson(new Gson()
                                .toJson(stringObjectMap), TuChongFeedBean.class);
                        List<TuChongFeedBean.FeedListBean> feedList = tuChongFeedBean.getFeedList();
                        if ("refresh".equals(type)) {

                            view.refreshData(feedList);
                        } else if ("loadmore".equals(type)) {
                            if (feedList.size() == 0) {
                                view.showTips("没有更多数据了");
                            } else {

                                view.loadMoreData(feedList);
                            }
                        }
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        view.refreshFinish();
                        view.dismissProgressDialog();
                    }
                });

    }

    @Override
    public void requestDiscoverData() {
        Observable<Map<String, Object>> mapObservable = requestDataSource.requestTuDiscover();
        mapObservable.subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        discoverView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Map<String, Object>>(discoverView,discoverView.getUniqueTag()) {
                    @Override
                    public void onNext(Map<String, Object> stringObjectMap) {
                        super.onNext(stringObjectMap);
                        Gson gson = new Gson();
                        String s = gson.toJson(stringObjectMap);
                        LogK.d(TAG, "discover==>-" + s);
                        TuChongDiscoverBean tuChongDiscoverBean = gson.fromJson(new Gson()
                                .toJson(stringObjectMap), TuChongDiscoverBean.class);
                        List<TuChongDiscoverBean.BannersBean> banners = tuChongDiscoverBean.getBanners();
                        discoverView.updateBanner(banners);
                        List<TuChongDiscoverBean.HotEventsBean> hotEvents = tuChongDiscoverBean.getHotEvents();
                        discoverView.showHotEvent(hotEvents);
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        discoverView.setBannerAutoScroll();
                        discoverView.dismissProgressDialog();
                    }
                });
    }


}
