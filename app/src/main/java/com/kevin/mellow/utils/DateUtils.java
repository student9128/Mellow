package com.kevin.mellow.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/7.
 * <h3>
 * Describe:
 * <h3/>
 */
public class DateUtils {
    public static String time;

    private static ThreadLocal<SimpleDateFormat> mDateLocal = new ThreadLocal<>();
    private static final int YSETERDAY = -1;
    private static final int TODAY = 0;
    private static final int TOMORROW = 1;

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
    }

    public static String dateFormat5(String str) {
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

    public static String dateFormat6(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;//解析字符串，转化为Date
        try {
            date = simpleDateFormat.parse(str);
            simpleDateFormat = new SimpleDateFormat("MM/dd");
            time = simpleDateFormat.format(date);//格式化String类型
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }


    /**
     * 根据传入时间来判断是星期几
     *
     * @param time
     * @return
     */
    public static String getWeek(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String week = "";
        int i = c.get(Calendar.DAY_OF_WEEK);
        switch (i) {
            case 1:
                week = "周日";
                break;
            case 2:
                week = "周一";
                break;
            case 3:
                week = "周二";
                break;
            case 4:
                week = "周三";
                break;
            case 5:
                week = "周四";
                break;
            case 6:
                week = "周五";
                break;
            case 7:
                week = "周六";
                break;
        }
        return week;

    }

    public static boolean isToday(String time) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(parse);
        if (calendar.get(Calendar.YEAR) == c.get(Calendar.YEAR)) {
            int i = calendar.get(Calendar.DAY_OF_YEAR) - c.get(Calendar.DAY_OF_YEAR);
            if (i == 0) {
                return true;
            }
        }
        return false;
    }

    public static SimpleDateFormat getDateFormat() {
        if (null == mDateLocal.get()) {
            mDateLocal.set(new SimpleDateFormat("yyyy-MM-dd"));
        }
        return mDateLocal.get();
    }

    /**
     * 判断是昨天，今天，还是明天，都不是则显示周几
     *
     * @param time
     * @return
     */
    public static String theDay(String time) {
        Calendar current = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        current.setTime(new Date());
        try {
            cal.setTime(getDateFormat().parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (cal.get(Calendar.YEAR) == current.get(Calendar.YEAR)) {
            int i = cal.get(Calendar.DAY_OF_YEAR) - current.get(Calendar.DAY_OF_YEAR);
            switch (i) {
                case YSETERDAY:
                    return "昨天";
                case TODAY:
                    return "今天";
                case TOMORROW:
                    return "明天";
            }
        }
        return getWeek(time);
    }

    public static boolean isNight() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        String hour= sdf.format(new Date());
        int k  = Integer.parseInt(hour)  ;
        if ((k>=0 && k<5) ||(k >=18 && k<24)){
            return true;
        } else {
            return false;
        }

    }

}
