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

public class LoginActivity_2 extends AppCompatActivity implements View.OnClickListener {

    EditText etUsername, etPassword;
    Button btnLogin;
    TextView btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_2);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignUp = (TextView) findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity_2.this, SignUpActivity_2b.class));
            }
        });
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        HashMap postData = new HashMap();
        postData.put("txtUsername", username);
        postData.put("txtPassword", password);

        PostResponseAsyncTask task = new PostResponseAsyncTask(LoginActivity_2.this, postData, new AsyncResponse() {
            @Override
            public void processFinish(String result) {
                if(result.contains("success")) {
                    //Toast.makeText(LoginActivity_2.this, "Successful Login", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActivity_2.this, TabHostActivity_3.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(LoginActivity_2.this, "Incorrect, Try Again", Toast.LENGTH_LONG).show();
                }
            }
        });
        task.execute("http://10.0.2.2/client/index.php");
    }
}
