package com.kevin.mellow.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/1/9.
 * <h3>Description:</h3>
 * <div>
 * </div>
 */


public class ReadUtil {
    public static String readAsset(Context context) {
        AssetManager am = context.getAssets();
        String[] path = null;
        try {
            // 列出files目录下的文件
            path = am.list("files");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String data = "";

        // 遍历assets目录下，files文件夹下的所有文件，读取这些文件的数据并输出。
        for (int i = 0; i < path.length; i++) {
            InputStream is = null;
            try {
                // 根据上文的 ‘files’+文件名，拼成一个路径，用AssetManager打开一个输入流，读写数据。
                is = am.open("files/" + path[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 读取一个文件完成，加上换行符（主要是为了观察输出结果，无他）。
            data = data + readDataFromInputStream(is) + "\n";

            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public static String readDataFromInputStream(InputStream is) {
        BufferedInputStream bis = new BufferedInputStream(is);

        String str = "", s = "";

        int c = 0;
        byte[] buf = new byte[64];
        while (true) {
            try {
                c = bis.read(buf);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (c == -1)
                break;
            else {
                try {
                    s = new String(buf, 0, c, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                str += s;
            }
        }

        try {
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }
}
