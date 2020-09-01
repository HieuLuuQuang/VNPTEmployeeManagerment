package com.example.vnptemployeemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vnptemployeemanagement.Adapter.EmployeeListAdapter;
import com.example.vnptemployeemanagement.Models.Employee;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class EmployeesActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private EmployeeViewModel mEmployeeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_list_activity);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final EmployeeListAdapter adapter = new EmployeeListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        mEmployeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        mEmployeeViewModel.getAllWords().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(@Nullable final List<Employee> employees) {
                // Update the cached copy of the words in the adapter.
                adapter.setEmployees(employees);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmployeesActivity.this, NewWordActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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
    }
}
