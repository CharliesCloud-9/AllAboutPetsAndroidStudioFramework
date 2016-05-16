package com.carlosgallegos.androidphpmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Tab3SymptomChecker extends AppCompatActivity implements View.OnClickListener{

    ImageButton catButtonObj;
    ImageButton dogButtonObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3_symptomchecker);

        catButtonObj = (ImageButton) findViewById(R.id.catButton);
        dogButtonObj = (ImageButton) findViewById(R.id.dogButton);

        catButtonObj.setOnClickListener(this);
        dogButtonObj.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.catButton) {
            Intent intent = new Intent(Tab3SymptomChecker.this, SymptomChooseCatBodyArea.class);
            intent.putExtra("flag", "catButton");
            startActivity(intent);
        } else if (v.getId() == R.id.dogButton) {
            Intent intent = new Intent(Tab3SymptomChecker.this, SymptomChooseDogBodyArea.class);
            intent.putExtra("flag", "dogButton");
            startActivity(intent);
        }

       /* switch (v.getId()) {
            case R.id.catButton:

                Intent intent = new Intent(Tab3SymptomChecker.this, SymptomChooseCatBodyArea.class);
                intent.putExtra("flag", "catButton");
                startActivity(intent);
                break;
            case R.id.dogButton:
                Intent intent1 = new Intent(Tab3SymptomChecker.this, SymptomChooseCatBodyArea.class);
                intent1.putExtra("flag", "dogButton");
                startActivity(intent1);
                break;

        } */
    }
}
