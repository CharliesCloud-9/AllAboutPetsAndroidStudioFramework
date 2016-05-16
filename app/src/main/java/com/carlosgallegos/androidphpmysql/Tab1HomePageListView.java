package com.carlosgallegos.androidphpmysql;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.amigold.fundapter.interfaces.DynamicImageLoader;
import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.util.ArrayList;

public class Tab1HomePageListView extends AppCompatActivity implements AsyncResponse, View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab1_homepage_listview);
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        PostResponseAsyncTask task = new PostResponseAsyncTask(Tab1HomePageListView.this, this);

        //task.execute("http://10.0.2.2/client/homePageLV.php");
        task.execute("http://192.168.0.19/client/homePageLV.php");

    }

    @Override
    public void processFinish(String jsonText) {

        ImageLoader.getInstance().init(UILConfig());

        ArrayList<HomePositioningSerialize> homePositioningSerialize = new JsonConverter<HomePositioningSerialize>().toArrayList(jsonText, HomePositioningSerialize.class);

        BindDictionary<HomePositioningSerialize> dict = new BindDictionary<HomePositioningSerialize>();

        dict.addStringField(R.id.tvName, new StringExtractor<HomePositioningSerialize>() {

            @Override
            public String getStringValue(HomePositioningSerialize homePositioningSerialize, int position) {
                return homePositioningSerialize.name;
            }
        });
        dict.addStringField(R.id.tvQty, new StringExtractor<HomePositioningSerialize>() {
            @Override
            public String getStringValue(HomePositioningSerialize homePositioningSerialize, int position) {
                return "" + homePositioningSerialize.qty;
            }
        });
        dict.addStringField(R.id.tvPrice, new StringExtractor<HomePositioningSerialize>() {
            @Override
            public String getStringValue(HomePositioningSerialize homePositioningSerialize, int position) {
                return "" + homePositioningSerialize.price;
            }
        });

        dict.addDynamicImageField(R.id.imageView, new StringExtractor<HomePositioningSerialize>() {
                    @Override
                    public String getStringValue(HomePositioningSerialize homePositioningSerialize, int position) {
                        return homePositioningSerialize.image_url;
                    }
                }, new DynamicImageLoader() {
                    @Override
                    public void loadImage(String url, ImageView view) {
                        ImageLoader.getInstance().displayImage(url, view);
                        view.setPadding(0, 0, 0, 0);
                        view.setAdjustViewBounds(true);
                    }
                }
        );


        FunDapter<HomePositioningSerialize> adapter = new FunDapter<>(Tab1HomePageListView.this,
                homePositioningSerialize, R.layout.zhome_positioning, dict);

        ListView lvTab4HomePage = (ListView) findViewById(R.id.lvTab4HomePage);
        lvTab4HomePage.setAdapter(adapter);



    }


    private ImageLoaderConfiguration UILConfig(){
        DisplayImageOptions defaultOptions =
                new DisplayImageOptions.Builder()
                        .cacheInMemory(true)
                        .cacheOnDisk(true)
                        .showImageOnLoading(android.R.drawable.stat_sys_download)
                        .showImageForEmptyUri(android.R.drawable.ic_dialog_alert)
                        .showImageOnFail(android.R.drawable.stat_notify_error)
                        .considerExifParams(true)
                        .bitmapConfig(Bitmap.Config.RGB_565)
                        .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                        .build();

        ImageLoaderConfiguration config =
                new ImageLoaderConfiguration
                        .Builder(getApplicationContext())
                        .threadPriority(Thread.NORM_PRIORITY - 2)
                        .denyCacheImageMultipleSizesInMemory()
                        .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                        .tasksProcessingOrder(QueueProcessingType.LIFO)
                        .defaultDisplayImageOptions(defaultOptions)
                        .build();

        return config;
    }


    @Override
    public void onClick(View v) {

    }
}
