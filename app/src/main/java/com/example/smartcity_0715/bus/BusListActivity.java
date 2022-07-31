package com.example.smartcity_0715.bus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.bus.adapter.BusListAdapter;
import com.example.smartcity_0715.bus.pojo.Bus;
import com.example.smartcity_0715.bus.pojo.BusStop;
import com.example.smartcity_0715.databinding.ActivityBusListBinding;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

public class BusListActivity extends AppCompatActivity {

    private ActivityBusListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBusListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("定制班车");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getData();



    }



    private void getData() {
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/bus/line/list","rows", Bus.class).thenAccept(buses -> {
           runOnUiThread(()->{
               binding.busList.setLayoutManager(new GridLayoutManager(this,1));
               binding.busList.setAdapter(new BusListAdapter(R.layout.layout_bus_list,buses));
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