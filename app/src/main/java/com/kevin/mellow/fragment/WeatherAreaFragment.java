package com.kevin.mellow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.activity.CityManageActivity;
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
import com.kevin.mellow.utils.DateUtils;
import com.kevin.mellow.utils.SPUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.sharesdk.onekeyshare.OnekeyShare;

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
    private StringBuffer str;

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
    public void shareWeather(WeatherBean.HeWeather6Bean data) {
        String status = data.getStatus();
        str = new StringBuffer();
        if ("ok".equals(status)) {
            WeatherBean.HeWeather6Bean.BasicBean basic = data.getBasic();
            List<WeatherBean.HeWeather6Bean.DailyForecastBean> dailyForecast = data
                    .getDaily_forecast();

            str.append(cityName + "天气预报：\n");
            for (int i = 0; i < dailyForecast.size(); i++) {
                String week = DateUtils.theDay(dailyForecast.get(i).getDate());
                String tmpMax = dailyForecast.get(i).getTmp_max();
                String tmpMin = dailyForecast.get(i).getTmp_min();
                String condTxtD = dailyForecast.get(i).getCond_txt_d();
                String condTxtN = dailyForecast.get(i).getCond_txt_n();
                str.append(week + ":");
                str.append(DateUtils.isNight() ? condTxtN : condTxtD + ",");
                str.append(tmpMax + "~" + tmpMin + "℃ \n");
            }
            str.append("当前天气情况：\n");
            str.append(tvCurrentWeather.getText().toString() + ",");
            str.append(tvCurrentTemp.getText().toString() + ",");
            str.append(tvCurrentWind.getText().toString());
        } else {
//            showToast(status);
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
        mPresenter = presenter;
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
        bundle.putString(Constants.KEY_WEATHER, tvCurrentWeather.getText().toString());
        bundle.putString(Constants.KEY_TEMPERATURE, tvCurrentTemp.getText().toString());
        bundle.putString(Constants.KEY_WIND, tvCurrentWind.getText().toString());
        bundle.putString(Constants.KEY_LIFESTYLE_NAME, lifestyleBean.getType());
        bundle.putString(Constants.KEY_LIFESTYLE_BRF, lifestyleBean.getBrf());
        bundle.putString(Constants.KEY_LIFESTYLE_TEXT, lifestyleBean.getTxt());
        intent.putExtra("lifestyle", bundle);
        startActivity(intent, bundle);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
//                showShare();

                if (!TextUtils.isEmpty(str)) {
                    Intent textIntent = new Intent(Intent.ACTION_SEND);
                    textIntent.setType("text/plain");
                    textIntent.putExtra(Intent.EXTRA_TEXT, "");
                    startActivity(Intent.createChooser(textIntent, "分享到"));
                } else {
                    showToast("无法获取数据");
                }
                break;
            case R.id.action_city_manage:
                String currentCity = SPUtil.getStringSP(Constants.LOCATION_DISTRICT,mActivity);
                if (TextUtils.isEmpty(currentCity)) {
                    currentCity = "定位失败";
                }
                Intent intent = new Intent(mActivity, CityManageActivity.class);
                intent.putExtra("locationCity", currentCity);
                startActivity(intent);
                break;
            default:
                break;
        }
        return true;
    }

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // title标题，微信、QQ和QQ空间等平台使用
        oks.setTitle("分享");
        // titleUrl QQ和QQ空间跳转链接
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url在微信、微博，Facebook等平台中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网使用
        oks.setComment("我是测试评论文本");
        // 启动分享GUI
        oks.show(mActivity);
    }

}
