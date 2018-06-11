package com.kevin.mellow.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.adapter.CitySearchAdapter;
import com.kevin.mellow.base.BaseActivity;
import com.kevin.mellow.bean.CitySearchBean;
import com.kevin.mellow.contract.CitySearchContract;
import com.kevin.mellow.data.source.RequestDataSource;
import com.kevin.mellow.listener.OnRecyclerItemClickListener;
import com.kevin.mellow.presenter.CitySearchPresenter;
import com.kevin.mellow.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/6/10.
 * <h3>
 * Describe:
 * 天气预报中进行城市搜索的页面
 * <h3/>
 */
public class CitySearchActivity extends BaseActivity implements CitySearchContract.View,
        TextWatcher, OnRecyclerItemClickListener {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_city_name)
    EditText etCityName;
    @BindView(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;
    @BindView(R.id.tv_result_tips)
    TextView tvResultTips;
    private CitySearchContract.Presenter mPresenter;
    private List<CitySearchBean.HeWeather6Bean.BasicBean> mData = new ArrayList<>();
    private CitySearchAdapter mAdapter;

    @Override
    public int setLayoutResId() {
        return R.layout.activity_city_search;
    }

    @Override
    public void initView() {
        mPresenter = new CitySearchPresenter(this, RequestDataSource.getInstance());
        Drawable drawable = getResources().getDrawable(R.drawable.ic_search);
        drawable.setBounds(0, 0, 60, 60);
        etCityName.setCompoundDrawables(drawable, null, null, null);
        etCityName.addTextChangedListener(this);
        mAdapter = new CitySearchAdapter(this, mData);
        rvRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDivider(R.drawable.bg_divider_recycler);
        rvRecyclerView.addItemDecoration(dividerItemDecoration);
        rvRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnRecyclerItemClickListener(this);
    }

    @Override
    public void showTips(String msg) {
        showToast(msg);
    }

    @Override
    public void showStatus(String status) {
        if (!"ok".equals(status)) {
            showToast(status);
            rvRecyclerView.setVisibility(View.GONE);
            tvResultTips.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void showData(List<CitySearchBean.HeWeather6Bean.BasicBean> d) {
        if (d != null && d.size() > 0) {
            mAdapter.updateData(d);
            rvRecyclerView.setVisibility(View.VISIBLE);
            tvResultTips.setVisibility(View.GONE);
        } else {
            tvResultTips.setVisibility(View.VISIBLE);
            rvRecyclerView.setVisibility(View.GONE);
        }
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }

    @Override
    public void showError(int resId) {

    }

    @Override
    public void setPresenter(CitySearchContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public String getUniqueTag() {
        return getDisposableKey();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!TextUtils.isEmpty(s)) {
            mPresenter.requestData(s.toString());
        } else {
            mAdapter.clearData();
            rvRecyclerView.setVisibility(View.VISIBLE);
            tvResultTips.setVisibility(View.GONE);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }


    @Override
    public void onRecyclerItemClick(int position) {
        CitySearchBean.HeWeather6Bean.BasicBean basicBean = mData.get(position);
        String location = basicBean.getLocation();
        Intent intent = new Intent(this, CityManageActivity.class);
        intent.putExtra("cityLocation", location);
        setResult(RESULT_OK, intent);
        finish();
    }
}
