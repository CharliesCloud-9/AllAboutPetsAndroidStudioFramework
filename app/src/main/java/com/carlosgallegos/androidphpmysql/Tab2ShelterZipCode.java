package com.carlosgallegos.androidphpmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tab2ShelterZipCode extends AppCompatActivity implements View.OnClickListener {

    Button button2;
    EditText zipCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2_shelterzipcode);
        zipCode = (EditText) findViewById(R.id.zipcode);


         button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        Intent intent = new Intent(Tab2ShelterZipCode.this, ShelterUserListView.class);
        intent.putExtra("flag", "Tab2ShelterZipCode");
        startActivity(intent);
    }
        //startActivity(new Intent(Tab2ShelterZipCode.this, GoogleMapsActivity.class));

}
