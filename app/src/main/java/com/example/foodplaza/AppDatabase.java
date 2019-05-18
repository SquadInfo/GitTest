package com.example.foodplaza;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.foodplaza.dao.FoodDao;
import com.example.foodplaza.model.Food;
import com.example.foodplaza.model.Order;

@Database(entities = {Food.class, Order.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase
{
    private static volatile AppDatabase INSTANCE;
    public abstract FoodDao foodDao();


  public   static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null)
        {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "food_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
