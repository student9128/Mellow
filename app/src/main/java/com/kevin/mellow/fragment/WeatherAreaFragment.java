package com.kevin.mellow.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.bean.WeatherBean;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.contract.WeatherContract;
import com.kevin.mellow.data.source.RequestDataSource;
import com.kevin.mellow.presenter.WeatherPresenter;

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
public class WeatherAreaFragment extends BaseFragment implements WeatherContract.View {

    @BindView(R.id.tv_current_city_name)
    TextView tvCurrentCityName;
    @BindView(R.id.tv_current_weather)
    TextView tvCurrentWeather;
    private WeatherContract.Presenter mPresenter;
    private String cityName;

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
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void loadData() {
        mPresenter.requestData(cityName);
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
            tvCurrentCityName.setText(basic.getLocation());
            WeatherBean.HeWeather6Bean.DailyForecastBean dailyForecastBean = dailyForecast.get(0);
            String condTxtD = dailyForecastBean.getCond_txt_d();
            String condTxtN = dailyForecastBean.getCond_txt_n();
            String tmpMax = dailyForecastBean.getTmp_max();
            String tmpMin = dailyForecastBean.getTmp_min();
            if (condTxtD.equals(condTxtN)) {
                tvCurrentWeather.setText(condTxtD);
            } else {
                tvCurrentWeather.setText(condTxtD + " 转 " + condTxtN);
            }

        } else {
            showToast(status);
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

}
