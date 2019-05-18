package com.example.foodplaza;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.foodplaza.model.Food;
import com.squareup.picasso.Picasso;

import java.util.List;

public final class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodViewHolder> {
    List<Food> foodList;


    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflate item_food_list and pass it to the FoodViewHolder
//        View view=View.inflate(context,R.layout.item_food_list,viewGroup);
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_food_list, viewGroup,false);


        FoodViewHolder foodViewHolder = new FoodViewHolder(view);

        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder foodViewHolder, int position) {

        Food food = foodList.get(position);


        foodViewHolder.foodNameTextView.setText(food.getFoodName());
        foodViewHolder.categoryTextView.setText(food.getFoodCategory());
        foodViewHolder.priceTextView.setText("" + food.getPrice());
        foodViewHolder.ratingTextView.setText("" + food.getFoodRating());
        foodViewHolder.ratingBar.setRating(food.getFoodRating());
//        foodViewHolder.foodImageView.setImageBitmap();

        Picasso.get().load(food.getFoodImageUrl()).into(foodViewHolder.foodImageView);

    }

    @Override
    public int getItemCount()
    {
        if(foodList!=null) {
            return foodList.size();
        }
        return 0;
    }

    public void setFoodList(List<Food> foodList)
    {
        this.foodList = foodList;
        notifyDataSetChanged();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImageView;
        TextView foodNameTextView;
        TextView priceTextView;
        TextView categoryTextView;
        TextView ratingTextView;
        RatingBar ratingBar;


        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImageView = itemView.findViewById(R.id.foodImageView);
            foodNameTextView = itemView.findViewById(R.id.foodNameTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            categoryTextView = itemView.findViewById(R.id.categoryTextView);
            ratingTextView = itemView.findViewById(R.id.ratingTextView);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }
    }
}
