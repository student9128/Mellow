package com.kevin.mellow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.activity.LifestyleActivity;
import com.kevin.mellow.adapter.DailyForecastAdapter;
import com.kevin.mellow.adapter.DailyLifeStyleAdapter;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.bean.CityCurrentWeatherBean;
import com.kevin.mellow.bean.CityLifeStyleBean;
import com.kevin.mellow.bean.WeatherBean;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.contract.WeatherContract;
import com.kevin.mellow.data.source.RequestDataSource;
import com.kevin.mellow.listener.OnRecyclerItemClickListener;
import com.kevin.mellow.presenter.WeatherPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/6/10.
 * <h3>
 * Describe:
 * <h3/>
 */
public class WeatherAreaFragment extends BaseFragment implements WeatherContract.View,
        SwipeRefreshLayout.OnRefreshListener, OnRecyclerItemClickListener {

    @BindView(R.id.tv_current_city_name)
    TextView tvCurrentCityName;
    @BindView(R.id.tv_current_weather)
    TextView tvCurrentWeather;
    @BindView(R.id.rv_recycler_view_days)
    RecyclerView rvRecyclerViewDays;
    @BindView(R.id.tv_current_temp)
    TextView tvCurrentTemp;
    @BindView(R.id.tv_current_wind)
    TextView tvCurrentWind;
    @BindView(R.id.rv_recycler_view_lifestyle)
    RecyclerView rvRecyclerViewLiefStyle;
    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout srlRefresh;
    private WeatherContract.Presenter mPresenter;
    private String cityName;
    private List<WeatherBean.HeWeather6Bean.DailyForecastBean> mDailyData = new ArrayList<>();
    private DailyForecastAdapter mDailyForecastAdapter;
    private List<CityLifeStyleBean.HeWeather6Bean.LifestyleBean> mLifeStyleData = new ArrayList<>();
    private DailyLifeStyleAdapter mDailyLifeStyleAdapter;

    public static WeatherAreaFragment newInstance(String s) {
        WeatherAreaFragment fragment = new WeatherAreaFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS, s);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new WeatherPresenter(this, RequestDataSource.getInstance());
    }

    @Override
    public int setLayoutResId() {
        return R.layout.fragment_weather_area;
    }

    @Override
    public void initView() {
        Bundle bundle = getArguments();
        cityName = bundle.getString(Constants.ARGS);
        rvRecyclerViewDays.setLayoutManager(new LinearLayoutManager(mActivity));
        mDailyForecastAdapter = new DailyForecastAdapter(mActivity, mDailyData);
        rvRecyclerViewDays.setAdapter(mDailyForecastAdapter);

        rvRecyclerViewLiefStyle.setLayoutManager(new GridLayoutManager(mActivity, 4));
        mDailyLifeStyleAdapter = new DailyLifeStyleAdapter(mActivity, mLifeStyleData);
        rvRecyclerViewLiefStyle.setAdapter(mDailyLifeStyleAdapter);
        srlRefresh.setColorSchemeColors(getMyColor(R.color.blue_1), getMyColor(R.color.red_1),
                getMyColor(R.color.teal));


    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        srlRefresh.setOnRefreshListener(this);
        mDailyLifeStyleAdapter.setOnLifeStyleClickListener(this);
    }

    @Override
    public void loadData() {
        requestLoad();
    }

    private void requestLoad() {
        if (cityName != "定位失败") {
            mPresenter.requestData(cityName);
            mPresenter.requestCurrentWeather(cityName);
            mPresenter.requestLifeStyle(cityName);
        } else {
            showToast("定位失败");
            srlRefresh.setRefreshing(false);
        }
    }

    @Override
    public void showTips(String msg) {

    }

    @Override
    public void showData(WeatherBean.HeWeather6Bean data) {
        String status = data.getStatus();
        if ("ok".equals(status)) {
            WeatherBean.HeWeather6Bean.BasicBean basic = data.getBasic();
            List<WeatherBean.HeWeather6Bean.DailyForecastBean> dailyForecast = data
                    .getDaily_forecast();
            mDailyForecastAdapter.updateWeather(dailyForecast);

        } else {
            showToast(status);
        }
    }

    @Override
    public void showCurrentWeather(CityCurrentWeatherBean.HeWeather6Bean data) {
        String status = data.getStatus();
        if ("ok".equals(status)) {
            CityCurrentWeatherBean.HeWeather6Bean.BasicBean basic = data.getBasic();
            CityCurrentWeatherBean.HeWeather6Bean.UpdateBean update = data.getUpdate();
            CityCurrentWeatherBean.HeWeather6Bean.NowBean now = data.getNow();
            tvCurrentCityName.setText(basic.getLocation());
            tvCurrentWeather.setText(now.getCond_txt());
            tvCurrentTemp.setText(now.getTmp());
            if ("0".equals(now.getWind_sc())) {
                tvCurrentWind.setText(now.getWind_dir() + " 静风");
            } else {
            tvCurrentWind.setText(now.getWind_dir() + " " + now.getWind_sc() + "级");
            }
        } else {
            showToast(status);
        }
    }

    @Override
    public void showLifeStyle(CityLifeStyleBean.HeWeather6Bean data) {
        String status = data.getStatus();
        if ("ok".equals(status)) {
            List<CityLifeStyleBean.HeWeather6Bean.LifestyleBean> lifestyle = data.getLifestyle();
            mDailyLifeStyleAdapter.updataLifeStyle(lifestyle);
        } else {
            showToast(status);
        }
    }

    @Override
    public void requestFinished() {
        if (srlRefresh.isRefreshing()) {
            srlRefresh.setRefreshing(false);
        }
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void dismissProgressDialog() {

    }

    @Override
    public void setPresenter(WeatherContract.Presenter presenter) {

    }

    @Override
    public String getUniqueTag() {
        return getDisposableKey();
    }

    @Override
    public void onRefresh() {
        requestLoad();
    }

    @Override
    public void onRecyclerItemClick(int position) {
        CityLifeStyleBean.HeWeather6Bean.LifestyleBean lifestyleBean = mLifeStyleData.get(position);
        Intent intent = new Intent(mActivity, LifestyleActivity.class);
        Bundle bundle = new Bundle();
        String s = tvCurrentWeather.getText().toString();
        printLogd(s);
        bundle.putString(Constants.KEY_CITY_NAME, cityName);
        bundle.putString(Constants.KEY_WEATHER,tvCurrentWeather.getText().toString());
        bundle.putString(Constants.KEY_TEMPERATURE, tvCurrentTemp.getText().toString());
        bundle.putString(Constants.KEY_WIND,tvCurrentWind.getText().toString());
        bundle.putString(Constants.KEY_LIFESTYLE_NAME,lifestyleBean.getType());
        bundle.putString(Constants.KEY_LIFESTYLE_BRF,lifestyleBean.getBrf());
        bundle.putString(Constants.KEY_LIFESTYLE_TEXT,lifestyleBean.getTxt());
        intent.putExtra("lifestyle", bundle);
        startActivity(intent,bundle);

    }
}
