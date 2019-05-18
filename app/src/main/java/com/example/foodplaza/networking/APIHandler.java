package com.example.foodplaza.networking;

import com.androidnetworking.error.ANError;

import org.json.JSONObject;

public interface APIHandler
{
   void onSuccess(JSONObject response);
   void onError(ANError anError);
}
