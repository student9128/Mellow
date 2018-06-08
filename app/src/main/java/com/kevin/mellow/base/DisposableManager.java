package com.kevin.mellow.base;

import android.text.TextUtils;
import android.util.ArrayMap;

import com.kevin.mellow.utils.LogK;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/6/6.
 * <h3>
 * Describe:
 * <h3/>
 */
public class DisposableManager {
    private static ArrayMap<String, CompositeDisposable> map = new ArrayMap<>();

    public static void addDispose(String key, Disposable d) {
        if (TextUtils.isEmpty(key)) {
            throw new NullPointerException("the Disposable key can not be null");
        }else {
        if (map.containsKey(key)) {
            map.get(key).add(d);
        } else {
            CompositeDisposable compositeDisposable = new CompositeDisposable();
            compositeDisposable.add(d);
            map.put(key, compositeDisposable);
        }
        int x = map.size();
        LogK.d("TAG",x+"");
        }
    }

    public static void removeDispose(String key) {
        if (map.containsKey(key)) {
            map.get(key).clear();
            map.remove(key);
        }
        int x = map.size();
        LogK.d("TAG",x+"");
    }

    public static void removeAll() {
        map.clear();
    }
}
