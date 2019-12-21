package com.coolweather.android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_PROVINCE = "create table Province("
            + "id integer primary key autoincrement,"
            + "provinceName text,"
            + "provinceCode integer)";
    public static final String CREATE_CITY = "create table City("
            + "id integer primary key autoincrement,"
            + "cityName text,"
            +"cityCode integer,"
            +"provinceId integer)";
    public static final String CREATE_COUNTY = "create table County("
            + "id integer primary key autoincrement,"
            + "countyName text,"
            + "weatherId text,"
            + "cityId integer)";
    private Context mContext;

    public SQLiteDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE);
        db.execSQL(CREATE_CITY);
        db.execSQL(CREATE_COUNTY);
        Log.d("SQLiteDatabasemy","a");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Province");
        db.execSQL("drop table if exists City");
        db.execSQL("drop table if exists Country");
        onCreate(db);
        Log.d("SQLiteDatabasemy","b");
    }
}
