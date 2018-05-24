package com.kevin.mellow.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/23.
 * <h3>
 * Describe:
 * <h3/>
 */
public class FileUtil {
    public static String readInfo(Context context) {
        AssetManager manager = context.getAssets();
        StringBuilder builder = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(manager.open("city.json"));
            BufferedReader br = new BufferedReader(inputStreamReader);
            builder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            br.close();
            inputStreamReader.close();
        } catch (Exception e) {

        }
        return builder.toString();
    }
}
