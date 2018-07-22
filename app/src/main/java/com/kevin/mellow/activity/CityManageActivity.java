package com.kevin.mellow.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.kevin.mellow.MainActivity;
import com.kevin.mellow.R;
import com.kevin.mellow.adapter.CityManageAdapter;
import com.kevin.mellow.base.BaseActivity;
import com.kevin.mellow.bean.CityManageBean;
import com.kevin.mellow.database.CityDataEntity;
import com.kevin.mellow.database.CityManageEntity;
import com.kevin.mellow.database.DBManager;
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
public class CityManageActivity extends BaseActivity implements View.OnClickListener,
        CityManageAdapter.OnCityItemClickListener {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;
    private List<CityManageEntity> mData = new ArrayList<>();
    private List<CityManageEntity> mDataTemp = new ArrayList<>();
    private CityManageAdapter mAdapter;
    private DBManager dbManager;

    @Override
    public int setLayoutResId() {
        return R.layout.activity_city_manage;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        String locationCity = intent.getStringExtra("locationCity");
        actionBar.setTitle(getString(R.string.city_manage));
        ivFunction.setVisibility(View.VISIBLE);
        ivFunction.setImageResource(R.drawable.ic_add);

        ivFunction.setOnClickListener(this);
        dbManager = DBManager.getInstance();
        if (!TextUtils.isEmpty(locationCity)) {
            CityManageEntity cityManageEntity = new CityManageEntity(null, locationCity, null,
                    null, null);
            mData.add(0, cityManageEntity);
            if (!dbManager.isExistsByName(locationCity)) {
                dbManager.insertCityManage(locationCity, null, null, null);
            }
        }
        List<CityManageEntity> cityManageEntities = dbManager.retrieveAllCity();
        if (cityManageEntities != null) {
            for (int i = 0; i < cityManageEntities.size(); i++) {
                CityManageEntity cityManageEntity = cityManageEntities.get(i);

                if (cityManageEntity.getCityName().equals(locationCity)) {
                    cityManageEntities.remove(i);
                }
            }
            mData.addAll(cityManageEntities);
        }
        rvRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDivider(R.drawable.bg_divider_recycler);
        rvRecyclerView.addItemDecoration(dividerItemDecoration);
        mAdapter = new CityManageAdapter(this, mData);
        rvRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnCityItemClickListener(this);
        mAdapter.setOnCityItemDeleteListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_function:
//                startNewActivity(CitySearchActivity.class);
                Intent intent = new Intent(this, CitySearchActivity.class);
                startActivity(intent);
                break;
        }
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (RESULT_OK == resultCode) {
//            String cityLocation = data.getStringExtra("cityLocation");
//            if (dbManager.isExistsByName(cityLocation)) {
//                showToast("已添加");
//                return;
//            }
//            dbManager.insertCityManage(cityLocation, null, null, null);
//            CityManageEntity cityManageBean = new CityManageEntity();
//            cityManageBean.setCityName(cityLocation);
//            mAdapter.updateData(cityManageBean);
//        }
//    }

    @Override
    public void onCityItemClick(int position) {
//        CityManageEntity cityManageEntity = mData.get(position);
//        String cityName = cityManageEntity.getCityName();
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.putExtra("showCityName", cityName);
//        setResult(RESULT_OK, intent);
//        finish();

    }

    @Override
    public void onCityDeleteClick(int position) {
        CityManageEntity cityManageEntity = mData.get(position);
        String cityName = cityManageEntity.getCityName();
        dbManager.deleteCityManage(cityName);
        printLogd(position + "");
        mAdapter.deleteData(position);
    }
}
