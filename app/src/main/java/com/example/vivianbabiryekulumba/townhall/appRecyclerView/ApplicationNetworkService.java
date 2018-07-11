package com.example.vivianbabiryekulumba.townhall.appRecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vivianbabiryekulumba on 7/7/18.
 */

public interface ApplicationNetworkService {

    @GET("resource/qjpa-k6a2.json")
    Call<ArrayList<ApplicationPOJO>> getApplication();
}
