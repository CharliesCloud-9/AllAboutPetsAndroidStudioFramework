package com.carlosgallegos.androidphpmysql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.annotations.SerializedName;

public class ShelterPositioningSerialize  {


    @SerializedName("sid")
    public int sid;

    @SerializedName("petName")
    public String petName;

    @SerializedName("phoneNumber")
    public String phoneNumber;

    @SerializedName("imagePet_url")
    public String imagePet_url;

    @SerializedName("comment")
    public String comment;

}
