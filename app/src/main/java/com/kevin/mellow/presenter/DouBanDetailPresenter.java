package com.kevin.mellow.presenter;

import com.google.gson.Gson;
import com.kevin.mellow.base.BaseObserver;
import com.kevin.mellow.bean.DouBanMovieDetailBean;
import com.kevin.mellow.bean.DouBanMoviePhotoBean;
import com.kevin.mellow.bean.DouBanMovieReviewBean;
import com.kevin.mellow.contract.DouBanDetailContract;
import com.kevin.mellow.data.source.RequestDataSource;
import com.kevin.mellow.utils.LogK;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/16.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class DouBanDetailPresenter implements DouBanDetailContract.Presenter {
    private DouBanDetailContract.View view;
    private RequestDataSource requestDataSource;

    public DouBanDetailPresenter(DouBanDetailContract.View view,
                                 RequestDataSource requestDataSource) {
        this.view = view;
        this.requestDataSource = requestDataSource;
        this.view.setPresenter(this);
    }

    @Override
    public void requestData(String cityName, String id) {
        Observable<Map<String, Object>> observable = requestDataSource.requestDouBanMovieDetail(cityName, id);
        observable.subscribeOn(Schedulers.io())
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
                        LogK.d("DouBanDetailPresenter======", s);
                        DouBanMovieDetailBean douBanMovieDetailBean = new Gson().fromJson(s, DouBanMovieDetailBean.class);
                        String title = douBanMovieDetailBean.getTitle();
                        view.showData(douBanMovieDetailBean);

                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        view.dismissProgressDialog();
                    }
                });
    }

    @Override
    public void requestDataPhotos(String cityName, String id) {
        Observable<Map<String, Object>> observable = requestDataSource.requestDouBanMoviePhotos(cityName, id);
        observable.subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        view.showProgressDialog();
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
                        LogK.d("DouBanDetailPresenter===Photos===", s);
                        DouBanMoviePhotoBean douBanMoviePhotoBean = new Gson().fromJson(s, DouBanMoviePhotoBean.class);
                        DouBanMoviePhotoBean.SubjectBean subject = douBanMoviePhotoBean.getSubject();
//                        DouBanMovieDetailBean douBanMovieDetailBean = new Gson().fromJson(s, DouBanMovieDetailBean.class);
//                        String title = douBanMovieDetailBean.getTitle();
//                        view.showData(douBanMovieDetailBean);
                        view.showPhotos(douBanMoviePhotoBean);

                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        view.dismissProgressDialog();
                    }
                });
    }

    @Override
    public void requestDataReviews(String cityName, String id) {
        Observable<Map<String, Object>> observable = requestDataSource.requestDouBanMovieReviews(cityName, id);
        observable.subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        view.showProgressDialog();
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
                        LogK.d("DouBanDetailPresenter==Reviews====", s);
                        DouBanMovieReviewBean douBanMovieReviewBean = new Gson().fromJson(s, DouBanMovieReviewBean.class);
                        view.showReviews(douBanMovieReviewBean);
//

                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                        view.dismissProgressDialog();
                    }
                });
    }
}
