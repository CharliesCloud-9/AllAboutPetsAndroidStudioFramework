package com.carlosgallegos.androidphpmysql;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class TabHostActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost);

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);

        TabHost.TabSpec tab1 = tabHost.newTabSpec("ABA ONE");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("ABA TWO");
        TabHost.TabSpec tab3 = tabHost.newTabSpec("ABA THREE");
        TabHost.TabSpec tab4 = tabHost.newTabSpec("ABA FOUR");

        tab1.setIndicator("", getResources().getDrawable(R.drawable.home));
        tab1.setContent(new Intent(this, Tab1HomePageListView.class));

        //tab3.setIndicator("ShelterUserListView");
        tab2.setIndicator("", getResources().getDrawable(R.drawable.adopt));
        tab2.setContent(new Intent(this, Tab2ShelterZipCode.class));

        //tab1.setIndicator("SymptomCheckerListView");
        tab3.setIndicator("", getResources().getDrawable(R.drawable.vet));
        tab3.setContent(new Intent(this, Tab3SymptomChecker.class));

        //tab2.setIndicator("Tab2MapsVet_3b");
        tab4.setIndicator("", getResources().getDrawable(R.drawable.map_hosp_icon));
        tab4.setContent(new Intent(this, Tab4MapsChoice.class));


        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
        tabHost.addTab(tab4);

    }
}