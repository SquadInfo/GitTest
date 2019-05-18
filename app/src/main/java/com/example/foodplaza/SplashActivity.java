package com.example.foodplaza;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.foodplaza.constant.APP_CONSTANT;


public class SplashActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreferences=getSharedPreferences(APP_CONSTANT.MY_PREFERENCE,MODE_PRIVATE);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //startActivity(new Intent(SplashActivity.this, LoginActivity.class));

                if(sharedPreferences.contains(APP_CONSTANT.ISUSERLOGGEDIN))
                {
                    if(sharedPreferences.getBoolean(APP_CONSTANT.ISUSERLOGGEDIN,false))
                    {
                        //after finishing marketing CHANGE IT TO FALSE
                        if(sharedPreferences.getBoolean(APP_CONSTANT.ISMARKETINGSHOWN,true))
                        {
                            //show login activity
                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        }
                        else
                        {
                            startActivity(new Intent(SplashActivity.this, MarketingActivity.class));
                        }
                          }
                    else
                    {
                            //show login activity
                            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    }
                }
                else
                {
                        //show login activity
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));

                }
            }
        },1000);
    }
}
