package com.example.smartcity_0715.house;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityHouseListBinding;
import com.example.smartcity_0715.house.adapter.HouseListAdapter;
import com.example.smartcity_0715.house.adapter.HouseType;
import com.example.smartcity_0715.house.pojo.House;
import com.example.smartcity_0715.pojo.CityService;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

import java.util.ArrayList;
import java.util.List;

public class HouseListActivity extends AppCompatActivity {

    private ActivityHouseListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHouseListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("找房子");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] types = new String[]{"二手","租房","楼盘","中介"};
        binding.houseType.setLayoutManager(new GridLayoutManager(this,4));
        binding.houseType.setAdapter(new HouseType(R.layout.layout_service,types));

        getData("");

        binding.houseBtn.setOnClickListener(view -> {
            if(TextUtils.isEmpty(binding.houseSearch.getText())){
                Toast.makeText(this, "输入不得为空", Toast.LENGTH_SHORT).show();
            }else{
                doSearch(binding.houseSearch.getText().toString());
            }
        });

    }

    private void doSearch(String msg) {
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/house/housing/list?sourceName="+msg,"rows", House.class).thenAccept(houses -> {
            runOnUiThread(()->{
                binding.houseList.setLayoutManager(new GridLayoutManager(HouseListActivity.this,1));
                binding.houseList.setAdapter(new HouseListAdapter(R.layout.layout_house_list,houses));
            });
        });
    }

    public void getData(String type) {
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/house/housing/list?houseType="+type,"rows", House.class).thenAccept(houses -> {
           runOnUiThread(()->{
               binding.houseList.setLayoutManager(new GridLayoutManager(HouseListActivity.this,1));
               binding.houseList.setAdapter(new HouseListAdapter(R.layout.layout_house_list,houses));
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