package com.example.vnptemployeemanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vnptemployeemanagement.R;
import com.example.vnptemployeemanagement.models.Employee;

import java.util.List;


public class OrganisationAdapter extends RecyclerView.Adapter<OrganisationAdapter.EmployeeViewHolder> {

    class EmployeeViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        private EmployeeViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.tvName);
        }
    }

    private final LayoutInflater mInflater;
    private List<Employee> mEmployees; // Cached copy of words

    public OrganisationAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new EmployeeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, int position) {
        if (mEmployees != null) {
            Employee current = mEmployees.get(position);
            holder.wordItemView.setText(current.getName());
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
        }
    }

    public void setEmployees(List<Employee> employees) {
        mEmployees = employees;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mEmployees != null)
            return mEmployees.size();
        else return 0;
    }
}


