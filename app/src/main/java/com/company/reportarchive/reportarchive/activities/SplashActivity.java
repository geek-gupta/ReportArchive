package com.company.reportarchive.reportarchive.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.company.reportarchive.reportarchive.R;
import com.company.reportarchive.reportarchive.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

//    SharedPreferences sharedPreferences;
//    String filename = "MY_PREF";
//    String KEY = "showsplash";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        sharedPreferences = getSharedPreferences(filename, MODE_PRIVATE);
//        boolean showSplashScreen = sharedPreferences.getBoolean(KEY, true);
//        if (showSplashScreen) {
//            sharedPreferences.edit().putBoolean(KEY, false).commit();
//        } else {
//            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        }



        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
