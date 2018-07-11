package com.example.vivianbabiryekulumba.townhall.appRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.townhall.R;

/**
 * Created by vivianbabiryekulumba on 7/9/18.
 */

public class AppViewHolder extends RecyclerView.ViewHolder {

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

    public void bind(ApplicationPOJO applicationPOJO) {
        client_agency.setText(applicationPOJO.getClientAgency());
        description.setText(applicationPOJO.getDescription());
        dollar_amount.setText(applicationPOJO.getDollarAmount());
        phase.setText(applicationPOJO.getPhase());
        project_id.setText(applicationPOJO.getProjectId());
        scope.setText(applicationPOJO.getScope());
        status.setText(applicationPOJO.getStatus());
    }
}
