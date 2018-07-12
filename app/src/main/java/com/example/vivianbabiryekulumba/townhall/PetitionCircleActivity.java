package com.example.vivianbabiryekulumba.townhall;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.vivianbabiryekulumba.townhall.petitionRecyclerView.AppAdapter;
import com.example.vivianbabiryekulumba.townhall.petitionRecyclerView.ApplicationNetworkService;
import com.example.vivianbabiryekulumba.townhall.petitionRecyclerView.ApplicationPOJO;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PetitionCircleActivity extends AppCompatActivity {

    private static final String TAG = "PetitionCircleActivity";
    private ArrayList<ApplicationPOJO> applicationDataList;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_petition);

        RecyclerView recyclerView = findViewById(R.id.swipe_app_rec_view);
        Button subBtn = findViewById(R.id.sub_btn);
        Button seeBtn = findViewById(R.id.see_btn);

        subBtn.setText(R.string.submitPet);
        seeBtn.setText(R.string.seeApps);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApplicationNetworkService applicationNetworkService = retrofit.create(ApplicationNetworkService.class);

        Call<ArrayList<ApplicationPOJO>> swipeCardCall = applicationNetworkService.getApplication();
        swipeCardCall.enqueue(new Callback<ArrayList<ApplicationPOJO>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<ApplicationPOJO>> call, @NonNull Response<ArrayList<ApplicationPOJO>> response) {
                if(response.isSuccessful()){
                    applicationDataList = response.body();
                    Log.d(TAG, "onResponse: " + applicationDataList.size());
                    AppAdapter appAdapter = new AppAdapter(applicationDataList);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(appAdapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<ApplicationPOJO>> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PetitionCircleActivity.this, NewPetitionActivity.class);
                startActivity(intent);
            }
        });

        seeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSee = new Intent(PetitionCircleActivity.this, RecyclerPetitionActivity.class);
                startActivity(intentSee);
//                Toast.makeText(getApplicationContext(), "Still under construction, will be up and running soon, I promise!"
//                        , Toast.LENGTH_LONG).show();
            }
        });

    }
}
