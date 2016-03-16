package com.carlosgallegos.androidphpmysql;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Tab1FunDapterSubActivity_3a extends AppCompatActivity implements AsyncResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_fundapter_3a);

        PostResponseAsyncTask task = new PostResponseAsyncTask(Tab1FunDapterSubActivity_3a.this, this);

        task.execute("http://10.0.2.2/client/product.php");

    }

    @Override
    public void processFinish(String jsonText) {

        ImageLoader.getInstance().init(UILConfig());

        ArrayList<ProductLayoutPositioning_3a> productLayoutPositioning3bList = new JsonConverter<ProductLayoutPositioning_3a>().toArrayList(jsonText, ProductLayoutPositioning_3a.class);
        // 1:12:18 min https://www.youtube.com/watch?v=1QK_uindqHg
        BindDictionary<ProductLayoutPositioning_3a> dict = new BindDictionary<ProductLayoutPositioning_3a>();
        dict.addStringField(R.id.tvName, new StringExtractor<ProductLayoutPositioning_3a>() {
            @Override
            public String getStringValue(ProductLayoutPositioning_3a productLayoutPositioning3b, int position) {
                return productLayoutPositioning3b.name;
            }
        });
        dict.addStringField(R.id.tvQty, new StringExtractor<ProductLayoutPositioning_3a>() {
            @Override
            public String getStringValue(ProductLayoutPositioning_3a productLayoutPositioning3b, int position) {
                return "" + productLayoutPositioning3b.qty;
            }
        });
        dict.addStringField(R.id.tvPrice, new StringExtractor<ProductLayoutPositioning_3a>() {
            @Override
            public String getStringValue(ProductLayoutPositioning_3a productLayoutPositioning3b, int position) {
                return "" + productLayoutPositioning3b.price;
            }
        });

        dict.addDynamicImageField(R.id.imageView, new StringExtractor<ProductLayoutPositioning_3a>() {
                    @Override
                    public String getStringValue(ProductLayoutPositioning_3a productLayoutPositioning3b, int position) {
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

        FunDapter<ProductLayoutPositioning_3a> adapter = new FunDapter<>(Tab1FunDapterSubActivity_3a.this,
                productLayoutPositioning3bList, R.layout.product_layoutpositioning_3a, dict);

        ListView lvProduct = (ListView)findViewById(R.id.lvProduct);
        lvProduct.setAdapter(adapter);

        // 1:22:01 min https://www.youtube.com/watch?v=1QK_uindqHg
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

}
