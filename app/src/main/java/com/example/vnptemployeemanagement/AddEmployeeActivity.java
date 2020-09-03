package com.example.vnptemployeemanagement;

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
        TextView title = findViewById(R.id.toolbarTitle);
        title.setText(getString(R.string.add_employee));
        EmployeeEditFragment profileFragment = new EmployeeEditFragment();

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
            case R.id.ic_left:
                onBackPressed();
            default:
                break;
        }
    }
}