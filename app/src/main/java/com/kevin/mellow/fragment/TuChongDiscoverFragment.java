package com.kevin.mellow.fragment;

import android.os.Bundle;

import com.kevin.mellow.R;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.bean.TuChongFeedBean;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.contract.TuChongRecommendContract;
import com.kevin.mellow.data.source.RequestDataSource;
import com.kevin.mellow.presenter.TuChongRecommendPresenter;

import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/3.
 * <h3>
 * Describe:
 * <h3/>
 */
public class TuChongDiscoverFragment extends BaseFragment implements TuChongRecommendContract.View{
    private TuChongRecommendContract.Presenter mPresenter;
    public static TuChongDiscoverFragment newInstance(String s) {
        TuChongDiscoverFragment fragment = new TuChongDiscoverFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS, s);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public int setLayoutResId() {
        return R.layout.fragment_tu_chong_recommend;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void showTips(String msg) {

    }

    @Override
    public void refreshData(List<TuChongFeedBean.FeedListBean> data) {

    }

    @Override
    public void loadMoreData(List<TuChongFeedBean.FeedListBean> data) {

    }

    @Override
    public void refreshFinish() {

    }

    @Override
    public void setPresenter(TuChongRecommendContract.Presenter presenter) {
        mPresenter = new TuChongRecommendPresenter(this, RequestDataSource.getInstance());
    }
}
