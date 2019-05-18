package com.example.foodplaza.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Order")
public class Order
{
    @PrimaryKey(autoGenerate = true)
    private int orderId;
    private String deliLocation;
    private  double Amount;
    private  int userId;
    private String Status;
    private long date;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDeliLocation() {
        return deliLocation;
    }

    public void setDeliLocation(String deliLocation) {
        this.deliLocation = deliLocation;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
