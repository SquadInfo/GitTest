package com.example.foodplaza.mvc;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

public class FoodApplication extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();

        AndroidNetworking.initialize(getApplicationContext());
    }
}
