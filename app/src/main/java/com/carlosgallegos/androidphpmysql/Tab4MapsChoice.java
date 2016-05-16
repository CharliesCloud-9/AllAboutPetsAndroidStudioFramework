package com.carlosgallegos.androidphpmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Tab4MapsChoice extends AppCompatActivity {

    TextView bing, google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab4_maps_choice);

        bing = (TextView) findViewById(R.id.bingText);
        google= (TextView) findViewById(R.id.googleText);

        bing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tab4MapsChoice.this, BingMapsActivity.class);
                startActivity(intent);

            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tab4MapsChoice.this,GoogleMapsActivity.class);
                startActivity(intent);

            }
        });


    }
}
