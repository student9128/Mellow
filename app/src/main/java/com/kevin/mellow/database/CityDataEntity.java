package com.kevin.mellow.database;

import android.text.TextUtils;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/23.
 * <h3>
 * Describe:
 * <h3/>
 */
@Entity
public class CityDataEntity {
    @Id
    private Long id;
    private String province;
    private String city;
    private String cityPinyin;
    @Generated(hash = 1331987871)
    public CityDataEntity(Long id, String province, String city,
            String cityPinyin) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.cityPinyin = cityPinyin;
    }
    @Generated(hash = 860713664)
    public CityDataEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProvince() {
        return this.province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCityPinyin() {
        return this.cityPinyin;
    }
    public void setCityPinyin(String cityPinyin) {
        this.cityPinyin = cityPinyin;
    }
    public String getSectionText() {
        if (TextUtils.isEmpty(cityPinyin)) {
            return "#";
        } else {
            String c = cityPinyin.substring(0, 1);
            Pattern pattern = Pattern.compile("[a-zA-z]");
            Matcher matcher = pattern.matcher(c);
            if (matcher.matches()) {
                return c.toUpperCase();
            } else if (TextUtils.equals(c, "定") || TextUtils.equals(c, "热")) {
                return cityPinyin;
            } else {
                return "#";
            }
        }
    }
}
