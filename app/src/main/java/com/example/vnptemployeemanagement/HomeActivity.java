package com.example.vnptemployeemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView icBack = findViewById(R.id.ic_left);
        TextView title = findViewById(R.id.toolbarTitle);
        title.setText(getString(R.string.splash_title));
        icBack.setVisibility(View.GONE);
        icBack.setOnClickListener(
                view ->
                        onBackPressed()
        );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnOrganisation:
                startActivity(new Intent(HomeActivity.this, OrganisationActivity.class));
                break;
            case R.id.btnProfile:
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                break;
            case R.id.btnNotice:
                startActivity(new Intent(HomeActivity.this, NoticeActivity.class));
                break;
            case R.id.btnAddEmployee:
                startActivity(new Intent(HomeActivity.this, AddEmployeeActivity.class));
                break;
            default:
                break;
        }
    }
}