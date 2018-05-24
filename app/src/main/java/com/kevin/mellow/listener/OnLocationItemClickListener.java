package com.kevin.mellow.listener;

public interface OnLocationItemClickListener{
        /**
         * 当前定位城市点击
         */
        void onCurrentLocationClick();

        /**
         * 热门城市点击
         */
        void onHotLocationClick(int position);

        /**
         * 所有城市点击
         */
        void onLocationClick(int position);
    }