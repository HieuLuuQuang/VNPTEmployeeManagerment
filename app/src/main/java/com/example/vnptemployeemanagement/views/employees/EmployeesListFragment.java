package com.example.vnptemployeemanagement.views.employees;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vnptemployeemanagement.R;
import com.example.vnptemployeemanagement.adapter.EmployeeListAdapter;
import com.example.vnptemployeemanagement.Interface.IAddNewEmployeeListener;
import com.example.vnptemployeemanagement.models.Employee;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class EmployeesListFragment extends Fragment {

    private EmployeeViewModel mEmployeeViewModel;
    IAddNewEmployeeListener iAddNewEmployeeListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        View view = inflater.inflate(R.layout.list_employee_fragment, container, false);
/*        bundle = getArguments();
        if (bundle != null) {
            String title = bundle.getString(Keys.APP_TITLE);

        }*/

        TextView tvTitle = getActivity().findViewById(R.id.toolbarTitle);
        tvTitle.setText(getString(R.string.employee_list));
        return view;
    }

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.ic_left:
                getActivity().onBackPressed();
                break;
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            iAddNewEmployeeListener = (EmployeesActivity)context;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        final EmployeeListAdapter adapter = new EmployeeListAdapter(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mEmployeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);
        mEmployeeViewModel.getAllWords().observe(getActivity(), new Observer<List<Employee>>() {
            @Override
            public void onChanged(@Nullable final List<Employee> employees) {
                adapter.setEmployees(employees, getContext());
            }
        });

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iAddNewEmployeeListener != null)
                    iAddNewEmployeeListener.onAddViewEmployee(true, null);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
