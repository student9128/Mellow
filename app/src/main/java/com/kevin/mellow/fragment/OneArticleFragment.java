package com.kevin.mellow.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kevin.mellow.R;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.data.source.RequestDataSource;
import com.kevin.mellow.onearticle.OneArticleContract;
import com.kevin.mellow.onearticle.OneArticlePresenter;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/21.
 * <h3>Description:</h3>
 * <div>
 * <div/>
 */


public class OneArticleFragment extends BaseFragment implements OneArticleContract.View {
    private OneArticleContract.Presenter mPresenter;

    public static OneArticleFragment newInstance(String s) {
        OneArticleFragment fragment = new OneArticleFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS, s);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new OneArticlePresenter(this, RequestDataSource.getInstance());
    }

    @Override
    public int setLayoutResId() {
        return R.layout.fragment_one_article;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        mPresenter.requestData("day", "20171228");
    }

    @Override
    public void initListener() {

    }

    @Override
    public void setPresenter(OneArticleContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showTips(String msg) {
        showToast(msg);
    }
}
