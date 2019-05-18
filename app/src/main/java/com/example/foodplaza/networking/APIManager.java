package com.example.foodplaza.networking;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.foodplaza.model.Food;

import org.json.JSONObject;

public class APIManager implements APIRequest {
    static APIManager apiManager;

    private APIManager() {
    }

    public static APIManager getInstance() {
        if (apiManager != null) {
            return apiManager;
        }
        apiManager = new APIManager();

        return apiManager;
    }

    @Override
    public void login(String userName, String password, final APIHandler apiHandler) {
        //http://coder.os.a2zapps.com/api/v4/sso/login.json

        AndroidNetworking.post("http://coder.os.a2zapps.com/api/v4/sso/login.json")
                .addBodyParameter("un", userName)
                .addBodyParameter("pw", password)
                .setTag("login")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                        apiHandler.onSuccess(response);
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        apiHandler.onError(error);
                    }
                });

    }

    @Override
    public void getFoodList() {

    }

    @Override
    public void createFood(Food food) {

    }
}
