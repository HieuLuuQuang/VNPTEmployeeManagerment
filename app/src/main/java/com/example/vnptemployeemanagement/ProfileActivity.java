package com.example.vnptemployeemanagement;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_info);
        Toast.makeText(getApplicationContext(), "Profile activity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override

    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);

    }
}
