package com.example.vnptemployeemanagement.repository;

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

import androidx.lifecycle.LiveData;

import com.example.vnptemployeemanagement.models.Employee;
import com.example.vnptemployeemanagement.database.EmployeeRoomDatabase;
import com.example.vnptemployeemanagement.database.dao.EmployeeDao;
import com.example.vnptemployeemanagement.models.Organisation;
import com.example.vnptemployeemanagement.utils.MyApp;

import java.util.List;

import javax.crypto.interfaces.PBEKey;

public class EmployeeRepository {

    private EmployeeDao mEmployeeDao;
    private LiveData<List<Employee>> mAllEmployees;
    private List<Organisation> mAllOrganisation;


    public EmployeeRepository(Application application) {
        EmployeeRoomDatabase db = EmployeeRoomDatabase.getDatabase(application);
        mEmployeeDao = db.employeeDao();
        mAllEmployees = mEmployeeDao.getAlphabetizedWords();
        mAllOrganisation = MyApp.mAllOrganisations;
    }

    public LiveData<List<Employee>> getAllEmployees() {
        return mAllEmployees;
    }

    public List<Organisation> getAllOrganisation() {
        return mAllOrganisation;
    }

    public void insert(Employee employee) {
        EmployeeRoomDatabase.databaseWriteExecutor.execute(() -> {
            mEmployeeDao.insert(employee);
        });
    }

    public void delete(int id) {
        EmployeeRoomDatabase.databaseWriteExecutor.execute(() -> {
            mEmployeeDao.delete(id);
        });
    }

    public void update(Employee employee) {
        EmployeeRoomDatabase.databaseWriteExecutor.execute(() -> {
            mEmployeeDao.update(employee);
        });
    }
}
