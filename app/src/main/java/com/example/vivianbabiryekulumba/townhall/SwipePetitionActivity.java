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
import com.example.vivianbabiryekulumba.townhall.cardswipe.RetrofitClient;
import com.example.vivianbabiryekulumba.townhall.cardswipe.SwipeCard;
import com.example.vivianbabiryekulumba.townhall.cardswipe.Utils;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SwipePetitionActivity extends AppCompatActivity {

    private static final String TAG = "SwipePetitionActivity";
    private SwipePlaceHolderView swipeView;
    ApplicationPOJO applicationPOJO;
    ApplicationNetworkService applicationNetworkService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_petition);

        swipeView = findViewById(R.id.swipeView);
        Context context = getApplicationContext();
        TextView see_my_pet = findViewById(R.id.see_my_pet_txt);
        TextView sub_new_pet = findViewById(R.id.sub_new_pet_txt);

        swipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.card_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.card_swipe_out_msg_view));

        applicationNetworkService = Utils.getNetworkService();

        Call<ApplicationPOJO> swipeCardCall = applicationNetworkService.getApplication();

        swipeCardCall.enqueue(new Callback<ApplicationPOJO>() {
            @Override
            public void onResponse(@NonNull Call<ApplicationPOJO> call, @NonNull Response<ApplicationPOJO> response) {
                swipeView.addView(new SwipeCard(context, applicationPOJO, swipeView));
                Log.d(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ApplicationPOJO> call, @NonNull Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });

        findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeView.doSwipe(false);
            }
        });

        findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeView.doSwipe(true);
            }
        });

        sub_new_pet.setText(R.string.submit_pet);
        see_my_pet.setText(R.string.see_pet);

    }
}
