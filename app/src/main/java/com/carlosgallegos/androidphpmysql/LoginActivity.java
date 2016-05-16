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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername, etPassword;
    Button btnLogin;
    TextView btnSignUp;
    TextView adminLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.adUsername);
        etPassword = (EditText) findViewById(R.id.adPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignUp = (TextView) findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
        btnLogin.setOnClickListener(this);

        adminLogin = (TextView) findViewById(R.id.adminLogin);
        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, LoginAdmin.class));

            }
        });


    }

    @Override
    public void onClick(View view) {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        HashMap postData = new HashMap();
        postData.put("txtUsername", username);
        postData.put("txtPassword", password);

        PostResponseAsyncTask task = new PostResponseAsyncTask(LoginActivity.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String result) {
                if(result.contains("success")) {
                    //Toast.makeText(LoginActivity.this, "Successful Login", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity.this, TabHostActivity.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(LoginActivity.this, "Incorrect, Try Again", Toast.LENGTH_LONG).show();
                }
            }
        });
        //task.execute("http://10.0.2.2/client/index.php");
        task.execute("http://192.168.0.19/client/index.php");
    }
}
