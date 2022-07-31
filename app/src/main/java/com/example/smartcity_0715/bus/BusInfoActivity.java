package com.example.smartcity_0715.bus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.R;
import com.example.smartcity_0715.bus.adapter.BusStationAdapter;
import com.example.smartcity_0715.bus.pojo.Bus;
import com.example.smartcity_0715.bus.pojo.BusStop;
import com.example.smartcity_0715.databinding.ActivityBusInfoBinding;
import com.example.smartcity_0715.pojo.UserInfo;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

import java.util.ArrayList;
import java.util.List;

public class BusInfoActivity extends AppCompatActivity {
    private ActivityBusInfoBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBusInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("data",0);
        editor = sharedPreferences.edit();

        getSupportActionBar().setTitle("用户信息");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getIntExtra("id", 1);
        getData(id);
        getUserInfo();
        getStations(id);

        binding.busInfoUp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/bus/stop/list?linesId="+id,"rows", BusStop.class).thenAccept(busStops -> {
                    runOnUiThread(()->{
                        List<String> list = new ArrayList<>();
                        for (int j = (i+1); j < busStops.size(); j++) {
                            list.add(busStops.get(j).getName());
                        }
                        binding.busInfoDown.setAdapter(new ArrayAdapter<String>(BusInfoActivity.this,android.R.layout.simple_list_item_1,list));
                    });
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.busInfoJump.setOnClickListener(view -> {
            editor.putString("bus_shang",binding.busInfoUp.getSelectedItem().toString());
            editor.putString("bus_xia",binding.busInfoDown.getSelectedItem().toString());
            editor.commit();
            Intent intent = new Intent(BusInfoActivity.this,BusOrderActivity.class);
            intent.putExtra("id",id);
            startActivity(intent);
        });

    }

    private void getData(int id) {
        MyTaskManger.getData(MyNetManger.SERVER_IP+"/prod-api/api/bus/line/"+id,"data", Bus.class).thenAccept(bus -> {
            runOnUiThread(()->{
                binding.busInfoFirst.setText(bus.getFirst());
                binding.busInfoEnd.setText(bus.getEnd());
                binding.busInfoLine.setText(bus.getName());
            });
        });
    }

    private void getUserInfo() {
        MyTaskManger.getDataByToken(MyNetManger.SERVER_IP+"/prod-api/api/common/user/getInfo","user", UserInfo.class,sharedPreferences.getString("token","k")).thenAccept(userInfo -> {
            runOnUiThread(()->{
                if(userInfo!=null){
                    binding.busInfoNick.setText(userInfo.getNickName());
                    String phone = userInfo.getPhonenumber().substring(0,userInfo.getPhonenumber().length()-4)+"****";
                    binding.busInfoPhone.setText(phone);
                }else{
                    Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    private void getStations(int id) {
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/bus/stop/list?linesId="+id,"rows", BusStop.class).thenAccept(busStops -> {
            runOnUiThread(()->{
                List<String> up = new ArrayList<>();
                for (int i = 0; i < busStops.size() - 1; i++) {
                    up.add(busStops.get(i).getName());
                }
                binding.busInfoUp.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,up));
                List<String> down = new ArrayList<>();
                for (int i = 1; i < busStops.size(); i++) {
                    down.add(busStops.get(i).getName());
                }
                binding.busInfoDown.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,down));
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