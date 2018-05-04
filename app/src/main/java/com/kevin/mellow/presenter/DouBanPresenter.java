package com.kevin.mellow.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.kevin.mellow.base.BaseObserver;
import com.kevin.mellow.bean.DouBanMovieBean;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.contract.DouBanContract;
import com.kevin.mellow.data.source.RequestDataSource;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/3.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class DouBanPresenter implements DouBanContract.Presenter {
    private DouBanContract.View view;
    private RequestDataSource requestDataSource;

    public DouBanPresenter(DouBanContract.View view, RequestDataSource requestDataSource) {
        this.view = view;
        this.requestDataSource = requestDataSource;
        this.view.setPresenter(this);
    }

    @Override
    public void requestData(String cityName, String page, final String type) {

        Observable<DouBanMovieBean> observable2 = requestDataSource.requestDouBan(cityName, page);
        observable2.subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        view.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<DouBanMovieBean>(view) {
                    @Override
                    public void onNext(DouBanMovieBean douBanMovieBean) {
                        String s = new Gson().toJson(douBanMovieBean);
//                        Gson gson = new Gson();
//                        DouBanMovieBean douBanMovieBean = gson.fromJson(s, DouBanMovieBean.class);
                        Log.d("TAG", "" + s);
                        List<DouBanMovieBean.SubjectsBean> subjects = douBanMovieBean.getSubjects();
                        if (type.equals(Constants.TYPE_REFRESH)) {
                            if (subjects.size() == 0) {
                                view.showTips("暂无数据");
                            } else {
                                view.refreshData(subjects);
                            }
                        } else if (type.equals(Constants.TYPE_LOAD_MORE)) {
                            if (subjects.size() == 0) {
                                view.showTips("没有更多数据了");
                            } else {
                                view.loadMoreData(subjects);
                            }
                        }
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        view.refreshFinish();
                    }
                });

    }

}
