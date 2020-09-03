package com.example.vnptemployeemanagement.views.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.vnptemployeemanagement.R;
import com.example.vnptemployeemanagement.models.Employee;
import com.example.vnptemployeemanagement.utils.MyApp;
import com.example.vnptemployeemanagement.views.employees.EmployeeViewModel;

import java.util.List;

public class SplashActivity extends AppCompatActivity {

    private EmployeeViewModel mEmployeeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyApp.setOrganisation();
        mEmployeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);
        mEmployeeViewModel.getAllWords().observe(SplashActivity.this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(@Nullable final List<Employee> employees) {
                MyApp.mAllEmployees = employees;
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}