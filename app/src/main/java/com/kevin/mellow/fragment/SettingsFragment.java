package com.kevin.mellow.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kevin.mellow.R;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.constant.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/21.
 * <h3>Description:</h3>
 * <div>
 * <div/>
 */


public class SettingsFragment extends BaseFragment {


    @BindView(R.id.tv_text)
    TextView tvText;

    public static SettingsFragment newInstance(String s) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS, s);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int setLayoutResId() {
        return R.layout.fragment_settings;
    }

    @Override
    public void initView() {
        String locationInfo = getStringSp("locationInfo");
        tvText.setText(locationInfo);
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

}
