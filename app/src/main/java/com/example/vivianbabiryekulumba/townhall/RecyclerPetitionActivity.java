package com.example.vivianbabiryekulumba.townhall;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.vivianbabiryekulumba.townhall.database.Petition;
import com.example.vivianbabiryekulumba.townhall.database.PetitionAdapter;
import com.example.vivianbabiryekulumba.townhall.database.PetitionViewModel;

import java.util.List;

public class RecyclerPetitionActivity extends AppCompatActivity {

    public static final int NEW_PETITION_ACTIVITY_REQUEST_CODE = 1;
    PetitionViewModel petitionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_petiton);

        RecyclerView petitions_recycler = findViewById(R.id.recyclerview);
        final PetitionAdapter petitionAdapter = new PetitionAdapter(this);
        petitions_recycler.setAdapter(petitionAdapter);
        petitions_recycler.setLayoutManager(new LinearLayoutManager(this));

        petitionViewModel = ViewModelProviders.of(this).get(PetitionViewModel.class);
        petitionViewModel.getAllPetitions().observe(this, new Observer<List<Petition>>() {
            @Override
            public void onChanged(@Nullable List<Petition> petitions) {
                petitionAdapter.setPetitionsList(petitions);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerPetitionActivity.this, NewPetitionActivity.class);
                startActivityForResult(intent, NEW_PETITION_ACTIVITY_REQUEST_CODE);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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
