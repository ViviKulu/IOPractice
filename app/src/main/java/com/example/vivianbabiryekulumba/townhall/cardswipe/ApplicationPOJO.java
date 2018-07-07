package com.example.vivianbabiryekulumba.townhall.cardswipe;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vivianbabiryekulumba on 7/1/18.
 */

public class ApplicationPOJO {

//    private String client_agency;
//    private String description;
//    private String division;
//    private String dollar_amount;
//    private String phase;
//    private String project_id;
//    private String projected_construction_completion;
//    private String scope;
//    private String status;

    @SerializedName("client_agency")
    public String client_agency;

    @SerializedName("description")
    public String description;

    @SerializedName("division")
    public String division;

    @SerializedName("dollar_amount")
    public String dollar_amount;

    @SerializedName("phase")
    public String phase;

    @SerializedName("project_id")
    public String project_id;

    @SerializedName("projected_construction_completion")
    public String projected_construction_completion;

    @SerializedName("scope")
    public String scope;

    @SerializedName("status")
    public String status;

    @SerializedName("applicationList")
    public List<ApplicationData> applicationList = new ArrayList<>();


    private class ApplicationData {
        @SerializedName("client_agency")
        public String client_agency;

        @SerializedName("description")
        public String description;

        @SerializedName("dollar_amount")
        public String dollar_amount;

        @SerializedName("project_id")
        public String project_id;

        @SerializedName("scope")
        public String scope;

        @SerializedName("status")
        public String status;
    }
}
