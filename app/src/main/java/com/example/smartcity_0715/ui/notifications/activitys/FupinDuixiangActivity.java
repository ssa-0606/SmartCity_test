package com.example.smartcity_0715.ui.notifications.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.smartcity_0715.databinding.ActivityFupinDuixiangBinding;

public class FupinDuixiangActivity extends AppCompatActivity {

    private ActivityFupinDuixiangBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFupinDuixiangBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("扶贫对象详情");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getIntExtra("id", 0);


        String[] names = new String[]{"小明","小刚","华强","小德","小李","小花","小志","小刘","小芳","小军"};
        String[] country=new String[]{"大明村","约克村","库伦村","鲁尔村","木叶村","基辅村","多伦村","高雄村","杜王町村","华盛村"};
        String[] ages = new  String[]{"45","34","45","56","46","45","67","45","34","35"};

        binding.duixiangName.setText("姓名："+names[id]);
        binding.duixiangAge.setText("年龄："+ages[id]);
        binding.duixiangSex.setText("性别：男");


        binding.cunqingJump.setOnClickListener(view -> {
            Intent intent = new Intent(FupinDuixiangActivity.this,CunQingActivity.class);
            intent.putExtra("id",id);
            startActivity(intent);
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}