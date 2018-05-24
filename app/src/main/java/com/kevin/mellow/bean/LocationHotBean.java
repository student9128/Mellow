package com.kevin.mellow.bean;

import com.kevin.mellow.database.CityDataEntity;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/24.
 * <h3>
 * Describe:
 * <h3/>
 */
public class LocationHotBean extends CityDataEntity {
    public LocationHotBean(String province, String city) {
        super(1l,province,city,"热门城市");
    }
}
