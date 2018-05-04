package com.kevin.mellow.one;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.adapter.ChineseWeekAdapter;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.bean.ChineseWeekBean;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.data.source.RequestDataSource;
import com.kevin.mellow.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/27.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class ChineseWeekFragment extends BaseFragment implements ChineseContract.View {

    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.rv_recycler_view)
    RecyclerView mRecyclerView;
    private ChineseContract.Presenter mPresenter;
    private boolean isViewCreated = false;
    private boolean isUIVisible = false;
    private List<ChineseWeekBean> data = new ArrayList<>();
    private ChineseWeekAdapter mAdapter;

    public static ChineseWeekFragment newInstance(String s) {
        ChineseWeekFragment fragment = new ChineseWeekFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS, s);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        printLogd("执行了吗？");
        mPresenter = new ChineseWeekPresenter(this, RequestDataSource.getInstance());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isUIVisible = true;
            lazyLoad();
        } else {
            isUIVisible = false;
        }
    }

    @Override
    public int setLayoutResId() {
        return R.layout.fragment_chinese_week;
    }

    @Override
    public void initView() {
        Bundle bundle = getArguments();
        String s = bundle.getString(Constants.ARGS);
        text.setText(s);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL_LIST);
//        dividerItemDecoration.setDivider();
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mAdapter = new ChineseWeekAdapter(mActivity, data);
    }

    @Override
    public void initData() {
    }


    @Override
    public void initListener() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public void setPresenter(ChineseContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showTip(String msg) {
        showToast(msg);
    }

    @Override
    public void updateData(List<ChineseWeekBean> d) {
        mAdapter.updateData(d);
    }

    private void lazyLoad() {
        if (isViewCreated && isUIVisible) {
//            mPresenter.requestData();
            isUIVisible = false;
            isViewCreated = false;
        }
    }

}
