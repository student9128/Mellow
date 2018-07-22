package com.kevin.mellow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.kevin.mellow.R;
import com.kevin.mellow.activity.CityManageActivity;
import com.kevin.mellow.adapter.WeatherAdapter;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.contract.WeatherContract;
import com.kevin.mellow.data.source.RequestDataSource;
import com.kevin.mellow.database.CityManageEntity;
import com.kevin.mellow.database.DBManager;
import com.kevin.mellow.presenter.WeatherPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static android.app.Activity.RESULT_OK;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/21.
 * <h3>Description:</h3>
 * <div>
 * <div/>
 */


public class WeatherFragment extends BaseFragment {

    @BindView(R.id.vp_view_pager)
    ViewPager vpViewPager;

    private WeatherAdapter mAdapter;
    private List<Fragment> mFragments = new ArrayList<>();

    private DBManager dbManager;
    private String currentCity;
    /**
     * 用来存在显示天气预报的城市名称集合
     */
    private List<String> weatherCityList = new ArrayList<>();
    private List<Fragment> fragmentData = new ArrayList<>();
    private List<String> cityListTemp = new ArrayList<>();

    public static WeatherFragment newInstance(String s) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS, s);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public int setLayoutResId() {
        return R.layout.fragment_weather;
    }

    @Override
    public void initView() {
        dbManager = DBManager.getInstance();
        initFragments();
        mAdapter = new WeatherAdapter(getChildFragmentManager(), fragmentData);
        vpViewPager.setAdapter(mAdapter);
        vpViewPager.setCurrentItem(0);
        vpViewPager.setOffscreenPageLimit(10);
    }

    private void initFragments() {
        currentCity = getStringSp(Constants.LOCATION_DISTRICT);
        if (!TextUtils.isEmpty(currentCity)) {
            mFragments.add(WeatherAreaFragment.newInstance(currentCity));
            weatherCityList.add(currentCity);
//            mFragments.add(WeatherAreaFragment.newInstance("北京"));
        }
        List<CityManageEntity> cityManageEntities = dbManager.retrieveAllCity();
        if (cityManageEntities != null) {
            for (int i = 0; i < cityManageEntities.size(); i++) {
                CityManageEntity cityManageEntity = cityManageEntities.get(i);
                String cityName = cityManageEntity.getCityName();
                if (!weatherCityList.contains(cityName)) {
                    weatherCityList.add(cityName);
                }
            }
        }
        for (int j = 0; j < weatherCityList.size(); j++) {
            if (!weatherCityList.get(j).contains(currentCity)) {
                mFragments.add(WeatherAreaFragment.newInstance(weatherCityList.get(j)));
            }
        }
        fragmentData.addAll(mFragments);
//        mAdapter.upDateFragment(mFragments);
    }

    @Override
    public void onResume() {
        super.onResume();
        mFragments.clear();
        cityListTemp.clear();
        List<CityManageEntity> cityManageEntities = dbManager.retrieveAllCity();
        if (cityManageEntities != null) {
            for (int i = 0; i < cityManageEntities.size(); i++) {
                CityManageEntity cityManageEntity = cityManageEntities.get(i);
                String cityName = cityManageEntity.getCityName();
                cityListTemp.add(cityName);
                if (!weatherCityList.contains(cityName)) {
                    weatherCityList.add(cityName);
                }
            }

                for (int j = 0; j < weatherCityList.size(); j++) {
                    //通过一个集合来判断是不是数据里的的数据包含weatherCityList的数据
                    if (cityListTemp.contains(weatherCityList.get(j))) {
                        mFragments.add(WeatherAreaFragment.newInstance(weatherCityList.get(j)));
                    } else {
                        weatherCityList.remove(j);
                        j--;
                    }
            }
        }
        mAdapter.upDateFragment(mFragments);
//        vpViewPager.setCurrentItem(weatherCityList.size() - 1);
//        fragmentData.clear();
//        fragmentData.addAll(mFragments);

        String showCityName = mActivity.getIntent().getStringExtra("weatherCityName");
        if (!TextUtils.isEmpty(showCityName)) {
            if (weatherCityList.contains(showCityName)) {
                int i = weatherCityList.indexOf(showCityName);
                vpViewPager.setCurrentItem(i);
                return;
            } else {
                weatherCityList.add(showCityName);
                mFragments.add(WeatherAreaFragment.newInstance(showCityName));
                dbManager.insertCityManage(showCityName, null, null, null);
                mAdapter.upDateFragment(mFragments);
                vpViewPager.setCurrentItem(weatherCityList.size() - 1);
            }

        }

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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main_weather, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                showToast("分享");
                break;
            case R.id.action_city_manage:
                Intent intent = new Intent(mActivity, CityManageActivity.class);
                intent.putExtra("locationCity", currentCity);
                startActivity(intent);
                break;
            default:
                break;
        }
        return true;
    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (RESULT_OK == resultCode) {
//            String showCityName = data.getStringExtra("showCityName");
//
//        }
//    }
}
