package com.kevin.mellow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.kevin.mellow.R;
import com.kevin.mellow.activity.WebViewActivity;
import com.kevin.mellow.adapter.TuChongDiscoverBannerAdapter;
import com.kevin.mellow.adapter.TuChongDiscoverHotEventAdapter;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.bean.TuChongDiscoverBean;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.contract.TuChongRecommendContract;
import com.kevin.mellow.data.source.RequestDataSource;
import com.kevin.mellow.presenter.TuChongRecommendPresenter;
import com.kevin.mellow.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/3.
 * <h3>
 * Describe:
 * <h3/>
 */
public class TuChongDiscoverFragment extends BaseFragment implements TuChongRecommendContract.DiscoverView, TuChongDiscoverHotEventAdapter.OnRecyclerItemClickListener {
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;
    private TuChongRecommendContract.Presenter mPresenter;
    private TuChongDiscoverBannerAdapter mAdapter;
    private List<TuChongDiscoverBean.BannersBean> bannerData = new ArrayList<>();
    private static final int UPDATE_VIEWPAGER = 100;
    private boolean isLoop = true;
    private Timer mTimer = new Timer();
    /**
     * 第一次进来设置一个index，切换的时候就设置后面的index
     */
    private boolean isFirst = true;
    private TuChongDiscoverHotEventAdapter mHotEventAdapter;
    private List<TuChongDiscoverBean.HotEventsBean> hotEventData = new ArrayList<>();

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
        mTimer = new Timer();
        isLoop = true;
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity,
                LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rvRecyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL_LIST);
        dividerItemDecoration.setDivider(R.drawable.bg_recycler_divider);
        rvRecyclerView.addItemDecoration(dividerItemDecoration);
        mHotEventAdapter = new TuChongDiscoverHotEventAdapter(mActivity, hotEventData);
        rvRecyclerView.setAdapter(mHotEventAdapter);
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
        mHotEventAdapter.setOnImageClickListener(this);
        mHotEventAdapter.setOnTopicViewItemClickListener(this);
    }

    /**
     * 在onStart()时候切换
     * onCrateView时候请求数据，快速切换fragment的时候，updateBanner里的viewpager会报空指针
     */
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
//            printLogd("0000000000isFirst  " + isFirst);
            //这里不能设置viewpage的item，来回切换后发生轮播速度越来越快的情况
//            if (isFirst) {
//                if (viewPager != null) {
//                    viewPager.setCurrentItem(50000 * (d.size()));
//                }
//            } else {
//                if (viewPager != null) {
//                    printLogd("``~~~~~~~~~~`" + viewPager.getCurrentItem());
//                    viewPager.setCurrentItem(viewPager.getCurrentItem(),true);
//                }
//            }
        }
    }

    @Override
    public void setBannerAutoScroll() {
        setAutoScroll();
    }

    @Override
    public void showHotEvent(List<TuChongDiscoverBean.HotEventsBean> d) {
        if (d.size() > 0) {
            mHotEventAdapter.updateData(d);
        }
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
                    if (viewPager != null) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                    }
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
        }, 5000, 5000);//这里定义了轮播图切换的间隔时间
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //取消，然后重建，不然的话，timer一直再运行，下次回来会有好多任务在运行
        mTimer.cancel();//每次都要创建Timer出现轮播图从第一张跳到其他张的问题，因为index是停止前的
        //界面不显示了就不循环了，这样可以解决viewpager报空指针的问题
        isLoop = false;
    }

    @Override
    public void onTopicViewItemClick(int position) {
        String url = hotEventData.get(position).getUrl();
        Intent intent = new Intent(mActivity, WebViewActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    @Override
    public void onImageClick(int position) {
        String url = hotEventData.get(position).getIntroduction_url();
        Intent intent = new Intent(mActivity, WebViewActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    @Override
    public void showProgressDialog() {
        showLoadingDialog();
    }

    @Override
    public void dismissProgressDialog() {
        dismissLoadingDialog();
    }
}
