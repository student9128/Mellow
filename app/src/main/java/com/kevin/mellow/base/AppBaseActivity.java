package com.kevin.mellow.base;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kevin.mellow.constant.Constants;
import com.kevin.mellow.utils.LogK;
import com.kevin.mellow.utils.NetUtils;
import com.kevin.mellow.utils.SPUtil;
import com.kevin.mellow.utils.StatusBarUtil;
import com.kevin.mellow.utils.ToastUtils;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/18.
 * <h3>
 * Describe:
 * <h3/>
 */
public class AppBaseActivity extends AppCompatActivity {
    /**
     * Tag,can be used for log or toast.
     */
    public String TAG = getClass().getSimpleName();

    //===============Methods=================//

//    public String getUserCode() {
////        return BaseApplication.getUser().getUserCode();
//        return BaseApplication.userCode;
//    }
//
//    public String getToken() {
//        return BaseApplication.token;
//    }

    /**
     * check network is available.
     *
     * @return true or false.
     */
    public boolean networkAvailable() {
        return NetUtils.isNetworkAvailable(BaseApplication.getContext());
    }

    /**
     * make sure whether net work is available,<br/>
     * if not show tips.
     *
     * @return
     */
    public boolean showNetWorkTip() {
        if (!networkAvailable()) {
            showToast(Constants.TIP_NETWORK_TIPS);
            return true;
        }
        return false;
    }

    @Nullable
    public String getStringById(int resId) {
        return resId == View.NO_ID || resId == 0 ? null : getString(resId);
    }
    /**
     * get the text from string
     *
     * @param ResId
     * @return
     */
    public String getMyString(int ResId) {
        return getResources().getString(ResId);
    }

    /**
     * can be used for setting text color or background
     *
     * @param color
     * @return
     */
    public int getMyColor(int color) {
        return ContextCompat.getColor(this, color);
    }

    /**
     * store value in SharePreferences.
     *
     * @param key key
     * @param str value
     */
    public void setSp(String key, String str) {
        SPUtil.setSP(key, this, str);
    }

    public void setSp(String key, boolean b) {
        SPUtil.setSP(key, this, b);
    }

    /**
     * get SharePreferences value.
     *
     * @param key key
     * @return value
     */
    public String getStringSp(String key) {
        return SPUtil.getStringSP(key, this);
    }

    public Boolean getBooleanSp(String key) {
        return SPUtil.getBooleanSP(key, this);
    }
    //===============Tool=================//

    /**
     * 使用ApplicationContext防止内存泄漏
     * @param message
     */
    public void showToast(String message) {
        ToastUtils.showToast(getApplicationContext(), message);
    }

    public void showLongToast(String message) {
        ToastUtils.showLongToast(getApplicationContext(), message);
    }

    public void printLoge(String str) {
        LogK.e(TAG, str);
    }

    public void printLogd(String str) {
        LogK.d(TAG, str);
    }

    public void printLogi(String str) {
        LogK.i(TAG, str);
    }

    public void printLogv(String str) {
        LogK.v(TAG, str);
    }

    public void printLogw(String str) {
        LogK.w(TAG, str);
    }
}
