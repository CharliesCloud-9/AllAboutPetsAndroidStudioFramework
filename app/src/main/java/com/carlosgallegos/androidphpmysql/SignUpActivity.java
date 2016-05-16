package com.carlosgallegos.androidphpmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etAge, etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        etName = (EditText) findViewById(R.id.adName);
        etAge = (EditText) findViewById(R.id.adAge);
        etUsername = (EditText) findViewById(R.id.adUsername);
        etPassword = (EditText) findViewById(R.id.adPassword);
        Button button = (Button) findViewById(R.id.adButton);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        HashMap postData = new HashMap();
        postData.put("txtName", etName.getText().toString());
        postData.put("txtAge", etAge.getText().toString());
        postData.put("txtUsername", etUsername.getText().toString());
        postData.put("txtPassword", etPassword.getText().toString());
        postData.put("mobile", "android");

        PostResponseAsyncTask task = new PostResponseAsyncTask(
                SignUpActivity.this,
                postData,
                new AsyncResponse() {
                    @Override
                    public void processFinish(String s) {
                        Toast.makeText(SignUpActivity.this, s, Toast.LENGTH_LONG).show();
                        if(s.contains("success")){
                            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                        }

                    }
                });
        //task.execute("http://10.0.2.2/client/insertSignUpData.php");
        task.execute("http://192.168.0.19/client/insertSignUpData.php");
    }
}
