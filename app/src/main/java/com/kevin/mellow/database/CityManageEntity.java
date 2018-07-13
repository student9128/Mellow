package com.kevin.mellow.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Kevin on 2018/7/2.
 * <p>
 * Blog:https://student9128.github.io/
 * CSDN:https://blog.csdn.net/student9128
 * <p/>
 */
@Entity
public class CityManageEntity {
    @Id
    private Long id;
    private String cityName;
    private String weather;
    private String temperature;
    private String weatherIcon;
    @Generated(hash = 206658636)
    public CityManageEntity(Long id, String cityName, String weather,
            String temperature, String weatherIcon) {
        this.id = id;
        this.cityName = cityName;
        this.weather = weather;
        this.temperature = temperature;
        this.weatherIcon = weatherIcon;
    }
    @Generated(hash = 1999641383)
    public CityManageEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCityName() {
        return this.cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getWeather() {
        return this.weather;
    }
    public void setWeather(String weather) {
        this.weather = weather;
    }
    public String getTemperature() {
        return this.temperature;
    }
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
    public String getWeatherIcon() {
        return this.weatherIcon;
    }
    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

}
