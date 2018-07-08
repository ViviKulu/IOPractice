package com.example.vivianbabiryekulumba.townhall.cardswipe;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vivianbabiryekulumba on 7/1/18.
 */

public class ApplicationPOJO {

    @SerializedName("client_agency")
    @Expose
    private String clientAgency;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("division")
    @Expose
    private String division;
    @SerializedName("dollar_amount")
    @Expose
    private String dollarAmount;
    @SerializedName("phase")
    @Expose
    private String phase;
    @SerializedName("project_id")
    @Expose
    private String projectId;
    @SerializedName("projected_construction_completion")
    @Expose
    private String projectedConstructionCompletion;
    @SerializedName("scope")
    @Expose
    private String scope;
    @SerializedName("status")
    @Expose
    private String status;

    public String getClientAgency() {
        return clientAgency;
    }

    public void setClientAgency(String clientAgency) {
        this.clientAgency = clientAgency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDollarAmount() {
        return dollarAmount;
    }

    public void setDollarAmount(String dollarAmount) {
        this.dollarAmount = dollarAmount;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectedConstructionCompletion() {
        return projectedConstructionCompletion;
    }

    public void setProjectedConstructionCompletion(String projectedConstructionCompletion) {
        this.projectedConstructionCompletion = projectedConstructionCompletion;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
