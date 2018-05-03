package com.kevin.mellow.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevin.mellow.R;
import com.kevin.mellow.adapter.TuChongRecommendAdapter;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.bean.TuChongFeedBean;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.contract.TuChongRecommendContract;
import com.kevin.mellow.data.source.RequestDataSource;
import com.kevin.mellow.presenter.TuChongRecommendPresenter;
import com.kevin.mellow.view.DividerItemDecoration;

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
public class TuChongRecommendFragment extends BaseFragment implements TuChongRecommendContract.View {
    @BindView(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;
    Unbinder unbinder;
    private TuChongRecommendContract.Presenter mPresenter;
    private TuChongRecommendAdapter mAdapter;
    private List<TuChongFeedBean.FeedListBean> data = new ArrayList<>();

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
        mPresenter.requestData("refresh", "", "1");

    }

    @Override
    public void initListener() {

    }

    @Override
    public void showTips(String msg) {
        showToast(msg);
    }

    @Override
    public void refreshData(List<TuChongFeedBean.FeedListBean> d) {
        Log.d(TAG, "refreshData: "+d.size());
        mAdapter.refreshData(d);
//        data.addAll(d);
//        mAdapter = new TuChongRecommendAdapter(mActivity, data);
//        rvRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void loadMoreData(List<TuChongFeedBean.FeedListBean> d) {
        mAdapter.loadMoreData(d);
    }

    @Override
    public void refreshFinish() {

    }

    @Override
    public void setPresenter(TuChongRecommendContract.Presenter presenter) {
        mPresenter = presenter;
    }


}
