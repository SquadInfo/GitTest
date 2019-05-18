package com.example.foodplaza.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.example.foodplaza.model.Order;

import java.util.List;

public interface OrderDao
{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    int insert(Order order);

    @Query("SELECT * FROM `Order` ORDER BY orderId asc")
    LiveData<List<Order>> getAllOrder();

    @Query("SELECT * FROM `order` WHERE orderId=:id")
    Order getOrderById(int id);

    @Query("DELETE FROM `Order` WHERE orderId=:id")
    Order deleteOrderById(int id);

    @Query("DELETE FROM `order`")
    void deleteAll();






}
