package com.example.vnptemployeemanagement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileEditFragment extends Fragment {
    TextView tvName;
    TextView tvBirthday;
    TextView tvOrganisation;
    TextView tvDepartment;
    TextView tvGender;
    TextView tvJob;
    TextView tvStatus;
    TextView tvPhone;
    TextView tvEmail;
    TextView tvAdd;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        View view = inflater.inflate(R.layout.profile_edit_fragment, container, false);
        bundle = getArguments();
        if (bundle != null) {
            String title = bundle.getString("TITLE");

        TextView tvTitle = getActivity().findViewById(R.id.toolbarTitle);
        tvTitle.setText(title);
        }

        tvName = (TextView)getActivity().findViewById(R.id.tvName);
        tvBirthday = (TextView)getActivity().findViewById(R.id.tvBirthday);
        tvOrganisation = (TextView)getActivity().findViewById(R.id.tvOrganisation);
        tvDepartment = (TextView)getActivity().findViewById(R.id.tvDepartment);
        tvGender = (TextView)getActivity().findViewById(R.id.tvGender);
        tvJob = (TextView)getActivity().findViewById(R.id.tvJob);
        tvStatus = (TextView)getActivity().findViewById(R.id.tvStatus);
        tvPhone = (TextView)getActivity().findViewById(R.id.tvPhone);
        tvEmail = (TextView)getActivity().findViewById(R.id.tvEmail);
        tvAdd = (TextView)getActivity().findViewById(R.id.tvAdd);
        return view;
    }

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.btnSubmit:
                break;

        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView title = getActivity().findViewById(R.id.toolbarTitle);
       // title.setText(getString(R.string.edit_profile));
    }
}
