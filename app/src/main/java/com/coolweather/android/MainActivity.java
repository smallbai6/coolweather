package com.coolweather.android;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //dbHelper = new SQLiteDatabaseHelper(this, "cool_weather.db", null, 1);
        //dbHelper.getWritableDatabase();
    }
}

