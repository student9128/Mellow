package com.kevin.mellow.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by Kevin on 2017/3/16.
 * Blog:http://blog.csdn.net/student9128.
 * Description:
 */

public class NoSmoothViewPager extends ViewPager {
    public NoSmoothViewPager(Context context) {
        super(context);
    }

    public NoSmoothViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item,false);
    }
}
