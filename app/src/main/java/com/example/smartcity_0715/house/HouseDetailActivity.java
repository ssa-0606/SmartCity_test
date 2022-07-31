package com.example.smartcity_0715.house;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.databinding.ActivityHouseDetailBinding;
import com.example.smartcity_0715.house.pojo.House;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

public class HouseDetailActivity extends AppCompatActivity {

    private ActivityHouseDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHouseDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("详细信息");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getIntExtra("id",1);

        getData(id);

    }

    private void getData(int id) {

        MyTaskManger.getData(MyNetManger.SERVER_IP+"/prod-api/api/house/housing/"+id,"data", House.class).thenAccept(house -> {
           runOnUiThread(()->{
               binding.houseDetailName.setText(house.getSourceName());
               Glide.with(HouseDetailActivity.this).load(MyNetManger.SERVER_IP+house.getPic()).into(binding.houseDetailImg);
               binding.houseDetailDesc.setText(house.getDescription());
               binding.houseDetailType.setText(house.getHouseType());
               binding.houseDetailInfo.setText(house.getAreaSize()+"平方米  |  房价："+house.getPrice());
           });
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