package com.example.vivianbabiryekulumba.townhall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

public class AnnouncementActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        recyclerView = findViewById(R.id.recycler_view);
        submitBtn = findViewById(R.id.submit_btn);

    }
}
