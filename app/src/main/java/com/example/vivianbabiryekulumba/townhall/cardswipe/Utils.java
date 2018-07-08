package com.example.vivianbabiryekulumba.townhall.cardswipe;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vivianbabiryekulumba on 7/7/18.
 */

public class Utils{

    public static ApplicationNetworkService getNetworkService(){
        return RetrofitClient.getClient().create(ApplicationNetworkService.class);
    }
}
