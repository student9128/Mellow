package com.kevin.mellow.utils;

import com.kevin.mellow.database.CityDataEntity;

import java.util.Comparator;

/**
     * sort by a-z
     */
    public class CityComparator implements Comparator<CityDataEntity> {
        @Override
        public int compare(CityDataEntity lhs, CityDataEntity rhs) {
            String a = lhs.getCityPinyin();
            String b = rhs.getCityPinyin();
            return a.compareTo(b);
        }
    }