package com.kevin.mellow.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.adapter.LocationAdapter;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.bean.LocationCurrentBean;
import com.kevin.mellow.bean.LocationHotBean;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.database.CityDataEntity;
import com.kevin.mellow.database.DBManager;
import com.kevin.mellow.listener.OnLocationItemClickListener;
import com.kevin.mellow.utils.CityComparator;
import com.kevin.mellow.view.DividerItemDecoration;
import com.kevin.mellow.view.IndexBar;
import com.kevin.mellow.view.SectionItemDecoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/24.
 * <h3>
 * Describe:
 * <h3/>
 */

public class LocationFragment extends BaseFragment implements IndexBar.OnIndexChangedListener,
        OnLocationItemClickListener {

    @BindView(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;
    @BindView(R.id.ib_index_bar)
    IndexBar ibIndexBar;
    @BindView(R.id.tv_overlay)
    TextView tvOverlay;

    private LocationAdapter mAdapter;
    private LocationCurrentBean locationCurrent;
    private List<LocationHotBean> locationHotData = new ArrayList<>();
    private List<CityDataEntity> cityDataEntities;
    private OnLocationActiveListener mCallback;

    public interface OnLocationActiveListener {
        void onLocationActive(String cityName);
    }

    public static LocationFragment newInstance() {
        return new LocationFragment();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnLocationActiveListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement " +
                    "OnLocationActiveListener");
        }
    }

    @Override
    public int setLayoutResId() {
        return R.layout.fragment_location;
    }

    @Override
    public void initView() {
        ibIndexBar.setOverlayText(tvOverlay);
    }

    @Override
    public void initData() {
        initCurrentLocation();
        initHotLocation();
        DBManager dbManager = DBManager.getInstance();
        cityDataEntities = dbManager.retrieveAll();
        cityDataEntities.add(0, locationCurrent);
        cityDataEntities.add(1, new LocationHotBean("", ""));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity,
                LinearLayoutManager.VERTICAL, false);
        rvRecyclerView.setLayoutManager(linearLayoutManager);
        rvRecyclerView.setHasFixedSize(true);
        rvRecyclerView.addItemDecoration(new SectionItemDecoration(mActivity, cityDataEntities,
                null), 0);
        DividerItemDecoration decor = new DividerItemDecoration(mActivity, LinearLayoutManager
                .VERTICAL);
        decor.setDivider(R.drawable.bg_divider_recycler);
        rvRecyclerView.addItemDecoration(decor, 1);
        mAdapter = new LocationAdapter(mActivity, cityDataEntities);
        mAdapter.addHotCityData(locationHotData);
        mAdapter.setLayoutManager(linearLayoutManager);
        rvRecyclerView.setAdapter(mAdapter);


    }

    private void initHotLocation() {
        locationHotData.clear();
        locationHotData.add(new LocationHotBean("北京", "北京"));
        locationHotData.add(new LocationHotBean("上海", "上海"));
        locationHotData.add(new LocationHotBean("广东", "广州"));
        locationHotData.add(new LocationHotBean("广东", "深圳"));
        locationHotData.add(new LocationHotBean("湖北", "武汉"));
        locationHotData.add(new LocationHotBean("重庆", "重庆"));
        locationHotData.add(new LocationHotBean("浙江", "杭州"));
        locationHotData.add(new LocationHotBean("四川", "成都"));
        locationHotData.add(new LocationHotBean("江苏", "南京"));
    }

    private void initCurrentLocation() {
        String stringSp = getStringSp(Constants.LOCATION_CITY);
        if (!TextUtils.isEmpty(stringSp)) {
            locationCurrent = new LocationCurrentBean("", stringSp);
        } else {
            locationCurrent = new LocationCurrentBean("", "定位失败");
        }
    }

    @Override
    public void initListener() {
        ibIndexBar.setOnIndexChangedListener(this);
        mAdapter.setOnCurrentLocationClick(this);
        mAdapter.setOnHotLocationClick(this);
        mAdapter.setOnLocationClick(this);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void onIndexChanged(String indexText, int position) {
        mAdapter.scrollToSection(indexText);
    }

    @Override
    public void onCurrentLocationClick() {
    }

    @Override
    public void onHotLocationClick(int position) {
        String city = locationHotData.get(position).getCity();
        mCallback.onLocationActive(city);
    }

    @Override
    public void onLocationClick(int position) {
        //position从2开始
        String city = cityDataEntities.get(position).getCity();
        mCallback.onLocationActive(city);
    }

}
