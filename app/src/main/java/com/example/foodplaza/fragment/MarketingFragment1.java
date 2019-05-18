package com.example.foodplaza.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.foodplaza.LoginActivity;
import com.example.foodplaza.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class
MarketingFragment1 extends Fragment {

    Button skipButton;

    public MarketingFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this com.example.recyclerviewdemo.fragment
        View view=inflater.inflate(R.layout.fragment_marketing_fragment1, container, false);
       skipButton= view.findViewById(R.id.skipButton);

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });


        return view;

    }

}
