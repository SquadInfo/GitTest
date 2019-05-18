package com.example.foodplaza.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.foodplaza.model.Food;
import com.example.foodplaza.repository.FoodRepository;

import java.util.List;

public class FoodViewModel extends AndroidViewModel
{
 private FoodRepository foodRepository;
 private LiveData<List<Food>> listLiveData;

    public FoodViewModel(@NonNull Application application)
    {
        super(application);
        foodRepository=new FoodRepository(application);
        listLiveData=foodRepository.getAllFood();
    }

    public LiveData<List<Food>> getAllFood()
    {
        return listLiveData;
    }

    public AsyncTask<Food, Void, Void> insert(Food food)
    {
        foodRepository.insert(food);
       return null;
    }


}
