package com.example.vnptemployeemanagement;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EmployeeInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_info);
        Toast.makeText(getApplicationContext(), "EmployeeInfo activity", Toast.LENGTH_SHORT).show();
    }
}
