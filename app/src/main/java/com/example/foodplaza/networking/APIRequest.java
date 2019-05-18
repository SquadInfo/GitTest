package com.example.foodplaza.networking;

import com.example.foodplaza.model.Food;

public interface APIRequest
{
    void login(String userName,String password, APIHandler apiHandler);
    void getFoodList();
    void createFood(Food food);
}
