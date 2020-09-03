package com.example.vnptemployeemanagement.views.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.vnptemployeemanagement.R;
import com.example.vnptemployeemanagement.models.Employee;
import com.example.vnptemployeemanagement.utils.Keys;

public class ProfileFragment extends Fragment {
    Employee employee;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        bundle = getArguments();
        if (bundle != null) {
            String title = bundle.getString(Keys.APP_TITLE);
            TextView tvTitle = getActivity().findViewById(R.id.toolbarTitle);
            tvTitle.setText(title);
            employee = bundle.getParcelable(Keys.VIEW_PROFILE);
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView avatar = (ImageView)view.findViewById(R.id.avatar);
        TextView tvName = (TextView)view.findViewById(R.id.tvName);
        TextView tvTitleName = (TextView)view.findViewById(R.id.tvTitleName);
        TextView tvBirthday = (TextView)view.findViewById(R.id.tvBirthday);
        TextView tvDepartment = (TextView)view.findViewById(R.id.tvDepartment);
        TextView tvGender = (TextView)view.findViewById(R.id.tvGender);
        TextView tvJob = (TextView)view.findViewById(R.id.tvJob);
        TextView tvEmail = (TextView)view.findViewById(R.id.tvEmail);
        TextView tvAdd = (TextView)view.findViewById(R.id.tvAdd);
        avatar.setBackgroundResource(employee.getGender().equals(getString(R.string.female)) ? R.drawable.female_avatar : R.drawable.ic_avatar);
        tvName.setText(employee.getName());
        tvTitleName.setText(employee.getName());
        tvBirthday.setText(employee.getBirthDay());
        tvDepartment.setText(employee.getDepartment());
        tvGender.setText(employee.getGender());
        tvJob.setText(employee.getPosition());
        tvEmail.setText(employee.getMail());
        tvAdd.setText(employee.getAddress());
        tvEmail.setText(employee.getMail());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
