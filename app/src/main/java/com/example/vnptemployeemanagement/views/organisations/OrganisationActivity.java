package com.example.vnptemployeemanagement.views.organisations;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.vnptemployeemanagement.R;
import com.example.vnptemployeemanagement.utils.Keys;

public class OrganisationActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organisation_list_activity);
        addEmployeeListFragment();
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

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.ic_left:
                onBackPressed();
                break;
            default:
                break;
        }
    }

    public void addEmployeeListFragment() {
        OrganisationsFragment organisationsFragment = new OrganisationsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Keys.APP_TITLE, getString(R.string.employee_list));
        organisationsFragment.setArguments(bundle);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayoutOrganisation, organisationsFragment);
        fragmentTransaction.addToBackStack(organisationsFragment.getClass().getName());
        fragmentTransaction.commit();
    }
}
