package com.example.vnptemployeemanagement.views.profile;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.vnptemployeemanagement.utils.MyApp;
import com.example.vnptemployeemanagement.views.employees.EmployeeEditFragment;
import com.example.vnptemployeemanagement.R;
import com.example.vnptemployeemanagement.utils.Keys;

public class ProfileActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();
    ImageView imgEdit;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_layout);
        addProfileFragment();
        //Toolbar toolbar = findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
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

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonEdit:
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.imployee_fragment, new EmployeeEditFragment());
                fragmentTransaction.addToBackStack(fragmentTransaction.getClass().getName());
                fragmentTransaction.commit();
                break;
            case R.id.ic_left:
                onBackPressed();
                default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() == 1) {
            finish();
        } else if (fragmentManager.getBackStackEntryCount() > 1) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    public void addProfileFragment() {
        ProfileFragment profileFragment = new ProfileFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Keys.VIEW_PROFILE, MyApp.mAllEmployees.get(0));
        profileFragment.setArguments(bundle);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.imployee_fragment, profileFragment);
        fragmentTransaction.addToBackStack(profileFragment.getClass().getName());
        fragmentTransaction.commit();
        imgEdit = findViewById(R.id.buttonEdit);
    }
}
