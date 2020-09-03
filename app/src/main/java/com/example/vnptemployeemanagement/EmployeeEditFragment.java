package com.example.vnptemployeemanagement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.vnptemployeemanagement.Models.Employee;
import com.example.vnptemployeemanagement.Utils.database.Keys;

public class EmployeeEditFragment extends Fragment implements View.OnClickListener{
    EditText name;
    EditText birthday;
    EditText organisation;
    EditText department;
    RadioGroup tvGender;
    EditText position;
    EditText phone;
    EditText email;
    EditText address;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        View view = inflater.inflate(R.layout.profile_edit_fragment, container, false);
        bundle = getArguments();
        if (bundle != null) {
            String title = bundle.getString(Keys.APP_TITLE);

        TextView tvTitle = getActivity().findViewById(R.id.toolbarTitle);
        tvTitle.setText(title);
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btnSubmit).setOnClickListener(this);
        name = (EditText)view.findViewById(R.id.tvName);
        birthday = (EditText)getActivity().findViewById(R.id.tvBirthday);
        organisation = (EditText)getActivity().findViewById(R.id.tvOrganisation);
        department = (EditText)getActivity().findViewById(R.id.tvDepartment);
       // tvGender = (RadioGroup)view.findViewById(R.id.tvGender);
        position = (EditText)getActivity().findViewById(R.id.tvJob);
        phone = (EditText)getActivity().findViewById(R.id.tvPhone);
        email = (EditText)getActivity().findViewById(R.id.tvEmail);
        address = (EditText)getActivity().findViewById(R.id.tvAdd);
    }

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.btnSubmit:
                updateEmployee();
                break;
        }
    }

    public void updateEmployee() {
        boolean isValid = true;
        if(name.getText().toString().trim().isEmpty()){
            name.setError("Nhập tên");
            isValid = false;
        }
        if(birthday.getText().toString().trim().isEmpty()){
            birthday.setError("Nhập ngày sinh");
            isValid = false;
        }
        if(organisation.getText().toString().trim().isEmpty()){
            organisation.setError("Nhập đơn vị");
            isValid = false;
        }
        if(department.getText().toString().trim().isEmpty()){
            department.setError("Nhập phòng ban");
            isValid = false;
        }
        if(position.getText().toString().trim().isEmpty()){
            position.setError("Nhập vị trí");
            isValid = false;
        }
        if(phone.getText().toString().trim().isEmpty()){
            phone.setError("Nhập đố điện thoại");
            isValid = false;
        }
        if(email.getText().toString().trim().isEmpty()){
            email.setError("Nhập email");
            isValid = false;
        }
        if(address.getText().toString().trim().isEmpty()){
            address.setError("Nhập địa chỉ");
            isValid = false;
        }

        if(isValid)
        {
            Employee employee = new Employee();
            employee.setName(name.getText().toString());
            employee.setBirthDay(birthday.getText().toString());
            employee.setOrganisation(organisation.getText().toString());
            employee.setDepartment(department.getText().toString());
            employee.setPosition(department.getText().toString());
            employee.setPhone(phone.getText().toString());
            employee.setAddress(address.getText().toString());
        }
        //     tvGender = (EditText)getActivity().findViewById(R.id.tvGender);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView title = getActivity().findViewById(R.id.toolbarTitle);
    }

}
