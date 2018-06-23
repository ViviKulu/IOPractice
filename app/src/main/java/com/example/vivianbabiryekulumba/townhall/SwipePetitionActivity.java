package com.example.vivianbabiryekulumba.townhall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

public class SwipePetitionActivity extends AppCompatActivity {

    CardView cardView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_petition);
        cardView1 = findViewById(R.id.card_swipe);
    }
}
