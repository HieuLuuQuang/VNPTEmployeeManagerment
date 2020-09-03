package com.example.vnptemployeemanagement.views.employees;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.vnptemployeemanagement.R;
import com.example.vnptemployeemanagement.models.Employee;
import com.example.vnptemployeemanagement.utils.Keys;

public class EmployeeEditFragment extends Fragment implements View.OnClickListener{
    EditText name;
    EditText birthday;
    Spinner spinnerOrganisation;
    Spinner spinnerDepartment;
    RadioGroup rgGender;
    RadioButton female;
    RadioButton male;
    EditText position;
    EditText phone;
    EditText email;
    EditText address;
    private EmployeeViewModel mEmployeeViewModel;
    boolean isAddEmployee = false;
    String selectedOrg = "";
    boolean isMale = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        View view = inflater.inflate(R.layout.profile_edit_fragment, container, false);
        bundle = getArguments();
        if (bundle != null) {
            String title = bundle.getString(Keys.APP_TITLE);
            isAddEmployee = bundle.getBoolean(Keys.ADD_EMPLOYEE);
            TextView tvTitle = getActivity().findViewById(R.id.toolbarTitle);
            tvTitle.setText(title);
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btnSubmit).setOnClickListener(this);
        name = (EditText) view.findViewById(R.id.tvName);
        birthday = (EditText) getActivity().findViewById(R.id.tvBirthday);
        spinnerOrganisation = (Spinner) getActivity().findViewById(R.id.spinnerOrganisation);
        spinnerDepartment = (Spinner) getActivity().findViewById(R.id.tvDepartment);
        rgGender = (RadioGroup)view.findViewById(R.id.rgGender);
        position = (EditText) getActivity().findViewById(R.id.tvJob);
        phone = (EditText) getActivity().findViewById(R.id.tvPhone);
        email = (EditText) getActivity().findViewById(R.id.tvEmail);
        address = (EditText) getActivity().findViewById(R.id.tvAdd);
        female = (RadioButton)getActivity().findViewById(R.id.radioButton_female);
        male = (RadioButton)getActivity().findViewById(R.id.radioButton_male);
        female.setOnClickListener(this);
        male.setOnClickListener(this);
        mEmployeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);

        ArrayAdapter<String> orgAdapter = new ArrayAdapter<String>(getContext(), R.layout.simple_list_item, mEmployeeViewModel.getAllOrganisationsName());
        spinnerOrganisation.setAdapter(orgAdapter);
        selectedOrg = spinnerOrganisation.getSelectedItem().toString();
        spinnerOrganisation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View selectedItemView, int position, long id) {
                selectedOrg = adapterView.getItemAtPosition(position).toString();
                ArrayAdapter<String> deptAdapter = new ArrayAdapter<String>(getContext(), R.layout.simple_list_item, mEmployeeViewModel.getCorrespondingDepartment(selectedOrg));
                spinnerDepartment.setAdapter(deptAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        ArrayAdapter<String> deptAdapter = new ArrayAdapter<String>(getContext(), R.layout.simple_list_item, mEmployeeViewModel.getCorrespondingDepartment(selectedOrg));
        spinnerDepartment.setAdapter(deptAdapter);

    }

    public void updateEmployee() {
        boolean isValid = true;
        if (name.getText().toString().trim().isEmpty()) {
            name.setError("Nhập tên");
            isValid = false;
        }
        if (birthday.getText().toString().trim().isEmpty()) {
            birthday.setError("Nhập ngày sinh");
            isValid = false;
        }
        if (position.getText().toString().trim().isEmpty()) {
            position.setError("Nhập vị trí");
            isValid = false;
        }
        if (phone.getText().toString().trim().isEmpty()) {
            phone.setError("Nhập đố điện thoại");
            isValid = false;
        }
        if (email.getText().toString().trim().isEmpty()) {
            email.setError("Nhập email");
            isValid = false;
        }
        if (address.getText().toString().trim().isEmpty()) {
            address.setError("Nhập địa chỉ");
            isValid = false;
        }

        if (isValid) {
            Employee employee = new Employee();
            employee.setName(name.getText().toString());
            employee.setBirthDay(birthday.getText().toString());
            employee.setOrganisation(selectedOrg);
            employee.setDepartment(spinnerDepartment.getSelectedItem().toString());
            employee.setPosition(position.getText().toString());
            employee.setGender(isMale ? getString(R.string.male) : getString(R.string.female));
            employee.setPhone(phone.getText().toString());
            employee.setMail(email.getText().toString());
            employee.setAddress(address.getText().toString());

            if (isAddEmployee) {
                mEmployeeViewModel.insert(employee);
                getActivity().onBackPressed();
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSubmit:
                updateEmployee();
                break;
            case R.id.radioButton_male:
                isMale = true;
                break;
            case R.id.radioButton_female:
                isMale = false;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
