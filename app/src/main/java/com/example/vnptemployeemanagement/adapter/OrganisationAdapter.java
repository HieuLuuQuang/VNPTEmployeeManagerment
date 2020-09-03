package com.example.vnptemployeemanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vnptemployeemanagement.R;
import com.example.vnptemployeemanagement.models.Organisation;

import java.util.List;


public class OrganisationAdapter extends RecyclerView.Adapter<OrganisationAdapter.OrganisationViewHolder>{

    Context context;
    class OrganisationViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvOrganisation;
        private final ListView listviewDepartment;
        private final RelativeLayout layoutOrganisation;
        private final ImageView ivArrowDown;

        private OrganisationViewHolder(View itemView) {
            super(itemView);
            tvOrganisation = itemView.findViewById(R.id.tvOrganisation);
            listviewDepartment = itemView.findViewById(R.id.listviewDepartment);
            layoutOrganisation = itemView.findViewById(R.id.layoutOrganisation);
            ivArrowDown = itemView.findViewById(R.id.ivArrowDown);
        }
    }

    private final LayoutInflater mInflater;
    private List<Organisation> organisationList; // Cached copy of words

    public OrganisationAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public OrganisationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.organisation_recyclerview_item, parent, false);
        return new OrganisationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OrganisationViewHolder holder, int position) {
        if (organisationList != null) {
            Organisation organisation = organisationList.get(position);
           holder.tvOrganisation.setText(organisation.getOrganisationName());
        } else {
            holder.tvOrganisation.setText("No name");
        }
        holder.layoutOrganisation.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isVisible = holder.listviewDepartment.getVisibility() == View.VISIBLE;
                    holder.ivArrowDown.setVisibility(isVisible ? View.VISIBLE : View.GONE);
                    holder.listviewDepartment.setVisibility(isVisible ? View.GONE : View.VISIBLE);
                    Organisation organisation = organisationList.get(position);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String> ( context, R.layout.simple_list_item, organisation.getAllDepartmentName());
                    holder.listviewDepartment.setAdapter(adapter);
                    setLayoutListView(holder.listviewDepartment, adapter);
                }
            }
        );
    }

    public void setLayoutListView(ListView listView, ArrayAdapter<String> adapter ) {
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < adapter.getCount(); i++) {
            view = adapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    public void setOrganisations(List<Organisation> organisations, Context context) {
        organisationList = organisations;
        this.context = context;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (organisationList != null)
            return organisationList.size();
        else return 0;
    }
}


