package com.example.vnptemployeemanagement.views.employees;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.vnptemployeemanagement.Interface.IAddNewEmployeeListener;
import com.example.vnptemployeemanagement.R;
import com.example.vnptemployeemanagement.utils.Keys;
import com.example.vnptemployeemanagement.views.employees.AllEmployeesFragment;
import com.example.vnptemployeemanagement.views.employees.EmployeeEditFragment;

public class EmployeesActivity extends AppCompatActivity  implements IAddNewEmployeeListener {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;
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

/*    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            //Employee employee = new Employee(data.getStringExtra(NewWordActivity.EXTRA_REPLY), "hihi");
            Employee employee = new Employee(data.getStringExtra(NewWordActivity.EXTRA_REPLY), "26/11/1988","VNPT-HANOI", "Android team","Nam", "Dev","Single","0948122111","Hieu@gmail.com","Xa La Ha Dong" );
            mEmployeeViewModel.insert(employee);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Empty not saved",
                    Toast.LENGTH_LONG).show();
        }
    }*/

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
            //  Log.i("MainActivity", "nothing on backstack, calling super");
            super.onBackPressed();
        }
    }

    public void addEmployeeListFragment() {
        AllEmployeesFragment allEmployeesFragment = new AllEmployeesFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Keys.APP_TITLE, getString(R.string.employee_list));
        allEmployeesFragment.setArguments(bundle);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayoutEmployee, allEmployeesFragment);
        fragmentTransaction.addToBackStack(allEmployeesFragment.getClass().getName());
        fragmentTransaction.commit();
    }

    @Override
    public void onAddViewEmployee() {
        EmployeeEditFragment employeesFragment = new EmployeeEditFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Keys.APP_TITLE, getString(R.string.add_employee));
        employeesFragment.setArguments(bundle);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayoutEmployee, employeesFragment);
        fragmentTransaction.addToBackStack(employeesFragment.getClass().getName());
        fragmentTransaction.commit();
    }
}
