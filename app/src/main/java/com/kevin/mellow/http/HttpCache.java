package com.kevin.mellow.http;

import com.kevin.mellow.base.BaseApplication;

import java.io.File;

import okhttp3.Cache;

public class HttpCache {

    private static final int HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 50 * 1024 * 1024;

    public static Cache getCache() {
        return new Cache(new File(BaseApplication.getContext().getCacheDir().getAbsolutePath() + File.separator + "data/NetCache"),
                HTTP_RESPONSE_DISK_CACHE_MAX_SIZE);
    }
}