package com.example.vnptemployeemanagement.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vnptemployeemanagement.models.Employee;
import com.example.vnptemployeemanagement.R;
import com.example.vnptemployeemanagement.utils.Keys;
import com.example.vnptemployeemanagement.views.employees.EmployeesActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.security.spec.KeySpec;
import java.util.List;


public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder>{

    Context context;

    class EmployeeViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvName;
        private final TextView tvPosition;
        private final TextView tvEmail;
        private final ImageView ivAvatar;

        private EmployeeViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPosition = itemView.findViewById(R.id.tvPosition);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            ivAvatar = itemView.findViewById(R.id.ivAvatar);
            itemView.setOnClickListener((View v) -> {
                iOnItemClickListener.onItemClicked(mEmployees.get(getAdapterPosition()), Keys.VIEW_PROFILE);
            });
            itemView.setOnLongClickListener((view) ->
            {
                View dialogView = mInflater.inflate(R.layout.bottom_sheet_layout, null);
                BottomSheetDialog dialog = new BottomSheetDialog(context);
                dialogView.findViewById(R.id.ivEdit).setOnClickListener((View v) -> {
                    // do something here
                    iOnItemClickListener.onItemClicked(mEmployees.get(getAdapterPosition()), Keys.EDIT_PROFILE);
                    dialog.dismiss();
                });;
                dialogView.findViewById(R.id.ivDelete).setOnClickListener((View v) -> {
                    iOnItemClickListener.onItemClicked(mEmployees.get(getAdapterPosition()), Keys.DELETE_PROFILE);
                    dialog.dismiss();
                });;
                dialog.setContentView(dialogView);
                dialog.show();
                return true;
            });
        }
    }

    public interface IOnItemClickListener {
        void onItemClicked(Employee employee, String type);
    }
    private final LayoutInflater mInflater;
    private List<Employee> mEmployees;
    IOnItemClickListener iOnItemClickListener;

    public EmployeeListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.employee_recyclerview_item, parent, false);
        return new EmployeeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, int position) {
        if (mEmployees != null) {
            Employee curentEmployee = mEmployees.get(position);
            holder.tvName.setText(curentEmployee.getName());
            if(curentEmployee.getGender().equals(context.getString(R.string.female)))
                holder.ivAvatar.setBackgroundResource(R.drawable.female_avatar);
            else
                holder.ivAvatar.setBackgroundResource(R.drawable.ic_avatar);
            holder.tvPosition.setText(curentEmployee.getPosition());
            holder.tvEmail.setText(curentEmployee.getMail());
        } else {
            holder.tvName.setText("No Word");
        }
    }

    public void setEmployees(List<Employee> employees, Context context) {
        this.context = context;
        mEmployees = employees;
        iOnItemClickListener = (EmployeesActivity)context;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mEmployees != null)
            return mEmployees.size();
        else return 0;
    }
}


