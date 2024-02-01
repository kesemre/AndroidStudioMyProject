package com.example.sixminutewalktest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sixminutewalktest.databinding.ActivityResultMenuBinding;

public class resultMenu extends AppCompatActivity {
    int age,weight,range,lenght;
    boolean sex;
    float result;



    private ActivityResultMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultMenuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        age = intent.getIntExtra("age",0);
        range = intent.getIntExtra("mesafe",0);
        weight = intent.getIntExtra("weight",0);
        lenght = intent.getIntExtra("length",0);
        sex = intent.getBooleanExtra("sex",true);
        if(sex){
            result = (float)(7.57*lenght -(5.02*age) -(1.76*weight)) ;
        }
        else result = (float) ((2.11*lenght)-(2.29*weight)-(5.78*age));
        if ( range/result>=0.8f)  binding.imageView.setImageResource(R.drawable.faster);
        else if (range/result>=0.6f) {
            binding.imageView.setImageResource(R.drawable.fast);
        } else if (range/result>=0.4f) { binding.imageView.setImageResource(R.drawable.normal);
        } else if (range/result>=0.2f) {binding.imageView.setImageResource(R.drawable.slow);
        }
        else binding.imageView.setImageResource(R.drawable.slower);
    }
}