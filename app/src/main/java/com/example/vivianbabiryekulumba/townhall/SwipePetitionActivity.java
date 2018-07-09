package com.example.vivianbabiryekulumba.townhall;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.townhall.cardswipe.ApplicationNetworkService;
import com.example.vivianbabiryekulumba.townhall.cardswipe.ApplicationPOJO;
import com.example.vivianbabiryekulumba.townhall.cardswipe.SwipeCard;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SwipePetitionActivity extends AppCompatActivity {

    private static final String TAG = "SwipePetitionActivity";
    private SwipePlaceHolderView swipePlaceHolderView;
    ApplicationPOJO applicationPOJO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_petition);

        swipePlaceHolderView = findViewById(R.id.swipeView);
        Context context = getApplicationContext();
        TextView see_my_pet = findViewById(R.id.see_my_pet_txt);
        TextView sub_new_pet = findViewById(R.id.sub_new_pet_txt);

        swipePlaceHolderView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.card_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.card_swipe_out_msg_view));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApplicationNetworkService applicationNetworkService = retrofit.create(ApplicationNetworkService.class);
        applicationNetworkService.getApplication();
        Log.d(TAG, "loadApplications: ran");


        Call<List<ApplicationPOJO>> swipeCardCall = applicationNetworkService.getApplication();
        swipeCardCall.enqueue(new Callback<List<ApplicationPOJO>>() {
            @Override
            public void onResponse(@NonNull Call<List<ApplicationPOJO>> call, @NonNull Response<List<ApplicationPOJO>> response) {
                swipePlaceHolderView.addView(new SwipeCard(applicationPOJO, swipePlaceHolderView));
                Log.d(TAG, "onResponse: " + swipePlaceHolderView);
                swipePlaceHolderView.removeAllViews();

            }

            @Override
            public void onFailure(@NonNull Call<List<ApplicationPOJO>> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });

//        for(int i = 0; i < swipeViewList.size(); i++){
//            return swipeViewList.get(i);
//        }

        findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipePlaceHolderView.doSwipe(false);
            }
        });

        findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipePlaceHolderView.doSwipe(true);
            }
        });

        sub_new_pet.setText(R.string.submit_pet);
        see_my_pet.setText(R.string.see_pet);

    }
}
