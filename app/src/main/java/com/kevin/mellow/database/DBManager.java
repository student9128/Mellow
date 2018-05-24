package com.kevin.mellow.database;

import android.content.Context;

import com.kevin.mellow.base.BaseApplication;
import com.kevin.mellow.utils.CityComparator;

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

    public static DBManager getInstance() {
        if (mInstance == null) {
            mInstance = new DBManager();

        }
        return mInstance;
    }

    public DBManager() {
        mDevOpenHelper = new DaoMaster.DevOpenHelper(BaseApplication.getContext(), CityTable
                .DB_NAME);
        mDaoMaster = new DaoMaster(mDevOpenHelper.getWritableDb());
        mDaoSession = mDaoMaster.newSession();
        mDataEntityDao = mDaoSession.getCityDataEntityDao();
    }

    public void insertData(String province, String city, String cityPinyin) {
        CityDataEntity dataEntity = new CityDataEntity(null, province, city, cityPinyin);
        mDataEntityDao.insert(dataEntity);
    }

    public void update(String province, String city, String cityPinyin) {
        CityDataEntity dataEntity = new CityDataEntity(null, province, city, cityPinyin);
        mDataEntityDao.update(dataEntity);
    }

    public void delete(String province, String city, String cityPinyin) {
        CityDataEntity dataEntity = new CityDataEntity(null, province, city, cityPinyin);
        mDataEntityDao.delete(dataEntity);
    }

    public void clearData() {
        mDataEntityDao.deleteAll();
    }

    public List<CityDataEntity> retrieveAll() {

        List<CityDataEntity> list = mDataEntityDao.queryBuilder().build().list();
        CityComparator comparator = new CityComparator();
        Collections.sort(list,comparator);
        return list;
    }

}
