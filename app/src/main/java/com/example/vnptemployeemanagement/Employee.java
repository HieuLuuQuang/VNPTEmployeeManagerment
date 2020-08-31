package com.example.vnptemployeemanagement;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "employee_table")
public class Employee {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "employee")
    private String mWord;

    public Employee(@NonNull String word) {
        this.mWord = word;
    }

    @NonNull
    public String getWord() {
        return this.mWord;
    }
}
