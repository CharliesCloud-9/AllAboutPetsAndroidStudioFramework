package com.carlosgallegos.androidphpmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SymptomChecker extends AppCompatActivity implements View.OnClickListener{

    ImageButton catButtonObj;
    ImageButton dogButtonObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_checker);

        catButtonObj = (ImageButton) findViewById(R.id.catButton);
        dogButtonObj = (ImageButton) findViewById(R.id.dogButton);

        catButtonObj.setOnClickListener(this);
        dogButtonObj.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.catButton:

                startActivity(new Intent(this, ExpListViewDictCat.class));
                break;

            case R.id.dogButton:

                startActivity(new Intent(this, ExpListViewDictDog.class));
                break;

        }
    }
}
