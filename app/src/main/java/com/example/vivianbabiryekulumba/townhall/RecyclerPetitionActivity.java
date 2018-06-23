package com.example.vivianbabiryekulumba.townhall;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.example.vivianbabiryekulumba.townhall.database.Petition;
import com.example.vivianbabiryekulumba.townhall.database.PetitionAdapter;
import com.example.vivianbabiryekulumba.townhall.database.PetitionViewModel;

public class RecyclerPetitionActivity extends AppCompatActivity {

    public static final int NEW_PETITION_ACTIVITY_REQUEST_CODE = 1;
    RecyclerView petitions_recycler;
    PetitionViewModel petitionViewModel;
    PetitionAdapter petitionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_petiton);

        petitions_recycler = findViewById(R.id.recycler_petition);
        petitionAdapter = new PetitionAdapter(this);
        petitions_recycler.setAdapter(petitionAdapter);
        petitions_recycler.setLayoutManager(new LinearLayoutManager(this));
        petitionViewModel.getAllPetitions().observe(this, petitionAdapter::setPetitionsList);
        petitionViewModel = ViewModelProviders.of(this).get(PetitionViewModel.class);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_PETITION_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Petition petition = new Petition(data.getStringExtra(NewPetitionActivity.EXTRA_REPLY));
            petitionViewModel.insert(petition);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Not saved",
                    Toast.LENGTH_LONG).show();
        }
    }
}
