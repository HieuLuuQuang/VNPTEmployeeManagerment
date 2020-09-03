package com.example.vnptemployeemanagement.views.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vnptemployeemanagement.R;
import com.example.vnptemployeemanagement.utils.MyApp;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyApp.setOrganisation();
        new Handler(Looper.myLooper()).postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                },100
        );

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}