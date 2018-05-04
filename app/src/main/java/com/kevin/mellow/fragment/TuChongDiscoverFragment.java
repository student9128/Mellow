package com.kevin.mellow.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;

import com.kevin.mellow.R;
import com.kevin.mellow.adapter.TuChongDiscoverBannerAdapter;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.bean.TuChongDiscoverBean;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.contract.TuChongRecommendContract;
import com.kevin.mellow.data.source.RequestDataSource;
import com.kevin.mellow.presenter.TuChongRecommendPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/3.
 * <h3>
 * Describe:
 * <h3/>
 */
public class TuChongDiscoverFragment extends BaseFragment implements TuChongRecommendContract.DiscoverView {
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    Unbinder unbinder;
    private TuChongRecommendContract.Presenter mPresenter;
    private TuChongDiscoverBannerAdapter mAdapter;
    private List<TuChongDiscoverBean.BannersBean> bannerData = new ArrayList<>();
    private static final int UPDATE_VIEWPAGER = 100;
    private boolean isLoop = true;
    private Timer mTimer = new Timer();
    public static TuChongDiscoverFragment newInstance(String s) {
        TuChongDiscoverFragment fragment = new TuChongDiscoverFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS, s);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new TuChongRecommendPresenter(this, RequestDataSource.getInstance());
    }

    @Override
    public int setLayoutResId() {
        return R.layout.fragment_tu_chong_discover;
    }

    @Override
    public void initView() {
        mAdapter = new TuChongDiscoverBannerAdapter(mActivity, bannerData);
        viewPager.setAdapter(mAdapter);
    }



    @Override
    public void initData() {


    }



    @Override
    public void initListener() {
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        isLoop = false;
                        break;
                    case MotionEvent.ACTION_UP:
                        isLoop = true;
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void loadData() {
        mPresenter.requestDiscoverData();

    }

    @Override
    public void showTips(String msg) {

    }

    @Override
    public void updateBanner(List<TuChongDiscoverBean.BannersBean> d) {
        if (d.size() > 0) {
            mAdapter.updateBanner(d);
            viewPager.setCurrentItem(50000 * (d.size()));
        }
    }

    @Override
    public void setBannerAutoScroll() {
        setAutoScroll();
    }

    @Override
    public void setPresenter(TuChongRecommendContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case UPDATE_VIEWPAGER:
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                    break;
            }
        }
    };


    private void setAutoScroll() {
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = UPDATE_VIEWPAGER;
                if (isLoop) {
                    handler.sendMessage(message);
                }
            }
        }, 5000, 2000);//这里定义了轮播图切换的间隔时间
    }

}
