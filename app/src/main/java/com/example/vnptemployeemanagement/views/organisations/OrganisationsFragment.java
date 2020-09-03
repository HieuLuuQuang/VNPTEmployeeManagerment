package com.example.vnptemployeemanagement.views.organisations;

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

import com.example.vnptemployeemanagement.Interface.IAddNewEmployeeListener;
import com.example.vnptemployeemanagement.R;
import com.example.vnptemployeemanagement.adapter.EmployeeListAdapter;
import com.example.vnptemployeemanagement.adapter.OrganisationAdapter;
import com.example.vnptemployeemanagement.models.Employee;
import com.example.vnptemployeemanagement.views.employees.EmployeeViewModel;
import com.example.vnptemployeemanagement.views.employees.EmployeesActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class OrganisationsFragment extends Fragment {
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private EmployeeViewModel mEmployeeViewModel;
    IAddNewEmployeeListener iAddNewEmployeeListener;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        View view = inflater.inflate(R.layout.list_organisation_fragment, container, false);


        TextView tvTitle = getActivity().findViewById(R.id.toolbarTitle);
        tvTitle.setText(getString(R.string.organisation_list));
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.rcvOrganisation);
        final OrganisationAdapter adapter = new OrganisationAdapter(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mEmployeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);
        adapter.setOrganisations(mEmployeeViewModel.getAllOrganisations(), getContext());
    }

}
