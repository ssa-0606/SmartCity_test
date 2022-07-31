package com.example.smartcity_0715.metro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityMetroDetailBinding;
import com.example.smartcity_0715.metro.adapter.StationAdapter;
import com.example.smartcity_0715.metro.pojo.Station;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

public class MetroDetailActivity extends AppCompatActivity {

    private ActivityMetroDetailBinding binding;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMetroDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getIntExtra("id", 31);

        getData(id);

    }

    private void getData(int id) {

        MyTaskManger.getData(MyNetManger.SERVER_IP+"/prod-api/api/metro/line/"+id,"data", Station.class).thenAccept(station -> {
            runOnUiThread(()->{
                getSupportActionBar().setTitle(station.getName());
                binding.metroStart.setText(station.getFirst());
                binding.metroEnd.setText(station.getEnd());
                binding.metroDetailTime.setText(station.getRemainingTime()+"分钟");
                binding.metroDetailKm.setText(station.getStationsNumber()+"站/"+station.getKm()+"km");
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MetroDetailActivity.this, LinearLayoutManager.HORIZONTAL, false);
                binding.metrolStation.setLayoutManager(linearLayoutManager);
                binding.metrolStation.setAdapter(new StationAdapter(R.layout.layout_station,station.getMetroStepList(),station.getRunStationsName()));
                for (int i = 0; i < station.getMetroStepList().size(); i++) {

                    if(TextUtils.equals(station.getRunStationsName(),station.getMetroStepList().get(i).getName())){
                        linearLayoutManager.scrollToPosition(i);
                    }
                }
            });
        });

    }


}