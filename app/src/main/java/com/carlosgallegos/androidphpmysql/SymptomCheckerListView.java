package com.carlosgallegos.androidphpmysql;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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
import java.util.HashMap;

public class SymptomCheckerListView extends AppCompatActivity implements AsyncResponse, View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptomchecker_listview);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


          PostResponseAsyncTask task = new PostResponseAsyncTask(SymptomCheckerListView.this, this);

            //task.execute("http://10.0.2.2/client/product.php");
            //task.execute("http://192.168.0.19/client/product.php");
        Intent intent = getIntent();
        String checkFlag= intent.getStringExtra("flag");

        if (checkFlag.equals("NoseBleeding")) {
            task.execute("http://192.168.0.19/client/noseBleeding.php");
        }
        else if (checkFlag.equals("HeadGrowth")) {
            task.execute("http://192.168.0.19/client/headGrowth.php");
        }
        else if (checkFlag.equals("NeckAndBackPain")) {
            task.execute("http://192.168.0.19/client/neckAndBackPain.php");
        }
        else if (checkFlag.equals("HeadShaking")) {
            task.execute("http://192.168.0.19/client/headShaking.php");
        }
        else if (checkFlag.equals("NoseBleeding_HeadGrowth")) {
            task.execute("http://192.168.0.19/client/noseBleeding_HeadGrowth.php");
        }
       else  if (checkFlag.equals("NoseBleeding_NeckAndBackPain")) {
            task.execute("http://192.168.0.19/client/noseBleeding_NeckAndBackPain.php");
        }
        else if (checkFlag.equals("NoseBleeding_HeadShaking")) {
            task.execute("http://192.168.0.19/client/noseBleeding_HeadShaking.php");
        }
        else if (checkFlag.equals("HeadGrowth_NeckAndBackPain")) {
            task.execute("http://192.168.0.19/client/headGrowth_NeckAndBackPain.php");
        }
        if (checkFlag.equals("HeadGrowth_HeadShaking")) {
            task.execute("http://192.168.0.19/client/headGrowth_HeadShaking.php");
        }
        else if (checkFlag.equals("NeckAndBackPain_HeadShaking")) {
            task.execute("http://192.168.0.19/client/neckAndBackPain_HeadShaking.php");
        }

    }




    @Override
    public void processFinish(String jsonText) {

        ImageLoader.getInstance().init(UILConfig());

        ArrayList<SymptomPositioningSerialize> productLayoutPositioning3bList = new JsonConverter<SymptomPositioningSerialize>().toArrayList(jsonText, SymptomPositioningSerialize.class);

        BindDictionary<SymptomPositioningSerialize> dict = new BindDictionary<SymptomPositioningSerialize>();

            dict.addStringField(R.id.tvName, new StringExtractor<SymptomPositioningSerialize>() {

                @Override
                public String getStringValue(SymptomPositioningSerialize productLayoutPositioning3b, int position) {
                    return productLayoutPositioning3b.name;
                }
            });


        dict.addStringField(R.id.tvQty, new StringExtractor<SymptomPositioningSerialize>() {
                @Override
                public String getStringValue(SymptomPositioningSerialize productLayoutPositioning3b, int position) {
                    return "" + productLayoutPositioning3b.qty;
                }
            });
            dict.addStringField(R.id.tvPrice, new StringExtractor<SymptomPositioningSerialize>() {
                @Override
                public String getStringValue(SymptomPositioningSerialize productLayoutPositioning3b, int position) {
                    return "" + productLayoutPositioning3b.price;
                }
            });


            dict.addDynamicImageField(R.id.imageView, new StringExtractor<SymptomPositioningSerialize>() {
                        @Override
                        public String getStringValue(SymptomPositioningSerialize productLayoutPositioning3b, int position) {
                            return productLayoutPositioning3b.image_url;
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


            FunDapter<SymptomPositioningSerialize> adapter = new FunDapter<>(SymptomCheckerListView.this,
                    productLayoutPositioning3bList, R.layout.symptom_positioning, dict);

            ListView lvProduct = (ListView) findViewById(R.id.lvProduct);
            lvProduct.setAdapter(adapter);



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
