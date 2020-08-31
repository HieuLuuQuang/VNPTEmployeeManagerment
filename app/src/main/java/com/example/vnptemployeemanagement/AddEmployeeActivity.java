package com.example.vnptemployeemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class AddEmployeeActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();
    ImageView imgEdit;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_layout);
        ImageView icBack = findViewById(R.id.ic_left);
        TextView title = findViewById(R.id.toolbarTitle);
        title.setText(getString(R.string.add_employee));
        icBack.setOnClickListener(
                view ->
                        onBackPressed()
        );
        ProfileEditFragment profileFragment = new ProfileEditFragment();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.imployee_fragment, profileFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onClick(View view) {
        switch (view.getId()) {

            default:
                break;
        }
    }
}