package com.example.vivianbabiryekulumba.townhall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.textservice.SpellCheckerSession;
import android.widget.Button;
import android.widget.EditText;

public class NewPetitionActivity extends AppCompatActivity{

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_petition);

        EditText petition_body_et = findViewById(R.id.type_petition);
        final Button submitBtn = findViewById(R.id.button_save);

        submitBtn.setOnClickListener(v -> {
            Intent intent_body_et = new Intent();
            if(TextUtils.isEmpty(petition_body_et.getText())){
                setResult(RESULT_CANCELED, intent_body_et);
            }else{
                String petition_body = petition_body_et.getText().toString();
                intent_body_et.putExtra(EXTRA_REPLY,petition_body);
                setResult(RESULT_OK, intent_body_et);
            }
            finish();
        });

    }
}
