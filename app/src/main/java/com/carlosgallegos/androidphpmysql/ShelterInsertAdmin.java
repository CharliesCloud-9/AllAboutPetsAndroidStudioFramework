package com.carlosgallegos.androidphpmysql;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.android.photoutil.CameraPhoto;
import com.kosalgeek.android.photoutil.GalleryPhoto;
import com.kosalgeek.android.photoutil.ImageBase64;
import com.kosalgeek.android.photoutil.ImageLoader;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.EachExceptionsHandler;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.HashMap;

public class ShelterInsertAdmin extends AppCompatActivity  {

    EditText petName, phoneNumber, comment;
    ImageView galleryImageShelterInsert;
    TextView viewShelterPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelterinsert_admin);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


        petName = (EditText) findViewById(R.id.petName);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        comment = (EditText) findViewById(R.id.comment);
        galleryImageShelterInsert = (ImageView) findViewById(R.id.imageGallery1);
        viewShelterPosts = (TextView) findViewById(R.id.viewShPts);

        galleryImageShelterInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShelterInsertAdmin.this, CameraGallery.class);
                startActivity(intent);
            }
        });

        viewShelterPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShelterInsertAdmin.this, ShelterUserListView.class);
                intent.putExtra("flag", "ShelterInsertAdmin");
                startActivity(intent);
            }
        });




        Button adminUpdateButton = (Button) findViewById(R.id.adminUpdateButton);


        adminUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap postData = new HashMap();
                    postData.put("petName", petName.getText().toString());
                    postData.put("phoneNumber", phoneNumber.getText().toString());
                    postData.put("comment", comment.getText().toString());
                    postData.put("mobile", "android");

                    PostResponseAsyncTask task = new PostResponseAsyncTask(
                            ShelterInsertAdmin.this,
                            postData,
                            new AsyncResponse() {
                                @Override
                                public void processFinish(String s) {
                                    Toast.makeText(ShelterInsertAdmin.this, s, Toast.LENGTH_LONG).show();
                                    if (s.contains("success")) {
                                        // startActivity(new Intent(ShelterInsertAdmin.this, ShelterUserListView.class));
                                        Intent intent = new Intent(ShelterInsertAdmin.this, ShelterUserListView.class);
                                        intent.putExtra("flag", "ShelterInsertAdmin");
                                        startActivity(intent);
                                    }
                                }
                            });
                    //task.execute("http://10.0.2.2/client/insertAdminSheltrData.php");
                    task.execute("http://192.168.0.19/client/insertAdminSheltrData.php");
            }
        });
    }
}







