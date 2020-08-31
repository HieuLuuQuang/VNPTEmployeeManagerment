package com.example.vnptemployeemanagement;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ProfileActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();
    ImageView imgEdit;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_layout);
        Toast.makeText(getApplicationContext(), "Profile activity", Toast.LENGTH_SHORT).show();
        ImageView icBack = findViewById(R.id.ic_left);
        icBack.setOnClickListener(
                view ->
                        onBackPressed()
        );
        ProfileFragment profileFragment = new ProfileFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.imployee_fragment, profileFragment);
        fragmentTransaction.addToBackStack(profileFragment.getTag()).commit();
        imgEdit = findViewById(R.id.buttonEdit);
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
        switch (view.getId()){
            case R.id.buttonEdit:
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.imployee_fragment, new ProfileEditFragment());
                fragmentTransaction.commit();
                break;

        }
    }

    @Override
    public void onBackPressed(){
        if (fragmentManager.getBackStackEntryCount() > 0) {
           // Log.i("MainActivity", "popping backstack");
            fragmentManager.popBackStack();
        } else {
          //  Log.i("MainActivity", "nothing on backstack, calling super");
            super.onBackPressed();
        }
    }
}
