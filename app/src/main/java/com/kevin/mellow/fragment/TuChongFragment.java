package com.kevin.mellow.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.kevin.mellow.R;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.contract.TuChongContract;
import com.kevin.mellow.contract.TuChongRecommendContract;
import com.kevin.mellow.data.source.RequestDataSource;
import com.kevin.mellow.presenter.TuChongPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/21.
 * <h3>Description:</h3>
 * <div>
 * <div/>
 */


public class TuChongFragment extends BaseFragment implements BottomNavigationBar.OnTabSelectedListener {
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    Unbinder unbinder;
    private TuChongContract.Presenter mPresenter;
    private TuChongRecommendFragment mRecommendFragment;
    private TuChongDiscoverFragment mDiscoverFragment;

    public static TuChongFragment newInstance(String s) {
        TuChongFragment fragment = new TuChongFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS, s);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mPresenter = new TuChongPresenter(this, RequestDataSource.getInstance());
    }

    @Override
    public int setLayoutResId() {
        return R.layout.fragment_tu_chong;
    }

    @Override
    public void initView() {
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_tu_chong_recommend, R.string.tu_chong_recommend).setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_tu_chong_discover, R.string.tu_chong_discover).setActiveColorResource(R.color.colorPrimary))
                .setFirstSelectedPosition(0)
                .initialise();
        if (mRecommendFragment == null) {
            mRecommendFragment = TuChongRecommendFragment.newInstance(getString(R.string.tu_chong_recommend));
        }
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fl_content, mRecommendFragment)
                .commit();
    }

    @Override
    public void initData() {
//        mPresenter.requestData("refresh", "", "1", true);
//        mPresenter.requestData("refresh","20180503");
    }

    @Override
    public void initListener() {
        bottomNavigationBar.setTabSelectedListener(this);
    }

    @Override
    public void loadData() {

    }

//    @Override
//    public void setPresenter(TuChongContract.Presenter presenter) {
//        mPresenter = presenter;
//    }
//
//    @Override
//    public void showTips(String msg) {
//        showToast(msg);
//    }


    @Override
    public void onTabSelected(int position) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                if (mRecommendFragment == null) {
                    mRecommendFragment = TuChongRecommendFragment.newInstance(getString(R.string.tu_chong_recommend));
                }
                transaction.replace(R.id.fl_content, mRecommendFragment);
                break;
            case 1:
                if (mDiscoverFragment == null) {
                    mDiscoverFragment = TuChongDiscoverFragment.newInstance(getString(R.string.tu_chong_discover));
                }
                transaction.replace(R.id.fl_content, mDiscoverFragment);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
