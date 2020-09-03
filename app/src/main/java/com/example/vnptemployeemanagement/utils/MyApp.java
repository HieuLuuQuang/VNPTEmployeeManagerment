package com.example.vnptemployeemanagement.utils;

import com.example.vnptemployeemanagement.models.Department;
import com.example.vnptemployeemanagement.models.Employee;
import com.example.vnptemployeemanagement.models.Organisation;

import java.util.ArrayList;
import java.util.List;

public class MyApp {
    public static List<Organisation> mAllOrganisations;
    public static List<Employee> mAllEmployees;
    public static void setOrganisation(){
        mAllOrganisations = new ArrayList<>();
        List<Department> listSWDepartment = new ArrayList<>();
        listSWDepartment.add(new Department("Team mobile"));
        listSWDepartment.add(new Department("Team IOS"));
        listSWDepartment.add(new Department("Team Web"));
        listSWDepartment.add(new Department("Team QA"));
        listSWDepartment.add(new Department("Team Tester"));

        mAllOrganisations.add(new Organisation("VNPT Software Hanoi", listSWDepartment));
        mAllOrganisations.add(new Organisation("VNPT Software HoChiMinh", listSWDepartment));
        mAllOrganisations.add(new Organisation("VNPT Software Danang", listSWDepartment));

        List<Department> listFinancialDepartment = new ArrayList<>();
        listFinancialDepartment.add(new Department("Phòng kế toán"));
        listFinancialDepartment.add(new Department("Phòng bán hàng"));
        listFinancialDepartment.add(new Department("Phòng chăm sóc khách hàng"));
        listFinancialDepartment.add(new Department("Phòng audit"));

        mAllOrganisations.add(new Organisation("VNPT Financial Hanoi", listFinancialDepartment));
        mAllOrganisations.add(new Organisation("VNPT Financial HoChiMinh", listFinancialDepartment));
        mAllOrganisations.add(new Organisation("VNPT Financial Danang", listFinancialDepartment));

        List<Department> listTelecomDepartment = new ArrayList<>();
        listTelecomDepartment.add(new Department("Phòng kỹ thuật"));
        listTelecomDepartment.add(new Department("Phòng Giám đốc"));
        listTelecomDepartment.add(new Department("Phòng Nhân sự"));
        listTelecomDepartment.add(new Department("Phòng Server"));

        mAllOrganisations.add(new Organisation("VNPT Telecom Hanoi", listTelecomDepartment));
        mAllOrganisations.add(new Organisation("VNPT Telecom HoChiMinh", listTelecomDepartment));
        mAllOrganisations.add(new Organisation("VNPT Telecom Danang", listTelecomDepartment));
    }
}
