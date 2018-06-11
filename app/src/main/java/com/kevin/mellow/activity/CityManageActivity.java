package com.kevin.mellow.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.adapter.CityManageAdapter;
import com.kevin.mellow.base.BaseActivity;
import com.kevin.mellow.bean.CityManageBean;
import com.kevin.mellow.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/6/11.
 * <h3>
 * Describe:
 * <h3/>
 */
public class CityManageActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;
    private List<CityManageBean> mData = new ArrayList<>();
    private List<CityManageBean> mDataTemp = new ArrayList<>();
    private CityManageAdapter mAdapter;

    @Override
    public int setLayoutResId() {
        return R.layout.activity_city_manage;
    }

    @Override
    public void initView() {
        actionBar.setTitle(getString(R.string.city_manage));
        ivFunction.setVisibility(View.VISIBLE);
        ivFunction.setImageResource(R.drawable.ic_add);

        ivFunction.setOnClickListener(this);

        rvRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDivider(R.drawable.bg_divider_recycler);
        rvRecyclerView.addItemDecoration(dividerItemDecoration);
        mAdapter = new CityManageAdapter(this, mData);
        rvRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_function:
//                startNewActivity(CitySearchActivity.class);
                Intent intent = new Intent(this, CitySearchActivity.class);
                startActivityForResult(intent, 0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (RESULT_OK == resultCode) {
            String cityLocation = data.getStringExtra("cityLocation");
            CityManageBean cityManageBean = new CityManageBean();
            cityManageBean.setCityName(cityLocation);
            mDataTemp.add(cityManageBean);
            mAdapter.updateData(mDataTemp);

        }
    }
}
