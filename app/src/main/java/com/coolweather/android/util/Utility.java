package com.coolweather.android.util;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(SQLiteDatabase db, String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                ContentValues values = new ContentValues();
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    values.put("provinceCode",provinceObject.getInt("id"));
                    values.put("provinceName",provinceObject.getString("name"));
                    db.insert("Province", null, values);
                    values.clear();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(SQLiteDatabase db, String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                ContentValues values = new ContentValues();
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    values.put("cityName",cityObject.getString("name"));
                    values.put("cityCode",cityObject.getInt("id"));
                    values.put("provinceId",provinceId);
                    db.insert("City", null, values);
                    values.clear();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(SQLiteDatabase db, String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties = new JSONArray(response);
                ContentValues values = new ContentValues();
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    values.put("countyName",countyObject.getString("name"));
                    values.put("weatherId",countyObject.getString("weather_id"));
                    values.put("cityId",cityId);
                    db.insert("County", null, values);
                    values.clear();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
