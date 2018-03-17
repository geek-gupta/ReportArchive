package com.company.reportarchive.reportarchive.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.company.reportarchive.reportarchive.MainActivity;
import com.company.reportarchive.reportarchive.R;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    final String splashScreenString = "Splash Screen shown";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean splashScreenShow = sharedPreferences.getBoolean(splashScreenString,false);

        if(!splashScreenShow){
            Intent intent = new Intent(this, MainActivity.class);
             startActivity(intent);

             SharedPreferences.Editor  editor = sharedPreferences.edit();
             editor.putBoolean(splashScreenString,true);
             editor.commit();
             finish();
        }


    }
}
