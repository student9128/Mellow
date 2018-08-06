package com.kevin.mellow.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;


import java.util.List;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/6/10.
 * <h3>
 * Describe:
 * <h3/>
 */
public class WeatherAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments;

    public WeatherAdapter(FragmentManager fm) {
        super(fm);
    }

    public void upDateFragment(List<Fragment> f){
        fragments.clear();
        fragments.addAll(f);
        notifyDataSetChanged();
    }

    public WeatherAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments==null?0:fragments.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {

        return PagerAdapter.POSITION_NONE;
    }
}
