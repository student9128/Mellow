package com.kevin.mellow.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by <a href="http://blog.csdn.net/student9128">Kevin</a> on 2018/5/22.
 * <h3>
 * Describe:
 * <h3/>
 */
public class CityInfoHelper extends SQLiteOpenHelper {
    private static CityInfoHelper mInstance;
    private static final String TAG = "CityInfoHelper.class";

    public static CityInfoHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new CityInfoHelper(context);

        }
        return mInstance;
    }

    public CityInfoHelper(Context context) {
        super(context, CityTable.DB_NAME, null, CityTable.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String sql = "CREATE TABLE IF NOT EXISTS " + CityTable.TABLE_NAME
//                + "(_id integer PRIMARY KEY AUTOINCREMENT, "
//                + CityTable.PROVINCE + " text,"
//                + CityTable.CITY + " text," + CityTable.CITY_PINYIN + " text);";
//        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="DROP TABLE IF EXISTS "+CityTable.TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);

    }

    public boolean isTableExists(String tabName) {
        boolean result = false;
        if(tabName == null){
            return false;
        }
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = this.getReadableDatabase();//此this是继承SQLiteOpenHelper类得到的
//            db = SQLiteDatabase.openDatabase("search.db", Context.MODE_PRIVATE, null);
            String sql = "select count(*) as c from sqlite_master where type = 'table' and name= '" +
                    tabName+"'";
            cursor = db.rawQuery(sql, null);
            if(cursor.moveToNext()){
                int count = cursor.getInt(0);
                if(count>0){
                    result = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            Throwable cause = e.getCause();
        }
        return result;
    }
}
