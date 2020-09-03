package com.example.vnptemployeemanagement.views.employees;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.vnptemployeemanagement.Interface.IAddNewEmployeeListener;
import com.example.vnptemployeemanagement.R;
import com.example.vnptemployeemanagement.models.Employee;
import com.example.vnptemployeemanagement.utils.Keys;

public class EmployeesActivity extends AppCompatActivity  implements IAddNewEmployeeListener {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;
    private EmployeeViewModel mEmployeeViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_list_activity);
 /*       ImageView icBack = findViewById(R.id.ic_left);
        icBack.setOnClickListener(
                view ->
                        onBackPressed()
        );*/
        addEmployeeListFragment();
    }

    @Override
    protected void onResume() {
        super.onResume();
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

    public void addEmployeeListFragment() {
        EmployeesListFragment employeesListFragment = new EmployeesListFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Keys.APP_TITLE, getString(R.string.employee_list));
        employeesListFragment.setArguments(bundle);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayoutEmployee, employeesListFragment);
        fragmentTransaction.addToBackStack(employeesListFragment.getClass().getName());
        fragmentTransaction.commit();
    }

    @Override
    public void onAddViewEmployee(boolean isAdd, Employee employee) {
        if(isAdd) {
            EmployeeEditFragment employeesFragment = new EmployeeEditFragment();
            Bundle bundle = new Bundle();
            bundle.putString(Keys.APP_TITLE, getString(R.string.add_employee));
            bundle.putBoolean(Keys.ADD_EMPLOYEE, true);
            employeesFragment.setArguments(bundle);
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.framelayoutEmployee, employeesFragment);
            fragmentTransaction.addToBackStack(employeesFragment.getClass().getName());
            fragmentTransaction.commit();
        }

    }
}
