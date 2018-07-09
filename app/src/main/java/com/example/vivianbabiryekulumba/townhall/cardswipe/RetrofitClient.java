package com.example.vivianbabiryekulumba.townhall.cardswipe;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by vivianbabiryekulumba on 7/9/18.
 */

public class RetrofitClient {

    public static List<ApplicationPOJO> loadApplications(){
        List<ApplicationPOJO> applicationList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApplicationNetworkService applicationNetworkService = retrofit.create(ApplicationNetworkService.class);
        applicationNetworkService.getApplication();
        Log.d(TAG, "loadApplications: ran");
        return applicationList;
    }
}
