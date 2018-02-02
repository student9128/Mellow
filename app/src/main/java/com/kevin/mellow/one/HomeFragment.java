package com.kevin.mellow.one;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.data.source.RequestDataSource;

import java.util.List;

import butterknife.BindView;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/27.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class HomeFragment extends BaseFragment implements HomeContract.View {
    @BindView(R.id.text)
    TextView text;
    private HomeContract.Presenter mPresenter;

    public static HomeFragment newInstance(String s) {
        HomeFragment fragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS, s);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new HomePresenter(this, RequestDataSource.getInstance());
    }


    @Override
    public int setLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        Bundle bundle = getArguments();
        String s = bundle.getString(Constants.ARGS);
        text.setText(s);
    }

    @Override
    public void initData() {
        mPresenter.requestData();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void addData(List<String> data) {
        mPresenter.requestOneList(data.get(0));
    }

    @Override
    public void showTip(String msg) {
        showToast(msg);
    }
}
