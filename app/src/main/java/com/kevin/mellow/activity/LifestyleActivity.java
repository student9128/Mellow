package com.kevin.mellow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.base.BaseActivity;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.utils.LifestyleUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kevin on 2018/7/13.
 * <p>
 * Blog:https://student9128.github.io/
 * CSDN:https://blog.csdn.net/student9128
 * <p/>
 */
public class LifestyleActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_lifestyle_brief)
    TextView tvLifestyleBrief;
    @BindView(R.id.tv_lifestyle_text)
    TextView tvLifestyleText;
    @BindView(R.id.tv_city_name)
    TextView tvCityName;
    @BindView(R.id.tv_weather_key)
    TextView tvWeatherKey;
    @BindView(R.id.tv_weather_value)
    TextView tvWeatherValue;
    @BindView(R.id.tv_temperature_key)
    TextView tvTemperatureKey;
    @BindView(R.id.tv_temperature_value)
    TextView tvTemperatureValue;
    @BindView(R.id.tv_wind_key)
    TextView tvWindKey;
    @BindView(R.id.tv_wind_value)
    TextView tvWindValue;
    @BindView(R.id.iv_lifestyle_icon)
    ImageView ivLifestyleIcon;

    @Override
    public int setLayoutResId() {
        return R.layout.activity_lifestyle;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("lifestyle");
        String cityName = bundle.getString(Constants.KEY_CITY_NAME);
        String weather = bundle.getString(Constants.KEY_WEATHER);
        String temperature = bundle.getString(Constants.KEY_TEMPERATURE);
        String wind = bundle.getString(Constants.KEY_WIND);
        String lifestyleName = bundle.getString(Constants.KEY_LIFESTYLE_NAME);
        String lifestyleBrf = bundle.getString(Constants.KEY_LIFESTYLE_BRF);
        String lifestyleText = bundle.getString(Constants.KEY_LIFESTYLE_TEXT);

        actionBar.setTitle(LifestyleUtils.getLifeStyleName(lifestyleName));
        tvLifestyleBrief.setText(lifestyleBrf);
        tvLifestyleText.setText(lifestyleText);
        ivLifestyleIcon.setImageResource(LifestyleUtils.getLifeStyleIcon(lifestyleName));

        tvCityName.setText(cityName);
        tvWeatherValue.setText(weather);
        tvTemperatureValue.setText(temperature+"℃");
        tvWindValue.setText(wind);
    }

}
