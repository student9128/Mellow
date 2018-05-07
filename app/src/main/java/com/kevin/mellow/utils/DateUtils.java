package com.kevin.mellow.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/7.
 * <h3>
 * Describe:
 * <h3/>
 */
public class DateUtils {
    public static String time;

    /**
     * Make the date format yy-MM-dd<br/>
     * 将时间格式化为年-月-日
     * s
     *
     * @param str the string to be formatted<br/>
     *            被格式化的字符串
     * @return
     */
    public static String dateFormat(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;//解析字符串，转化为Date
        try {
            date = simpleDateFormat.parse(str);
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            time = simpleDateFormat.format(date);//格式化String类型
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static String dateFormat2(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = null;//解析字符串，转化为Date
        try {
            date = simpleDateFormat.parse(str);
            simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            time = simpleDateFormat.format(date);//格式化String类型
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static String dateFormat3(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;//解析字符串，转化为Date
        try {
            date = simpleDateFormat.parse(str);
            simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            time = simpleDateFormat.format(date);//格式化String类型
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static String dateFormat4(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = null;//解析字符串，转化为Date
        try {
            date = simpleDateFormat.parse(str);
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            time = simpleDateFormat.format(date);//格式化String类型
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }    public static String dateFormat5(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;//解析字符串，转化为Date
        try {
            date = simpleDateFormat.parse(str);
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            time = simpleDateFormat.format(date);//格式化String类型
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

}
