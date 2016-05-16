package com.carlosgallegos.androidphpmysql;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_intro);

        //Add Sound
        //MediaPlayer sound = MediaPlayer.create(this, R.raw.petmeowbark);
       // sound.start(); //Method that starts the sound

        //Added timer criteria
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent openMain = new Intent(SplashIntro.this, LoginActivity.class); //or "com.splash.SPLASH"
                    startActivity(openMain);
                    finish();
                }
            }
        };
        //method that starts the timer
        timer.start();
    }
}
