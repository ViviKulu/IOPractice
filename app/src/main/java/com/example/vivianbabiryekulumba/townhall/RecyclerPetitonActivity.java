package com.example.vivianbabiryekulumba.townhall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.vivianbabiryekulumba.townhall.database.PetitionAdapter;

public class RecyclerPetitonActivity extends AppCompatActivity {

    RecyclerView petitions_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_petiton);

        petitions_recycler = findViewById(R.id.recycler_petition);
        PetitionAdapter petitionAdapter = new PetitionAdapter(this);
        petitions_recycler.setAdapter(petitionAdapter);
        petitions_recycler.setLayoutManager(new LinearLayoutManager(this));

    }
}
