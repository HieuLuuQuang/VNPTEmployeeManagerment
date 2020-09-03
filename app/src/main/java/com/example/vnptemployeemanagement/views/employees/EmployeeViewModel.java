package com.example.vnptemployeemanagement.views.employees;

/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.vnptemployeemanagement.models.Department;
import com.example.vnptemployeemanagement.models.Employee;
import com.example.vnptemployeemanagement.models.Organisation;
import com.example.vnptemployeemanagement.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * View Model to keep a reference to the word repository and
 * an up-to-date list of all words.
 */

public class EmployeeViewModel extends AndroidViewModel {

    private EmployeeRepository mRepository;
    private LiveData<List<Employee>> mAllEmployees;
    private List<Organisation> mAllOrganisation;


    public EmployeeViewModel(Application application) {
        super(application);
        mRepository = new EmployeeRepository(application);
        mAllEmployees = mRepository.getAllEmployees();
        mAllOrganisation = mRepository.getAllOrganisation();
    }

    public LiveData<List<Employee>> getAllWords() {
        return mAllEmployees;
    }

    public List<Organisation> getAllOrganisations() {
        return mAllOrganisation;
    }

    public ArrayList<String> getAllOrganisationsName(){
        ArrayList<String> list = new ArrayList<>();
        for(Organisation organisation: mAllOrganisation){
            list.add(organisation.getOrganisationName());
        }
        return list;
    }

    public ArrayList<String> getCorrespondingDepartment(String org){
        ArrayList<String> list = new ArrayList<>();
        for(Organisation organisation: mAllOrganisation){
            if(organisation.getOrganisationName() == org){
                list.addAll(organisation.getAllDepartmentName());
            }
        }
        return list;
    }

    void insert(Employee employee) {
        mRepository.insert(employee);
    }
}
