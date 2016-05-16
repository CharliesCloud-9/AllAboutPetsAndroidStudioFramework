package com.carlosgallegos.androidphpmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SymptomChooseDogBodyArea extends AppCompatActivity {

    TextView headNeckNose, ears, mouthTeeth, back, tail, legs, abdomen, reprodUrin, hindHips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptomchoose_dog_bodyarea);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        headNeckNose = (TextView) findViewById(R.id.dHeadNeckNose);
        ears = (TextView) findViewById(R.id.dEars);
        mouthTeeth = (TextView) findViewById(R.id.dMouthTeeth);
        back = (TextView) findViewById(R.id.dBack);
        tail = (TextView) findViewById(R.id.dTail);
        legs = (TextView) findViewById(R.id.dLegs);
        abdomen = (TextView) findViewById(R.id.dAbdomen);
        reprodUrin = (TextView) findViewById(R.id.dReprodUrin);
        hindHips = (TextView) findViewById(R.id.dHindHips);

        headNeckNose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseDogBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "dHeadNeckNose");
                startActivity(intent);
            }
        });

        ears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseDogBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "dEars");
                startActivity(intent);
            }
        });

        mouthTeeth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseDogBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "dMouthTeeth");
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseDogBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "dBack");
                startActivity(intent);
            }
        });

        tail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseDogBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "dTail");
                startActivity(intent);
            }
        });

        legs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseDogBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "dLegs");
                startActivity(intent);
            }
        });

        abdomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseDogBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "dAbdomen");
                startActivity(intent);
            }
        });

        reprodUrin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseDogBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "dReprodUrin");
                startActivity(intent);
            }
        });

        hindHips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SymptomChooseDogBodyArea.this, SymptomCheckBox.class);
                intent.putExtra("flag", "dHindHips");
                startActivity(intent);
            }
        });

    }
}
