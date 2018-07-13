package com.kevin.mellow.database;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.kevin.mellow.database.CityDataEntity;
import com.kevin.mellow.database.CityManageEntity;

import com.kevin.mellow.database.CityDataEntityDao;
import com.kevin.mellow.database.CityManageEntityDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig cityDataEntityDaoConfig;
    private final DaoConfig cityManageEntityDaoConfig;

    private final CityDataEntityDao cityDataEntityDao;
    private final CityManageEntityDao cityManageEntityDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        cityDataEntityDaoConfig = daoConfigMap.get(CityDataEntityDao.class).clone();
        cityDataEntityDaoConfig.initIdentityScope(type);

        cityManageEntityDaoConfig = daoConfigMap.get(CityManageEntityDao.class).clone();
        cityManageEntityDaoConfig.initIdentityScope(type);

        cityDataEntityDao = new CityDataEntityDao(cityDataEntityDaoConfig, this);
        cityManageEntityDao = new CityManageEntityDao(cityManageEntityDaoConfig, this);

        registerDao(CityDataEntity.class, cityDataEntityDao);
        registerDao(CityManageEntity.class, cityManageEntityDao);
    }
    
    public void clear() {
        cityDataEntityDaoConfig.clearIdentityScope();
        cityManageEntityDaoConfig.clearIdentityScope();
    }

    public CityDataEntityDao getCityDataEntityDao() {
        return cityDataEntityDao;
    }

    public CityManageEntityDao getCityManageEntityDao() {
        return cityManageEntityDao;
    }

}
