package com.kevin.mellow.cache;

import android.net.Uri;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/6/7.
 * <h3>
 * Describe:
 * <h3/>
 */
public class CacheIntent implements Serializable {
    private String action;
    private Map<String,Object> bundle;
    private Set<String> categories;
    private String className;
    private Uri data;
    private int flags;
    private int requestCode;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Map<String, Object> getBundle() {
        return bundle;
    }

    public void setBundle(Map<String, Object> bundle) {
        this.bundle = bundle;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Uri getData() {
        return data;
    }

    public void setData(Uri data) {
        this.data = data;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public int getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(int requestCode) {
        this.requestCode = requestCode;
    }
}
