package com.example.vivianbabiryekulumba.townhall.cardswipe;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.vivianbabiryekulumba.townhall.R;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

/**
 * Created by vivianbabiryekulumba on 7/1/18.
 */

@Layout(R.layout.swipe_card_view)
public class SwipeCard {

    @View(R.id.client_agency_tv)
    private TextView client_agency;

    @View(R.id.description_tv)
    private TextView description;

    @View(R.id.dollar_amount_tv)
    private TextView dollar_amount;

    @View(R.id.phase_tv)
    private TextView phase;

    @View(R.id.project_id_tv)
    private TextView project_id;

    @View(R.id.scope_tv)
    private TextView scope;

    @View(R.id.status_tv)
    private TextView status;

    private ApplicationPOJO applicationPOJO;
    private Context context;
    private SwipePlaceHolderView swipeView;

    public SwipeCard(Context contexts, ApplicationPOJO application, SwipePlaceHolderView swipePlaceHolderView){
        context = contexts;
        applicationPOJO = application;
        swipeView = swipePlaceHolderView;
    }

    @Resolve
    private void onResolved(){
        client_agency.setText(applicationPOJO.getClientAgency());
        description.setText(applicationPOJO.getDescription());
        dollar_amount.setText(applicationPOJO.getDollarAmount());
        phase.setText(applicationPOJO.getPhase());
        project_id.setText(applicationPOJO.getProjectId());
        scope.setText(applicationPOJO.getScope());
        status.setText(applicationPOJO.getStatus());
    }

    @SwipeOut
    private void onSwipedOut(){
        Log.d("EVENT", "onSwipedOut");
        swipeView.addView(this);
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn(){
        Log.d("EVENT", "onSwipedIn");
    }

    @SwipeInState
    private void onSwipeInState(){
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState(){
        Log.d("EVENT", "onSwipeOutState");
    }

}
