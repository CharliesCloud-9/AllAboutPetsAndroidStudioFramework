package com.carlosgallegos.androidphpmysql;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.annotations.SerializedName;

public class SymptomPositioningSerialize {



    @SerializedName("pid")
    public int pid;

    @SerializedName("name")
    public String name;

    @SerializedName("qty")
    public String qty;

    @SerializedName("image_url")
    public String image_url;

    @SerializedName("price")
    public String price;







}
