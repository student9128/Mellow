package com.kevin.mellow.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class TabLayoutFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<String> tabList;

    public TabLayoutFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public TabLayoutFragmentAdapter(FragmentManager fm, List<Fragment> fragments, List<String> tabList) {
        super(fm);
        this.fragments = fragments;
        this.tabList = tabList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabList == null ? "default" : tabList.get(position);
    }
}