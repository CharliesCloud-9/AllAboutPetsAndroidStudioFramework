package com.carlosgallegos.androidphpmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpListViewDictDog extends AppCompatActivity {

    HashMap<String, List<String>> parentCategory;
    List<String> childList;
    ExpandableListView expList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_list_view_dict_dog);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        expList = (ExpandableListView) findViewById(R.id.exp_list);
        parentCategory = DataProvider.getInfoDog();
        childList = new ArrayList<String>(parentCategory.keySet());
        adapter = new Adapter(this, parentCategory, childList);
        expList.setAdapter(adapter);

        expList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getBaseContext(), childList.get(groupPosition) + " is expanded ",
                        Toast.LENGTH_LONG).show();
            }
        });

        expList.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getBaseContext(), childList.get(groupPosition) + " is collapsed ",
                        Toast.LENGTH_LONG).show();
            }
        });

        expList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //Toast.makeText(getBaseContext(),

                //parentCategory.get(childList.get(groupPosition)).get(childPosition)+ " from category " +
                //  childList.get(groupPosition) + " is selected", Toast.LENGTH_LONG).show();

                if (parentCategory.get(childList.get(groupPosition)).get(childPosition).contains("test")) {
                    Intent intent = new Intent(ExpListViewDictDog.this, Tab1FunDapterSubActivityCat.class);
                    startActivity(intent);


                } else if (parentCategory.get(childList.get(groupPosition)).get(childPosition).contains("602 Rise")) {
                    Intent intent = new Intent(ExpListViewDictDog.this, Tab2Test.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getBaseContext(),
                            parentCategory.get(childList.get(groupPosition)).get(childPosition) + " from category " +
                                    childList.get(groupPosition) + " is selected", Toast.LENGTH_LONG).show();
                }

                return false;
            }

        });


    }
}
