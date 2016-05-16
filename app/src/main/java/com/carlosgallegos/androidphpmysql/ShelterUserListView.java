package com.carlosgallegos.androidphpmysql;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.amigold.fundapter.interfaces.DynamicImageLoader;
import com.amigold.fundapter.interfaces.ItemClickListener;
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

public class ShelterUserListView extends AppCompatActivity implements AsyncResponse, View.OnClickListener  {

        private ArrayList<ShelterPositioningSerialize> shelterPositioningSerializeList;
        private ListView lvShelter;
        private FunDapter<ShelterPositioningSerialize> adapter;

@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelteruser_listview);

        //ImageLoader.getInstance().init(UILConfig.config(ShelterUserListView.this));

        Intent intent = getIntent();
        String checkFlag= intent.getStringExtra("flag");
        if (checkFlag.equals("Tab2ShelterZipCode"))
        {
                getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        }

        PostResponseAsyncTask task=new PostResponseAsyncTask(ShelterUserListView.this,this);

        //task.execute("http://10.0.2.2/client/animal_Shelter.php");
        task.execute("http://192.168.0.19/client/animal_Shelter.php");

        lvShelter=(ListView)findViewById(R.id.lvShelter);

        if (checkFlag.equals("ShelterInsertAdmin"))
        {
                registerForContextMenu(lvShelter);
        }
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                super.onCreateContextMenu(menu, v, menuInfo);
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.list_context_menu, menu);
        }

        @Override
        public boolean onContextItemSelected(MenuItem item) {

                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                final ShelterPositioningSerialize selectShelterItem = adapter.getItem(info.position);

                if (item.getItemId() == R.id.menuRemove) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(this);
                        alert.setMessage("Do you want to remove " + selectShelterItem.petName + "?");
                        alert.setPositiveButton("Remove", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                        shelterPositioningSerializeList.remove(selectShelterItem);
                                        adapter.notifyDataSetChanged();


                                        HashMap postData = new HashMap();
                                        postData.put("sid", "" + selectShelterItem.sid);
                                        postData.put("mobile", "android");

                                        PostResponseAsyncTask taskRemove = new PostResponseAsyncTask(ShelterUserListView.this, postData, new AsyncResponse() {
                                                @Override
                                                public void processFinish(String result) {
                                                        if (result.contains("success")) {
                                                                Toast.makeText(ShelterUserListView.this, "Delete Successfully", Toast.LENGTH_LONG).show();
                                                        }
                                                }
                                        });
                                        //taskRemove.execute("http://10.0.2.2/client/removeShelterAnimAdmin.php");
                                        taskRemove.execute("http://192.168.0.19/client/removeShelterAnimAdmin.php");
                                }
                        });

                        alert.setNegativeButton("Cancel", null);
                        alert.show();
                }

                return super.onContextItemSelected(item);
        }

        @Override
        public void processFinish(String jsonText){

        ImageLoader.getInstance().init(UILConfig());

        shelterPositioningSerializeList=new JsonConverter<ShelterPositioningSerialize>().toArrayList(jsonText,ShelterPositioningSerialize.class);

        BindDictionary<ShelterPositioningSerialize> dict=new BindDictionary<ShelterPositioningSerialize>();

        Intent intent = getIntent();
        String checkFlag= intent.getStringExtra("flag");


        //if comes from Tab2ShelterZipCode, then user can only view ListView and click on animal picture to get more info...
        //else if comes from ShelterInsertAdmin, then Admin has ability to delete and update animal picture posts in same ListView
        if (checkFlag.equals("Tab2ShelterZipCode")) {

                dict.addStringField(R.id.petName, new StringExtractor<ShelterPositioningSerialize>() {
                        @Override
                        public String getStringValue(ShelterPositioningSerialize shelterPositioningSerializeList, int position) {
                                return shelterPositioningSerializeList.petName;
                        }
                }).onClick(new ItemClickListener<ShelterPositioningSerialize>() {
                        @Override
                        public void onClick(ShelterPositioningSerialize item, int position, View view) {
                                Toast.makeText(ShelterUserListView.this, item.petName, Toast.LENGTH_LONG).show();
                        }
                });

                dict.addStringField(R.id.phoneNumber, new StringExtractor<ShelterPositioningSerialize>() {
                        @Override
                        public String getStringValue(ShelterPositioningSerialize shelterPositioningSerializeList, int position) {
                                return "" + shelterPositioningSerializeList.phoneNumber;
                        }
                });


                dict.addDynamicImageField(R.id.imagePet_url, new StringExtractor<ShelterPositioningSerialize>() {
                                @Override
                                public String getStringValue(ShelterPositioningSerialize shelterPositioningSerializeList, int position) {
                                        return shelterPositioningSerializeList.imagePet_url;
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

                dict.addStringField(R.id.comment, new StringExtractor<ShelterPositioningSerialize>() {
                                @Override
                                public String getStringValue(ShelterPositioningSerialize shelterPositioningSerializeList, int position) {
                                        return "" + shelterPositioningSerializeList.comment;
                                }
                });




        } else if (checkFlag.equals("ShelterInsertAdmin")){

                dict.addStringField(R.id.petName, new StringExtractor<ShelterPositioningSerialize>() {
                        @Override
                        public String getStringValue(ShelterPositioningSerialize shelterPositioningSerializeList, int position) {
                                return shelterPositioningSerializeList.petName;
                        }
                });

                dict.addStringField(R.id.phoneNumber, new StringExtractor<ShelterPositioningSerialize>() {
                        @Override
                        public String getStringValue(ShelterPositioningSerialize shelterPositioningSerializeList, int position) {
                                return "" + shelterPositioningSerializeList.phoneNumber;
                        }
                });


                dict.addDynamicImageField(R.id.imagePet_url, new StringExtractor<ShelterPositioningSerialize>() {
                                @Override
                                public String getStringValue(ShelterPositioningSerialize shelterPositioningSerializeList, int position) {
                                        return shelterPositioningSerializeList.imagePet_url;
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

                dict.addStringField(R.id.comment, new StringExtractor<ShelterPositioningSerialize>() {
                        @Override
                        public String getStringValue(ShelterPositioningSerialize shelterPositioningSerializeList, int position) {
                                return "" + shelterPositioningSerializeList.comment;
                        }
                });

        }

        adapter=new FunDapter<>(
                ShelterUserListView.this, shelterPositioningSerializeList,R.layout.shelter_positioning,dict);


        lvShelter.setAdapter(adapter);

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

        /*
    public UILConfig{

    public static ImageLoaderConfiguration config(Context context){
        DisplayImageOptions defaultOptions=
                new DisplayImageOptions.Builder()
                        .cacheInMemory(true)
                        .cacheOnDisk(true)
                        .showImageOnLoading(android.R.drawable.stat_sys_download)
                        .showImageForEmptyUri(android.R.drawable.ic_dialog_alert)
                        .showImageOnFail(android.R.drawable.stat_notify_error)
                        .considerExifParams(true)
                        .bitmapConfig(Bitmap.Config.RGB_565)
                        .imageScaleType(ImageScaleType.EXACTLY_STRETCHED) //EXACTLY_STRETCHED
                        .build();

        File cacheDir = StorageUtils.getCacheDirectory(context);
        ImageLoaderConfiguration config= new ImageLoaderConfiguration.Builder(context) //getApplicationContext()
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .tasksProcessingOrder(QueueProcessingType.FIFO)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .memoryCacheSizePercentage(13)
                .diskCache(new UnlimitedDiskCache(cacheDir))
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                .imageDownloader(new BaseImageDownloader(context))
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .writeDebugLogs()
                .defaultDisplayImageOptions(defaultOptions)
                .build();

                return config;
        }
        }
            */


@Override
public void onClick(View v){

        }


}
