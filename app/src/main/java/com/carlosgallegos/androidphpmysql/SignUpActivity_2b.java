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

public class SignUpActivity_2b extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etAge, etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_activity_2b);

        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        Button button = (Button) findViewById(R.id.button);
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
                SignUpActivity_2b.this,
                postData,
                new AsyncResponse() {
                    @Override
                    public void processFinish(String s) {
                        Toast.makeText(SignUpActivity_2b.this, s, Toast.LENGTH_LONG).show();
                        if(s.contains("success")){
                            startActivity(new Intent(SignUpActivity_2b.this, LoginActivity_2.class));
                        }

                    }
                });
        task.execute("http://10.0.2.2/client/insertSignUpData.php");
    }
}
