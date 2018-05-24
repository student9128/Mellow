package com.kevin.mellow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.kevin.mellow.MainActivity;
import com.kevin.mellow.R;
import com.kevin.mellow.base.BaseActivity;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.fragment.LocationFragment;
import com.kevin.mellow.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/19.
 * <h3>
 * Describe:
 * <h3/>
 */
public class LocationActivity extends BaseActivity implements LocationFragment.OnLocationActiveListener{

    @Override
    public int setLayoutResId() {
        return R.layout.activity_location;
    }

    @Override
    public void initView() {
        actionBar.setTitle(R.string.location_choice);
        LocationFragment locationFragment = (LocationFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fl_content);
        if (null == locationFragment) {
            locationFragment = LocationFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), locationFragment, R
                    .id.fl_content);
        }
    }

    @Override
    public void onLocationActive(String cityName) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Constants.LOCATION_CITY, cityName);
        setResult(RESULT_OK, intent);
        finish();
    }
}
