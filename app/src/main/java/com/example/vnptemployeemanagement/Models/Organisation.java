package com.example.vnptemployeemanagement.Models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "employee_organisation")
public class Organisation {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "organisationName")
    private String organisationName;

    @NonNull
    @ColumnInfo(name = "departments")
    List<Department> departments;

    Organisation(String organisationName, List<Department> departments) {
        this.organisationName = organisationName;
        this.departments = departments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(@NonNull String organisationName) {
        this.organisationName = organisationName;
    }

    @NonNull
    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(@NonNull List<Department> departments) {
        this.departments = departments;
    }
}
