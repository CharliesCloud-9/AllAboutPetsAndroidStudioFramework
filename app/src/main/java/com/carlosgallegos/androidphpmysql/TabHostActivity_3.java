package com.carlosgallegos.androidphpmysql;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class TabHostActivity_3 extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabhost_3);

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);

        TabHost.TabSpec tab1 = tabHost.newTabSpec("ABA ONE");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("ABA TWO");
        TabHost.TabSpec tab3 = tabHost.newTabSpec("ABA THREE");
        TabHost.TabSpec tab4 = tabHost.newTabSpec("ABA FOUR");

        //tab1.setIndicator("Tab1FunDapterSubActivityCat");
        tab1.setIndicator("", getResources().getDrawable(R.drawable.search));
        tab1.setContent(new Intent(this, SymptomChecker.class));

        //tab2.setIndicator("Tab2MapsVet_3b");
        tab2.setIndicator("", getResources().getDrawable(R.drawable.vet));
        tab2.setContent(new Intent(this, MapsActivity.class));

        //tab3.setIndicator("Tab3");
        tab3.setIndicator("", getResources().getDrawable(R.drawable.groom));
        tab3.setContent(new Intent(this, Tab3.class));

        //tab4.setIndicator("Tab4");
        tab4.setIndicator("", getResources().getDrawable(R.drawable.walk));
        tab4.setContent(new Intent(this, Tab4.class));

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
        tabHost.addTab(tab4);
    }
}