package com.example.vivianbabiryekulumba.townhall.cardswipe;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vivianbabiryekulumba on 7/8/18.
 */

public class RetrofitClient {

    public static Retrofit getClient() {
        return new Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
