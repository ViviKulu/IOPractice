package com.example.vivianbabiryekulumba.townhall.cardswipe;

import com.example.vivianbabiryekulumba.townhall.database.Petition;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vivianbabiryekulumba on 7/7/18.
 */

public interface ApplicationNetworkService {

    @GET("resource/qjpa-k6a2.json")
    Call<ApplicationPOJO> getApplication();
}
