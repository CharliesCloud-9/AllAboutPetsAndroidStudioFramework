package com.carlosgallegos.androidphpmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;

public class SymptomCheckBox extends AppCompatActivity implements View.OnClickListener{

    CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_check_box);

        /*
        Intent intent = getIntent();
        String checkFlag= intent.getStringExtra("flag");
        if (checkFlag.equals("catHead/Neck/Nose") || checkFlag.equals("catEars") || checkFlag.equals("catMouth/Teeth") ||
                checkFlag.equals("catBack") || checkFlag.equals("Tab2ShelterZipCode") || checkFlag.equals("Tab2ShelterZipCode") ||
                checkFlag.equals("Tab2ShelterZipCode") || checkFlag.equals("Tab2ShelterZipCode"))
        {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        }
        */

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);


        button4 = (Button) findViewById(R.id.button44);
        button4.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        /*
        if(checkBox1.isChecked())
        {
            Intent intent = new Intent(SymptomCheckBox.this, SymptomCheckerListView.class);
            intent.putExtra("flag", "NoseBleeding");
            startActivity(intent);
        }
        else if(checkBox2.isChecked())
        {
            Intent intent = new Intent(SymptomCheckBox.this, SymptomCheckerListView.class);
            intent.putExtra("flag", "HeadGrowth");
            startActivity(intent);
        }
        else if(checkBox3.isChecked())
        {
            Intent intent = new Intent(SymptomCheckBox.this, SymptomCheckerListView.class);
            intent.putExtra("flag", "NeckAndBackPain");
            startActivity(intent);
        }
        else if(checkBox4.isChecked())
        {
            Intent intent = new Intent(SymptomCheckBox.this, SymptomCheckerListView.class);
            intent.putExtra("flag", "HeadShaking");
            startActivity(intent);
        } */


         if(checkBox1.isChecked() && checkBox2.isChecked())
        {
            Intent intent = new Intent(SymptomCheckBox.this, SymptomCheckerListView.class);
            intent.putExtra("flag", "NoseBleeding_HeadGrowth");
            startActivity(intent);
        }
            else if(checkBox1.isChecked() && checkBox3.isChecked())
            {
                Intent intent = new Intent(SymptomCheckBox.this, SymptomCheckerListView.class);
                intent.putExtra("flag", "NoseBleeding_NeckAndBackPain");
                startActivity(intent);
            }
            else if(checkBox1.isChecked() && checkBox4.isChecked())
            {
                Intent intent = new Intent(SymptomCheckBox.this, SymptomCheckerListView.class);
                intent.putExtra("flag", "NoseBleeding_HeadShaking");
                startActivity(intent);
            }


        else if(checkBox2.isChecked() && checkBox3.isChecked())
        {
            Intent intent = new Intent(SymptomCheckBox.this, SymptomCheckerListView.class);
            intent.putExtra("flag", "HeadGrowth_NeckAndBackPain");
            startActivity(intent);
        }
        else if(checkBox2.isChecked() && checkBox4.isChecked())
        {
            Intent intent = new Intent(SymptomCheckBox.this, SymptomCheckerListView.class);
            intent.putExtra("flag", "HeadGrowth_HeadShaking");
            startActivity(intent);
        }

        else if(checkBox3.isChecked() && checkBox4.isChecked())
        {
            Intent intent = new Intent(SymptomCheckBox.this, SymptomCheckerListView.class);
            intent.putExtra("flag", "NeckAndBackPain_HeadShaking");
            startActivity(intent);
        }
         else if(checkBox4.isChecked())
         {
             Intent intent = new Intent(SymptomCheckBox.this, SymptomCheckerListView.class);
             intent.putExtra("flag", "HeadShaking");
             startActivity(intent);
         }
         else if(checkBox3.isChecked())
         {
             Intent intent = new Intent(SymptomCheckBox.this, SymptomCheckerListView.class);
             intent.putExtra("flag", "NeckAndBackPain");
             startActivity(intent);
         }
         else if(checkBox2.isChecked())
         {
             Intent intent = new Intent(SymptomCheckBox.this, SymptomCheckerListView.class);
             intent.putExtra("flag", "HeadGrowth");
             startActivity(intent);
         }
        else if(checkBox1.isChecked())
        {
            Intent intent = new Intent(SymptomCheckBox.this, SymptomCheckerListView.class);
            intent.putExtra("flag", "NoseBleeding");
            startActivity(intent);
        }


    }



        //task.execute("http://10.0.2.2/client/insertAdminSheltrData.php");
        //task.execute("http://192.168.0.19/client/getName.php");
        //task.execute("http://192.168.0.19/client/getName.php");


        /*

        Intent intent = getIntent();
        String checkFlag= intent.getStringExtra("flag");
        if (checkFlag.equals("catHead/Neck/Nose") || checkFlag.equals("catEars") || checkFlag.equals("catMouth/Teeth") ||
                checkFlag.equals("catBack") || checkFlag.equals("Tab2ShelterZipCode") || checkFlag.equals("Tab2ShelterZipCode") ||
                checkFlag.equals("Tab2ShelterZipCode") || checkFlag.equals("Tab2ShelterZipCode"))
        {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        }



        Intent intent = getIntent();
        String checkFlag= intent.getStringExtra("flag");

        if (checkFlag.equals("catButton") && headNeckNose.getText().toString().equals("Head/Neck/Nose")) {
            //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
            headNeckNose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "catHead/Neck/Nose");
                    startActivity(intent);
                }
            });
        }
        if (checkFlag.equals("catButton") && ears.getText().toString().equals("Ears")) {
            ears.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "catEars");
                    startActivity(intent);
                }
            });
        }
        if (checkFlag.equals("catButton") && mouthTeeth.getText().toString().equals("Mouth/Teeth")) {
            mouthTeeth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "catMouth/Teeth");
                    startActivity(intent);
                }
            });
        }
        if (checkFlag.equals("catButton") && back.getText().toString().equals("Back")) {
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "catBack");
                    startActivity(intent);
                }
            });
        }
        if (checkFlag.equals("catButton") && tail.getText().toString().equals("Tail")) {
            tail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "catTail");
                    startActivity(intent);
                }
            });
        }
        if (checkFlag.equals("catButton") && legs.getText().toString().equals("Legs")) {
            legs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "catLegs");
                    startActivity(intent);
                }
            });
        }
        if (checkFlag.equals("catButton") && abdomen.getText().toString().equals("Abdomen")) {
            abdomen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "catAbdomen");
                    startActivity(intent);
                }
            });
        }
        if (checkFlag.equals("catButton") && reprodUrin.getText().toString().equals("Reproduction/Urinary")) {
            reprodUrin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "catReproduction/Urinary");
                    startActivity(intent);
                }
            });
        }
        if (checkFlag.equals("catButton") && hindHips.getText().toString().equals("Hindquarters/Hips")) {
            hindHips.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "catHindquarters/Hips");
                    startActivity(intent);
                }
            });
        }





         if (checkFlag.equals("dogButton") && headNeckNose.getText().toString().equals("Head/Neck/Nose")) {
            //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
            headNeckNose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "dogHead/Neck/Nose");
                    startActivity(intent);
                }
            });
        }
        if (checkFlag.equals("dogButton") && ears.getText().toString().equals("Ears")) {
            ears.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "dogEars");
                    startActivity(intent);
                }
            });
        }
        if (checkFlag.equals("dogButton") && mouthTeeth.getText().toString().equals("Mouth/Teeth")) {
            mouthTeeth.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "dogMouth/Teeth");
                    startActivity(intent);
                }
            });
        }
        if (checkFlag.equals("dogButton") && back.getText().toString().equals("Back")) {
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "dogBack");
                    startActivity(intent);
                }
            });
        }
        if (checkFlag.equals("dogButton") && tail.getText().toString().equals("Tail")) {
            tail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "dogTail");
                    startActivity(intent);
                }
            });
        }
        if (checkFlag.equals("dogButton") && legs.getText().toString().equals("Legs")) {
            legs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "dogLegs");
                    startActivity(intent);
                }
            });
        }
        if (checkFlag.equals("dogButton") && abdomen.getText().toString().equals("Abdomen")) {
            abdomen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "dogAbdomen");
                    startActivity(intent);
                }
            });
        }
        if (checkFlag.equals("dogButton") && reprodUrin.getText().toString().equals("Reproduction/Urinary")) {
            reprodUrin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "dogReproduction/Urinary");
                    startActivity(intent);
                }
            });
        }
        if (checkFlag.equals("dogButton") && hindHips.getText().toString().equals("Hindquarters/Hips")) {
            hindHips.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(SymptomChooseCatBodyArea.this, "You chose head/neck/nose", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SymptomChooseCatBodyArea.this, SymptomCheckBox.class);
                    intent.putExtra("flag", "dogHindquarters/Hips");
                    startActivity(intent);
                }
            });
        } */


}
