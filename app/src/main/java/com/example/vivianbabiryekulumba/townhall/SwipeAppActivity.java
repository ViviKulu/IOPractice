package com.example.vivianbabiryekulumba.townhall;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vivianbabiryekulumba.townhall.appRecyclerView.AppAdapter;
import com.example.vivianbabiryekulumba.townhall.appRecyclerView.ApplicationNetworkService;
import com.example.vivianbabiryekulumba.townhall.appRecyclerView.ApplicationPOJO;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SwipeAppActivity extends AppCompatActivity {

    private static final String TAG = "SwipeAppActivity";
    private ArrayList<ApplicationPOJO> applicationDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_petition);

        Context context = getApplicationContext();
        RecyclerView recyclerView = findViewById(R.id.swipe_app_rec_view);
        Button subBtn = findViewById(R.id.sub_btn);
        Button seeBtn = findViewById(R.id.see_btn);

        subBtn.setText(R.string.submitPet);
        seeBtn.setText(R.string.seeApps);

        AppAdapter appAdapter = new AppAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(appAdapter);

        Retrofit retrofit = new Retrofit.Builder()
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
                    Log.d(TAG, "onResponse: success" + applicationDataList.size());
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
                Intent intent = new Intent(SwipeAppActivity.this, NewPetitionActivity.class);
                startActivity(intent);
            }
        });

        seeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Still under construction, will be up and running soon, I promise!"
                        , Toast.LENGTH_LONG).show();
            }
        });

    }
}
