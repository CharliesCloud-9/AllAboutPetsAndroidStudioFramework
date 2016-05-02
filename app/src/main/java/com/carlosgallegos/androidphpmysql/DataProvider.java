package com.carlosgallegos.androidphpmysql;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created 3/31/16. For Inflating the Expandable List View.
 */
public class DataProvider {

    public static HashMap<String, List<String>> getInfoCat()
    {
        HashMap<String, List<String>> parentDetails = new HashMap<String, List<String>>();

        List<String> action_Movies = new ArrayList<String>();
        action_Movies.add("test");
        action_Movies.add("302 Rise");
        action_Movies.add("303 Rise");

        List<String> comedy_Movies = new ArrayList<String>();
        comedy_Movies.add("601 Rise");
        comedy_Movies.add("602 Rise");
        comedy_Movies.add("603 Rise");

        List<String> horror_Movies = new ArrayList<String>();
        horror_Movies.add("501 Rise");
        horror_Movies.add("Cat");
        horror_Movies.add("503 Rise");

        List<String> romantic_Movies = new ArrayList<String>();
        romantic_Movies.add("401 Rise");
        romantic_Movies.add("402 Rise");
        romantic_Movies.add("403 Rise");


        parentDetails.put("Action", action_Movies); //this seems to be 1st in order
        parentDetails.put("Comedy", comedy_Movies); //this seems to be 4th in order
        parentDetails.put("Horror", horror_Movies); //this seems to be 3rd in order
        parentDetails.put("Romantic", romantic_Movies); //this seems to be 2nd in order



        return parentDetails;
    }

    public static HashMap<String, List<String>> getInfoDog()
    {
        HashMap<String, List<String>> parentDetails = new HashMap<String, List<String>>();

        List<String> action_Movies = new ArrayList<String>();
        action_Movies.add("test");
        action_Movies.add("302 Rise");
        action_Movies.add("303 Rise");

        List<String> comedy_Movies = new ArrayList<String>();
        comedy_Movies.add("601 Rise");
        comedy_Movies.add("602 Rise");
        comedy_Movies.add("603 Rise");

        List<String> horror_Movies = new ArrayList<String>();
        horror_Movies.add("501 Rise");
        horror_Movies.add("Dog");
        horror_Movies.add("503 Rise");

        List<String> romantic_Movies = new ArrayList<String>();
        romantic_Movies.add("401 Rise");
        romantic_Movies.add("402 Rise");
        romantic_Movies.add("403 Rise");


        parentDetails.put("Action", action_Movies); //this seems to be 1st in order
        parentDetails.put("Comedy", comedy_Movies); //this seems to be 4th in order
        parentDetails.put("Horror", horror_Movies); //this seems to be 3rd in order
        parentDetails.put("Romantic", romantic_Movies); //this seems to be 2nd in order



        return parentDetails;
    }

}