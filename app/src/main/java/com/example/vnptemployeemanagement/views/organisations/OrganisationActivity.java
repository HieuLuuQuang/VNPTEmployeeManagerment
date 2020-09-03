package com.example.vnptemployeemanagement.views.organisations;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vnptemployeemanagement.R;

public class OrganisationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_info);
        Toast.makeText(getApplicationContext(), "EmployeeInfo activity", Toast.LENGTH_SHORT).show();
    }
}
