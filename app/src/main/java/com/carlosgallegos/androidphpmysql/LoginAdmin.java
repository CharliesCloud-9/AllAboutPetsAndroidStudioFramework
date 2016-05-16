package com.carlosgallegos.androidphpmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;

public class LoginAdmin extends AppCompatActivity implements View.OnClickListener {

    EditText adminUsername, adminPassword;
    Button adminBtnLogin;
    TextView adminBtnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        adminUsername = (EditText) findViewById(R.id.adminUsername);
        adminPassword = (EditText) findViewById(R.id.adminPassword);
        adminBtnLogin = (Button) findViewById(R.id.adminBtnLogin);
        adminBtnSignUp = (TextView) findViewById(R.id.adminBtnSignUp);
        adminBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginAdmin.this, AssignAdminCred.class));
            }
        });

        adminBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginAdmin.this, ShelterInsertAdmin.class));
            }
        });
        adminBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = adminUsername.getText().toString();
        String password = adminPassword.getText().toString();
        HashMap postData = new HashMap();
        postData.put("adminUsername", username);
        postData.put("adminPassword", password);

        PostResponseAsyncTask task = new PostResponseAsyncTask(LoginAdmin.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String result) {
                //if result is success meaning that login credentials were correct then start activity ShelterInsertAdmin
                //else Toast message Incorrect, Try Again
                if(result.contains("success")) {
                    //Toast.makeText(LoginActivity.this, "Successful Login", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginAdmin.this, ShelterInsertAdmin.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(LoginAdmin.this, "Incorrect, Try Again", Toast.LENGTH_LONG).show();
                }
            }
        });
        //task.execute("http://10.0.2.2/client/adminLogin.php");
        task.execute("http://192.168.0.19/client/adminLogin.php");
    }

}

