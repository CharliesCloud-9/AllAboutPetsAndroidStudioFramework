package com.carlosgallegos.androidphpmysql;

import com.google.gson.annotations.SerializedName;

/**
 * Created by carlosgallegos on 5/12/16.
 */
public class HomePositioningSerialize {


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
