package com.example.smartcity_0715.bus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.bus.adapter.BusStationAdapter;
import com.example.smartcity_0715.bus.pojo.Bus;
import com.example.smartcity_0715.bus.pojo.BusStop;
import com.example.smartcity_0715.databinding.ActivityBusDetailBinding;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

public class BusDetailActivity extends AppCompatActivity {
    private ActivityBusDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBusDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("巴士详情");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getIntExtra("id", 0);

        getData(id);
        getStations(id);

        binding.busNextBtn.setOnClickListener(view -> {
            Intent intent = new Intent(BusDetailActivity.this,BusDataActivity.class);
            intent.putExtra("id",id);
            startActivity(intent);
        });


    }

    private void getStations(int id) {
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/bus/stop/list?linesId="+id,"rows", BusStop.class).thenAccept(busStops -> {
           runOnUiThread(()->{
               binding.busDetailStations.setLayoutManager(new GridLayoutManager(this,1));
               binding.busDetailStations.setAdapter(new BusStationAdapter(R.layout.layout_bus_stop,busStops));
           });
        });
    }

    private void getData(int id) {
        MyTaskManger.getData(MyNetManger.SERVER_IP+"/prod-api/api/bus/line/"+id,"data", Bus.class).thenAccept(bus -> {
           runOnUiThread(()->{
               binding.busDetailStart.setText(bus.getFirst());
               binding.busDetailEnd.setText(bus.getEnd());
               binding.busDetailPay.setText("¥ "+bus.getPrice()+"元");
               binding.busDetailKm.setText("全程"+bus.getMileage()+"km");
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