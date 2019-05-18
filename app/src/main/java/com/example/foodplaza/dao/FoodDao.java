package com.example.foodplaza.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.example.foodplaza.model.Food;

import java.util.List;

@Dao
public interface FoodDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Food food);

    @Query("DELETE FROM Food")
    void deleteAll();

    @Query("SELECT * FROM Food ORDER BY foodRating DESC")
    LiveData<List<Food>> getAllFood();

    @Query("SELECT * FROM Food WHERE foodId=:id")
    Food getFoodById(int id);
}
