package com.carlosgallegos.androidphpmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SymptomChooseCatBodyArea extends AppCompatActivity {

    TextView headNeckNose, ears, mouthTeeth, back, tail, legs, abdomen, reprodUrin, hindHips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptomchoose_cat_bodyarea);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        headNeckNose = (TextView)findViewById(R.id.cHeadNeckNose);
        ears = (TextView)findViewById(R.id.cEars);
        mouthTeeth = (TextView)findViewById(R.id.cMouthTeeth);
        back = (TextView)findViewById(R.id.cBack);
        tail = (TextView)findViewById(R.id.cTail);
        legs = (TextView)findViewById(R.id.cLegs);
        abdomen = (TextView)findViewById(R.id.cAbdomen);
        reprodUrin = (TextView)findViewById(R.id.cReprodUrin);
        hindHips = (TextView)findViewById(R.id.cHindHips);

        headNeckNose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "cHeadNeckNose");
                startActivity(intent);
            }
        });

        ears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "cEars");
                startActivity(intent);
            }
        });

        mouthTeeth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "cMouthTeeth");
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "cBack");
                startActivity(intent);
            }
        });

        tail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "cTail");
                startActivity(intent);
            }
        });

        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "cLegs");
                startActivity(intent);
            }
        });

        abdomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "cAbdomen");
                startActivity(intent);
            }
        });

        reprodUrin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "cReprodUrin");
                startActivity(intent);
            }
        });

        hindHips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "cHindHips");
                startActivity(intent);
            }
        });

    }
}
