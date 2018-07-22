package com.kevin.mellow.utils;

import com.kevin.mellow.R;

/**
 * Created by Kevin on 2018/7/13.
 * <p>
 * Blog:https://student9128.github.io/
 * CSDN:https://blog.csdn.net/student9128
 * <p/>
 */
public class LifestyleUtils {
    /**
     * 获取生活指数名字
     * @param name
     * @return
     */
    public static String getLifeStyleName(String name) {
        String x = "";
        switch (name) {
            case "comf":
                x = "舒适度指数";
                break;
            case "drsg":
                x = "穿衣指数";
                break;
            case "flu":
                x = "感冒指数";
                break;
            case "sport":
                x = "运动指数";
                break;
            case "trav":
                x = "旅游指数";
                break;
            case "uv":
                x = "紫外线指数";
                break;
            case "cw":
                x = "洗车指数";
                break;
            case "air":
                x = "空气污染扩散条件指数";
                break;
        }
        return x;
    }

    /**
     * 获取生活指数图标
     * @param name
     * @return
     */
    public static int getLifeStyleIcon(String name) {
        int i = -1;
        switch (name) {
            case "comf":
                i = R.drawable.ic_index_comf;
                break;
            case "drsg":
                i = R.drawable.ic_index_drsg;
                break;
            case "flu":
                i = R.drawable.ic_index_flu;
                break;
            case "sport":
                i = R.drawable.ic_index_sport;
                break;
            case "trav":
                i = R.drawable.ic_index_trav;
                break;
            case "uv":
                i = R.drawable.ic_index_uv;
                break;
            case "cw":
                i = R.drawable.ic_index_cw;
                break;
            case "air":
                i = R.drawable.ic_index_air;
                break;
        }
        return i;
    }
}
