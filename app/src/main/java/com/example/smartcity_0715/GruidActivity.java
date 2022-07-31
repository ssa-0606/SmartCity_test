package com.example.smartcity_0715;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.smartcity_0715.databinding.ActivityGruidBinding;

public class GruidActivity extends AppCompatActivity {

    private ActivityGruidBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGruidBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("引导页");



    }


}