package com.kevin.mellow.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.kevin.mellow.presenter.WeatherPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

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
        initFragments();
        mAdapter = new WeatherAdapter(getChildFragmentManager(), mFragments);
        vpViewPager.setAdapter(mAdapter);
        vpViewPager.setCurrentItem(0);
    }

    private void initFragments() {
        String currentCity = getStringSp(Constants.LOCATION_CITY);
        mFragments.add(WeatherAreaFragment.newInstance(currentCity));
        mFragments.add(WeatherAreaFragment.newInstance("北京"));
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
                startNewActivity(CityManageActivity.class);
                break;
            default:
                break;
        }
        return true;
    }

}
