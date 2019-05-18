package com.example.foodplaza;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.foodplaza.databinding.ActivityMainBinding;
import com.example.foodplaza.model.Food;
import com.example.foodplaza.viewmodel.FoodViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FoodViewModel viewModel;
ActivityMainBinding binding;
    FoodListAdapter foodListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        viewModel= ViewModelProviders.of(this).get(FoodViewModel.class);
        foodListAdapter = new FoodListAdapter();
        binding.foodListRecyclerView.setAdapter(foodListAdapter);
        viewModel.getAllFood().observe(this, new Observer<List<Food>>() {
            @Override
            public void onChanged(@Nullable List<Food> foods)
            {
                foodListAdapter.setFoodList(foods);
            }
        });

        binding.refreshFloatinfButton.setOnClickListener(this);
        binding.addFoodFloatinfButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
switch (v.getId())
{
    case R.id.refreshFloatinfButton:

        break;

    case R.id.addFoodFloatinfButton:
        startActivity(new Intent(MainActivity.this,InsertFoodActivity.class));
        break;
}
    }
}
