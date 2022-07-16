package com.example.smartcity_0715.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityPressDetailBinding;

public class PressDetailActivity extends AppCompatActivity {

    private ActivityPressDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPressDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String content = intent.getStringExtra("content");
        binding.pressWeb.loadDataWithBaseURL(null,content,"text/html","UTF-8",null);


    }
}