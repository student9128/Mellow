package com.kevin.mellow.fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.kevin.mellow.R;
import com.kevin.mellow.adapter.TabLayoutFragmentAdapter;
import com.kevin.mellow.base.BaseFragment;
import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.one.ChineseWeekFragment;
import com.kevin.mellow.one.HomeFragment;
import com.kevin.mellow.view.ColorTrackTabLayout;
import com.kevin.mellow.view.NoSmoothViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import butterknife.BindView;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2017/12/21.
 * <h3>Description:</h3>
 * <div>
 * <div/>
 */


public class OneFragment extends BaseFragment {

    String uniqueId = null;
    @BindView(R.id.tab_layout)
    ColorTrackTabLayout tabLayout;
    @BindView(R.id.ns_view_pager)
    NoSmoothViewPager nsViewPager;

    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mTabList = new ArrayList<>();
    private TabLayoutFragmentAdapter mAdapter;

    public static OneFragment newInstance(String s) {
        OneFragment fragment = new OneFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS, s);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int setLayoutResId() {
        return R.layout.fragment_one;
    }

    @Override
    public void initView() {
        getUuid(mActivity);
        initTabList();
        initFragmentList();
        mAdapter = new TabLayoutFragmentAdapter(getChildFragmentManager(), mFragments, mTabList);
        nsViewPager.setAdapter(mAdapter);
        nsViewPager.setCurrentItem(0);
        nsViewPager.setOffscreenPageLimit(0);
        tabLayout.setupWithViewPager(nsViewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public void initData() {
    }

    @Override
    public void initListener() {
    }

    private void initTabList() {
        mTabList.clear();
        mTabList.add(getString(R.string.one_home));
        mTabList.add(getString(R.string.one_chinese_week));
    }

    /**
     * add Fragment
     */
    public void initFragmentList() {
        mFragments.clear();
        mFragments.add(HomeFragment.newInstance(getString(R.string.one_home)));
        mFragments.add(ChineseWeekFragment.newInstance(getString(R.string.one_chinese_week)));

    }

    public String getUuid(Context context) {
        final TelephonyManager tm = (TelephonyManager) mActivity.getSystemService(Context.TELEPHONY_SERVICE);

        final String tmDevice, tmSerial, tmPhone, androidId;
//        if (!PermissionManager.hasPermission(context, Manifest.permission.READ_PHONE_STATE)) {
//            PermissionManager.requestPermission(fragment, PermissionManager.READ_PHONE_STATE_REQUEST_CODE,
//                    0, "");
//        } else {
//            }

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
//            return TODO;
            if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity, "需要授限")) {
                showAlertDialog("权限请求", "需要获取手机状态");
            } else {
//                ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.READ_PHONE_STATE}, 12);
                OneFragment.this.requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE}, 12);
            }

        } else {
            tmDevice = "" + tm.getDeviceId();
            tmSerial = "" + tm.getSimSerialNumber();
            androidId = "" + Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            UUID deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
            uniqueId = deviceUuid.toString();
        }

        return uniqueId;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d("TAG", grantResults.length + "");
        switch (requestCode) {
            case 12:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    showToast("获取权限成功");
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    showToast("获取权限失败");
                }
                break;
            default:
                break;
        }
    }


}
