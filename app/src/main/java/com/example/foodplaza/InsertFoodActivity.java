package com.example.foodplaza;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodplaza.databinding.ActivityInsertFoodBinding;
import com.example.foodplaza.model.Food;
import com.example.foodplaza.viewmodel.FoodViewModel;

public class InsertFoodActivity extends AppCompatActivity {

   // private ActivityInsertFoodBinding binding;
    ActivityInsertFoodBinding binding;
    private Food food;
    private FoodViewModel foodViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_insert_food);

        foodViewModel= ViewModelProviders.of(this).get(FoodViewModel.class);

        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    food = new Food();
                    food.setFoodName(binding.foodNameEditText.getText().toString());
                    food.setFoodCategory(binding.foodCategoryEditText.getText().toString());
                    food.setPrice(Double.parseDouble(binding.foodPriceEditText.getText().toString()));
                    food.setFoodRating(Integer.parseInt(binding.foodRatingEditText.getText().toString()));

                    foodViewModel.insert(food);
                    clearField();

                } catch (Throwable t) {
                    t.printStackTrace();
                }

            }
        });


        binding.listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InsertFoodActivity.this,MainActivity.class));
            }
        });
    }

    private void clearField() {
        binding.foodNameEditText.setText("");
        binding.foodCategoryEditText.setText("");
        binding.foodPriceEditText.setText("");
        binding.foodRatingEditText.setText("");
    }
}
