package com.kevin.mellow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.kevin.mellow.R;
import com.kevin.mellow.activity.DouBanMovieDetailActivity;
import com.kevin.mellow.adapter.DouBanMovieAdapter;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.bean.DouBanMovieBean;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.contract.DouBanContract;
import com.kevin.mellow.data.source.RequestDataSource;
import com.kevin.mellow.presenter.DouBanPresenter;
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
import butterknife.Unbinder;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/3.
 * <h3>Description:</h3>
 * <div>
 * <div/>
 */


public class DouBanFragment extends BaseFragment implements DouBanContract.View, OnRefreshListener, OnLoadmoreListener, DouBanMovieAdapter.OnRecyclerItemClickListener {
    @BindView(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;
    @BindView(R.id.smart_refresh)
    SmartRefreshLayout smartRefresh;
    @BindView(R.id.refresh_header)
    ClassicsHeader refreshHeader;
    @BindView(R.id.refresh_footer)
    ClassicsFooter refreshFooter;
    Unbinder unbinder;
    private DouBanContract.Presenter mPresenter;
    private int pageNum = 0;
    private DouBanMovieAdapter mAdapter;
    private List<DouBanMovieBean.SubjectsBean> data = new ArrayList<>();

    public static DouBanFragment newInstance(String s) {
        DouBanFragment fragment = new DouBanFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS, s);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new DouBanPresenter(this, RequestDataSource.getInstance());
    }

    @Override
    public int setLayoutResId() {
        return R.layout.fragment_dou_ban;
    }

    @Override
    public void initView() {
        rvRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL_LIST);
        dividerItemDecoration.setDivider(R.drawable.bg_recycler_divider);
        rvRecyclerView.addItemDecoration(dividerItemDecoration);
        mAdapter = new DouBanMovieAdapter(mActivity, data);
        rvRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void initData() {
    }

    @Override
    public void initListener() {
        smartRefresh.setOnRefreshListener(this);
        smartRefresh.setOnLoadmoreListener(this);
        mAdapter.setOnRecyclerViewItemClickListener(this);
    }

    @Override
    public void loadData() {
        mPresenter.requestData("上海", String.valueOf(pageNum), Constants.TYPE_REFRESH);

    }


    @Override
    public void showTips(String msg) {
        showToast(msg);
    }

    @Override
    public void showProgressDialog() {
        showLoadingDialog();
    }

    @Override
    public void dismissProgressDialog() {
        dismissLoadingDialog();
    }

    @Override
    public void refreshFinish() {
        if (smartRefresh.isRefreshing()) {
            smartRefresh.finishRefresh();
        }
        if (smartRefresh.isLoading()) {
            smartRefresh.finishLoadmore();
        }
    }

    @Override
    public void loadMoreData(List<DouBanMovieBean.SubjectsBean> d) {
        Log.d(TAG, "loadMoreData: " + d.size());
        mAdapter.loadMoreData(d);

    }

    @Override
    public void refreshData(List<DouBanMovieBean.SubjectsBean> d) {
        mAdapter.refreshData(d);
    }

    @Override
    public void setPresenter(DouBanContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPresenter.requestData("上海", "0", Constants.TYPE_REFRESH);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        pageNum++;
        mPresenter.requestData("上海", String.valueOf(pageNum), Constants.TYPE_LOAD_MORE);
    }

    @Override
    public void onRecyclerViewItemClick(int position) {
        String id = data.get(position).getId();
        String title = data.get(position).getTitle();
        printLogd(id);
        Intent intent = new Intent(mActivity, DouBanMovieDetailActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}
