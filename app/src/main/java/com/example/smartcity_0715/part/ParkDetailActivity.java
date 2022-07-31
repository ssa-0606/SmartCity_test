package com.example.smartcity_0715.part;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityParkDetailBinding;
import com.example.smartcity_0715.databinding.ActivityPressDetailBinding;
import com.example.smartcity_0715.part.pojo.ParkSpace;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

public class ParkDetailActivity extends AppCompatActivity {

    private ActivityParkDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityParkDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("停车场详情");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);

        getData(id);


    }

    private void getData(int id) {
        MyTaskManger.getData(MyNetManger.SERVER_IP+"/prod-api/api/park/lot/"+id,"data", ParkSpace.class).thenAccept(parkSpace -> {
           runOnUiThread(()->{
               binding.parkName.setText(parkSpace.getParkName());
               binding.parkDistance.setText(parkSpace.getDistance()+"公里");
               if(parkSpace.getOpen().equals("Y")){
                    binding.isOpen.setText("对外开放");
               }else{
                   binding.isOpen.setText("暂未开放");
               }
               binding.detailAddr.setText(parkSpace.getAddress());
               binding.detailRates.setText(parkSpace.getRates()+"元/小时");
               binding.detailCars.setText(parkSpace.getVacancy()+"个/90");
               binding.detailCaps.setText("每小时"+parkSpace.getRates()+"元，最高"+parkSpace.getPriceCaps()+"一天");
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