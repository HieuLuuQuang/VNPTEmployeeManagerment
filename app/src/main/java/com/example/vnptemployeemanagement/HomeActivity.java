package com.example.vnptemployeemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDepartment:
                break;
            case R.id.btnProfile:
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                break;
            case R.id.btnNotice:
                break;
            case R.id.btnEmployee:
                startActivity(new Intent(HomeActivity.this, EmployeeInfoActivity.class));
                break;
            default:
                break;
        }
    }
}