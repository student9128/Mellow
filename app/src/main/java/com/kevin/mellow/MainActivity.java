package com.kevin.mellow;

import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.kevin.mellow.base.BaseActivity;
import com.kevin.mellow.fragment.CenterWeatherFragment;
import com.kevin.mellow.fragment.DouBanFragment;
import com.kevin.mellow.fragment.LiVideoFragment;
import com.kevin.mellow.fragment.TuChongFragment;
import com.kevin.mellow.fragment.SettingsFragment;
import com.kevin.mellow.utils.DisplayUtils;

import java.lang.reflect.Field;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements DrawerLayout.DrawerListener, NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    //    @BindView(R.id.tv_title)
//    TextView tvTitle;
//    @BindView(R.id.iv_function)
//    ImageView ivFunction;
//    @BindView(R.id.tool_bar)
//    Toolbar toolBar;
    private ActionBarDrawerToggle drawerToggle;
//    public ActionBar actionBar;

    private DouBanFragment douBanFragment;
    private TuChongFragment oneArticleFragment;
    private CenterWeatherFragment centerWeatherFragment;
    private LiVideoFragment liVideoFragment;
    private SettingsFragment settingsFragment;
    private Fragment mTempFragment;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//        setSupportActionBar(toolBar);
//        toolBar.setNavigationIcon(R.drawable.ic_menu);
//
//        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar,
//                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawerToggle.setDrawerIndicatorEnabled(true);
//        drawerToggle.setHomeAsUpIndicator(R.drawable.ic_menu);
//
////        drawerToggle.syncState();//显示默认的三道杠图标
//        drawerLayout.setDrawerListener(this);
////        drawerLayout.setScrimColor(Color.TRANSPARENT);//drawerLayout滑出是侧边的阴影
////        drawerLayout.addDrawerListener(this);
////        navView.setItemIconTintList(null);//可以让图标保持原有颜色
//        navView.setItemIconTintList(null);
//        hideNavigationViewScrollbar(navView);
//        View headerView = navView.getHeaderView(0);
//        navView.setNavigationItemSelectedListener(this);
//    }

    @Override
    public int setLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        toolBar.setNavigationIcon(R.drawable.ic_menu);
        toolBar.setElevation(0f);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.setHomeAsUpIndicator(R.drawable.ic_menu);

//        drawerToggle.syncState();//显示默认的三道杠图标
        drawerLayout.setDrawerListener(this);

        //        drawerLayout.setScrimColor(Color.TRANSPARENT);//drawerLayout滑出是侧边的阴影
//        drawerLayout.addDrawerListener(this);
//        navView.setItemIconTintList(null);//可以让图标保持原有颜色
        changeDrawerLayoutResponseArea();


        navView.setItemIconTintList(null);
        hideNavigationViewScrollbar(navView);
        View headerView = navView.getHeaderView(0);
        navView.setNavigationItemSelectedListener(this);

        actionBar.setTitle(getString(R.string.dou_ban));//默认是oneFragment
        douBanFragment = DouBanFragment.newInstance(getString(R.string.dou_ban));
        mTempFragment = douBanFragment;
        getSupportFragmentManager().beginTransaction().add(R.id.fl_content, douBanFragment).commit();
    }

    /**
     * DrawerLayout从左往右滑动的时候，很难触发，这里修改触发范围，使其更容易滑出
     */
    private void changeDrawerLayoutResponseArea() {

/**********修改DrawerLayout滑动响应范围*******开始******/
        Field mDragger = null;
        try {
            mDragger = drawerLayout.getClass().getDeclaredField(
                    "mLeftDragger"); //mRightDragger for right obviously
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        mDragger.setAccessible(true);
        ViewDragHelper draggerObj = null;
        try {
            draggerObj = (ViewDragHelper) mDragger
                    .get(drawerLayout);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Field mEdgeSize = null;
        try {
            mEdgeSize = draggerObj.getClass().getDeclaredField(
                    "mEdgeSize");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        mEdgeSize.setAccessible(true);
        int edge = 0;
        try {
            edge = mEdgeSize.getInt(draggerObj);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            mEdgeSize.setInt(draggerObj, DisplayUtils.dip2px(this, 50)); //optimal value as for me, you may set any constant in dp
            //You can set it even to the value you want like mEdgeSize.setInt(draggerObj, 150); for 150dp
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
/**********修改DrawerLayout滑动响应范围*******结束******/
    }

    /**
     * 隐藏NavigationView中的ScrollBar
     * <p>
     * 使用android:scrollbars="none"不生效。
     * <br/>
     * 这个滚动条不在NavigationView中，而是在他的child—NavigationMenuView中
     * 所以解决办法就是对NavigationView调用下面这个方法
     * </p>
     *
     * @param navigationView
     */
    private void hideNavigationViewScrollbar(NavigationView navigationView) {
        if (navigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_dou_ban:
                if (douBanFragment == null) {
                    douBanFragment = DouBanFragment.newInstance(getString(R.string.dou_ban));
                }
                switchFragment(douBanFragment);
                actionBar.setTitle(getString(R.string.dou_ban));
                break;
            case R.id.nav_one_article:
                if (oneArticleFragment == null) {
                    oneArticleFragment = TuChongFragment.newInstance(getString(R.string.tu_chong));
                }
                switchFragment(oneArticleFragment);
                actionBar.setTitle(getString(R.string.tu_chong));
                break;
            case R.id.nav_center_weather:
                if (centerWeatherFragment == null) {
                    centerWeatherFragment = CenterWeatherFragment.newInstance(getString(R.string.center_weather));
                }
                switchFragment(centerWeatherFragment);
                actionBar.setTitle(getString(R.string.center_weather));
                break;
            case R.id.nav_li_video:
                if (liVideoFragment == null) {
                    liVideoFragment = LiVideoFragment.newInstance(getString(R.string.li_video));
                }
                switchFragment(liVideoFragment);
                actionBar.setTitle(getString(R.string.li_video));
                break;
            case R.id.nav_settings:
                if (settingsFragment == null) {
                    settingsFragment = SettingsFragment.newInstance(getString(R.string.settings));
                }
                switchFragment(settingsFragment);
                actionBar.setTitle(getString(R.string.settings));
                break;
            case R.id.nav_sign_out:
                android.os.Process.killProcess(android.os.Process.myPid());
                break;
            default:
                break;
        }
        drawerLayout.closeDrawers();
        return true;
    }

    private void switchFragment(Fragment fragment) {
        if (fragment != mTempFragment) {
            if (!fragment.isAdded()) {
                getSupportFragmentManager().beginTransaction().hide(mTempFragment)
                        .add(R.id.fl_content, fragment).commit();
            } else {
                getSupportFragmentManager().beginTransaction().hide(mTempFragment)
                        .show(fragment).commit();
            }
            mTempFragment = fragment;
        }
    }
    private long lastTime = 0;
    /**
     * 菜单、返回键响应,双击退出函数
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - lastTime) > 2000) {
                showToast(getString(R.string.exit_app_tip));
                lastTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
