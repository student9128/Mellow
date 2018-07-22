package com.kevin.mellow.database;

import android.content.Context;

import com.kevin.mellow.base.BaseApplication;
import com.kevin.mellow.utils.CityComparator;
import com.kevin.mellow.utils.LogK;

import java.util.Collections;
import java.util.List;


/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/23.
 * <h3>
 * Describe:
 * <h3/>
 */
public class DBManager {
    private static DBManager mInstance;
    private DaoMaster.DevOpenHelper mDevOpenHelper;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private CityDataEntityDao mDataEntityDao;
    private CityManageEntityDao mCityManageEntityDao;

    public static DBManager getInstance() {
        if (mInstance == null) {
            synchronized (DBManager.class) {
            mInstance = new DBManager();
            }

        }
        return mInstance;
    }

    public DBManager() {
        mDevOpenHelper = new DaoMaster.DevOpenHelper(BaseApplication.getContext(), CityTable
                .DB_NAME);
        mDaoMaster = new DaoMaster(mDevOpenHelper.getWritableDb());
        mDaoSession = mDaoMaster.newSession();
        mDataEntityDao = mDaoSession.getCityDataEntityDao();
        mCityManageEntityDao = mDaoSession.getCityManageEntityDao();
    }

    public void insertCityData(String province, String city, String cityPinyin) {
        CityDataEntity dataEntity = new CityDataEntity(null, province, city, cityPinyin);
        mDataEntityDao.insert(dataEntity);
    }

    public void updateCity(String province, String city, String cityPinyin) {
        CityDataEntity dataEntity = new CityDataEntity(null, province, city, cityPinyin);
        mDataEntityDao.update(dataEntity);
    }

    public void deleteCity(String province, String city, String cityPinyin) {
        CityDataEntity dataEntity = new CityDataEntity(null, province, city, cityPinyin);
        mDataEntityDao.delete(dataEntity);
    }

    public void clearData() {
        mDataEntityDao.deleteAll();
    }


    public List<CityDataEntity> retrieveAll() {

        List<CityDataEntity> list = mDataEntityDao.queryBuilder().build().list();
        CityComparator comparator = new CityComparator();
        Collections.sort(list, comparator);
        return list;
    }

    /**
     * 城市管理栏目：添加城市
     * @param cityName
     * @param weather
     * @param temperature
     * @param weatherIcon
     */
    public void insertCityManage(String cityName, String weather, String temperature,String weatherIcon) {
        CityManageEntity cityManageEntity = new CityManageEntity(null, cityName, weather,
                temperature,weatherIcon);
        mCityManageEntityDao.insert(cityManageEntity);
    }

    public void updateCityManage(String cityName, String weather, String temperature,String weatherIcon) {
        CityManageEntity cityManageEntity = new CityManageEntity(null, cityName, weather,
                temperature,weatherIcon);
        mCityManageEntityDao.update(cityManageEntity);
    }

    public void deleteCityManage(String cityName) {
//        CityManageEntity cityManageEntity = new CityManageEntity(1l, cityName, weather,
//                temperature,weatherIcon);
//        boolean b = mCityManageEntityDao.hasKey(cityManageEntity);
//        LogK.d("DB",b+"");
//        mCityManageEntityDao.delete(cityManageEntity);
        String sql = "delete from " + CityManageEntityDao.TABLENAME + " where CITY_NAME='" + cityName + "'";
        mDaoSession.getDatabase().execSQL(sql);
    }

    public void clearManageData() {
        mCityManageEntityDao.deleteAll();
    }

    /**
     * 获取城市管理中的所有城市
     * @return
     */
    public List<CityManageEntity> retrieveAllCity() {
        List<CityManageEntity> list = mCityManageEntityDao.queryBuilder().build().list();
        return list;
    }

    public boolean isExistsByName(String cityName) {
        List<CityManageEntity> cityManageEntities = mCityManageEntityDao.queryRaw("where " +
                "CITY_NAME=?", cityName);
        if (cityManageEntities != null && cityManageEntities.size() > 0) {
            CityManageEntity cityManageEntity = cityManageEntities.get(0);
            String name = cityManageEntity.getCityName();
            LogK.d("DBMANAGER",name);
            return true;
        }
        return false;
    }


}
