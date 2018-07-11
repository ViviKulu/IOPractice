package com.example.vivianbabiryekulumba.townhall.appRecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.townhall.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by vivianbabiryekulumba on 7/9/18.
 */

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppViewHolder> {
    private ArrayList<ApplicationPOJO> applicationDataList;

    public AppAdapter(ArrayList<ApplicationPOJO> applicationDataList) {
        this.applicationDataList = applicationDataList;
    }

    @NonNull
    @Override
    public AppAdapter.AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_card_item_view, parent, false);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppAdapter.AppViewHolder holder, int position) {
        holder.onBind(applicationDataList.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + applicationDataList.size());
        return applicationDataList.size();
    }

    public class AppViewHolder extends RecyclerView.ViewHolder{


        private TextView client_agency;
        private TextView description;
        private TextView dollar_amount;
        private TextView phase;
        private TextView project_id;
        private TextView scope;
        private TextView status;

        public AppViewHolder(View itemView) {
            super(itemView);

            client_agency = itemView.findViewById(R.id.client_agency_tv);
            description = itemView.findViewById(R.id.description_tv);
            dollar_amount = itemView.findViewById(R.id.dollar_amount_tv);
            phase = itemView.findViewById(R.id.phase_tv);
            project_id = itemView.findViewById(R.id.project_id_tv);
            scope = itemView.findViewById(R.id.scope_tv);
            status = itemView.findViewById(R.id.status_tv);
        }

        public void onBind(ApplicationPOJO applicationPOJO) {
            client_agency.setText(applicationPOJO.getClientAgency());
            description.setText(applicationPOJO.getDescription());
            dollar_amount.setText(applicationPOJO.getDollarAmount());
            phase.setText(applicationPOJO.getPhase());
            project_id.setText(applicationPOJO.getProjectId());
            status.setText(applicationPOJO.getStatus());
        }
    }
}
