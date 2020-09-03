package com.example.vnptemployeemanagement.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "employee_table")
public class Department {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "departmentName")
    private String departmentName;

    public Department(){

    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(@NonNull String departmentName) {
        this.departmentName = departmentName;
    }
}
