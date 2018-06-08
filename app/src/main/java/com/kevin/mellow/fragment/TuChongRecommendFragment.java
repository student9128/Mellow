package com.kevin.mellow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevin.mellow.R;
import com.kevin.mellow.activity.WebViewActivity;
import com.kevin.mellow.adapter.TuChongRecommendAdapter;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.bean.TuChongFeedBean;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.contract.TuChongRecommendContract;
import com.kevin.mellow.data.source.RequestDataSource;
import com.kevin.mellow.presenter.TuChongRecommendPresenter;
import com.kevin.mellow.view.DividerItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/3.
 * <h3>
 * Describe:
 * <h3/>
 */
public class TuChongRecommendFragment extends BaseFragment implements TuChongRecommendContract.View, OnLoadmoreListener, OnRefreshListener, TuChongRecommendAdapter.OnRecyclerItemClickListener {
    @BindView(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;
    @BindView(R.id.refresh_header)
    ClassicsHeader refreshHeader;
    @BindView(R.id.refresh_footer)
    ClassicsFooter refreshFooter;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    private TuChongRecommendContract.Presenter mPresenter;
    private TuChongRecommendAdapter mAdapter;
    private List<TuChongFeedBean.FeedListBean> data = new ArrayList<>();
    private int pageNum = 1;

    public static TuChongRecommendFragment newInstance(String s) {
        TuChongRecommendFragment fragment = new TuChongRecommendFragment();
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
        return R.layout.fragment_tu_chong_recommend;
    }

    @Override
    public void initView() {
        rvRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL_LIST);
        dividerItemDecoration.setDivider(R.drawable.bg_recycler_divider);
        rvRecyclerView.addItemDecoration(dividerItemDecoration);
        mAdapter = new TuChongRecommendAdapter(mActivity, data);
        rvRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        smartRefresh.setOnRefreshListener(this);
        smartRefresh.setOnLoadmoreListener(this);
        mAdapter.setOnAuthorViewItemClickListener(this);
        mAdapter.setOnImageClickListener(this);
    }

    @Override
    public void loadData() {
        mPresenter.requestData("refresh", "", "1");

    }

    @Override
    public void showTips(String msg) {
        showToast(msg);
    }

    @Override
    public void refreshData(List<TuChongFeedBean.FeedListBean> d) {
        Log.d(TAG, "refreshData: " + d.size());
        mAdapter.refreshData(d);
    }

    @Override
    public void loadMoreData(List<TuChongFeedBean.FeedListBean> d) {
        mAdapter.loadMoreData(d);
    }

    @Override
    public void refreshFinish() {
        if (smartRefresh != null) {

            if (smartRefresh.isRefreshing()) {
                smartRefresh.finishRefresh();
            }
            if (smartRefresh.isLoading()) {
                smartRefresh.finishLoadmore();
            }
        }
    }

    @Override
    public void setPresenter(TuChongRecommendContract.Presenter presenter) {
        mPresenter = presenter;
    }
    @Override
    public String getUniqueTag() {
        printLogi(getDisposableKey());
        return getDisposableKey();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        pageNum++;
        if (data.size() > 1) {
            TuChongFeedBean.FeedListBean feedListBean = data.get(data.size() - 1);
            int postId = feedListBean.getPost_id();
            mPresenter.requestData("loadmore", String.valueOf(postId), String.valueOf(pageNum));
        }

    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPresenter.requestData("refresh", "", "1");
    }

    @Override
    public void onAuthorViewItemClick(int position) {
//        showToast("author--" + position);
        String url = data.get(position).getSite().getUrl();
        Intent intent = new Intent(mActivity, WebViewActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    @Override
    public void onImageClick(int position) {
//        showToast("image--" + position);
        String url = data.get(position).getUrl();
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
