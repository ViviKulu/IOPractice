package com.example.vivianbabiryekulumba.townhall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vivianbabiryekulumba.townhall.database.PetitionViewModel;

public class NewPetitionActivity extends AppCompatActivity {

    private PetitionViewModel petitionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_petition);

        final EditText title_et = findViewById(R.id.title_petit);
        final EditText petition_body_et = findViewById(R.id.body_petit);
        Button submitBtn = findViewById(R.id.submit_pet_btn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTitle = new Intent();
                if(TextUtils.isEmpty(title_et.getText())){
                    setResult(RESULT_CANCELED, intentTitle);
                }else{
                    String petition_title = title_et.getText().toString();
                    intentTitle.putExtra(Intent.EXTRA_COMPONENT_NAME, petition_title);
                    setResult(RESULT_OK, intentTitle);
                }
                Intent intent_body_et = new Intent();
                if(TextUtils.isEmpty(petition_body_et.getText())){
                    setResult(RESULT_CANCELED, intent_body_et);
                }else{
                    String petition_body = petition_body_et.getText().toString();
                    intent_body_et.putExtra(Intent.EXTRA_STREAM,petition_body);
                    setResult(RESULT_OK, intent_body_et);
                }
                finish();
            }
        });

    }
}
