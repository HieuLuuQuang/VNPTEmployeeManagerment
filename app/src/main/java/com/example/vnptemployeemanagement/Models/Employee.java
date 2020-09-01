package com.example.vnptemployeemanagement.Models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "employee_table")
public class Employee {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "birthDay")
    String birthDay;

    @NonNull
    @ColumnInfo(name = "organisation")
    String organisation;

    @NonNull
    @ColumnInfo(name = "department")
    String department;

    @NonNull
    @ColumnInfo(name = "gender")
    String gender;

    @NonNull
    @ColumnInfo(name = "position")
    String position;

    @NonNull
    @ColumnInfo(name = "status")
    String status;

    @NonNull
    @ColumnInfo(name = "phone")
    String phone;

    @NonNull
    @ColumnInfo(name = "mail")
    String mail;

    @NonNull
    @ColumnInfo(name = "address")
    String address;

    public Employee(){

    }

    public Employee(String name, String birthDay, String organisation, String department, String gender, String position, String status, String phone, String eMail, String address) {
        this.name = name;
        this.birthDay = birthDay;
        this.organisation = organisation;
        this.department = department;
        this.gender = gender;
        this.position = position;
        this.status = status;
        this.phone = phone;
        this.mail  = eMail;
        this.address = address;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(@NonNull String birthDay) {
        this.birthDay = birthDay;
    }

    @NonNull
    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(@NonNull String organisation) {
        this.organisation = organisation;
    }

    @NonNull
    public String getDepartment() {
        return department;
    }

    public void setDepartment(@NonNull String department) {
        this.department = department;
    }

    @NonNull
    public String getGender() {
        return gender;
    }

    public void setGender(@NonNull String gender) {
        this.gender = gender;
    }

    @NonNull
    public String getPosition() {
        return position;
    }

    public void setPosition(@NonNull String position) {
        this.position = position;
    }

    @NonNull
    public String getStatus() {
        return status;
    }

    public void setStatus(@NonNull String status) {
        this.status = status;
    }

    @NonNull
    public String getPhone() {
        return phone;
    }

    public void setPhone(@NonNull String phone) {
        this.phone = phone;
    }

    public void setMail(@NonNull String mail) {
        this.mail = mail;
    }

    @NonNull
    public String getMail() {
        return mail;
    }


    @NonNull
    public String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }
}
