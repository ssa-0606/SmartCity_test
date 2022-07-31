package com.example.smartcity_0715.bus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.smartcity_0715.bus.pojo.Bus;
import com.example.smartcity_0715.databinding.ActivityBusOrderBinding;
import com.example.smartcity_0715.pojo.UserInfo;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;
import com.example.smartcity_0715.ui.myself.UserOrderActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class BusOrderActivity extends AppCompatActivity {
    private ActivityBusOrderBinding binding;
    private SharedPreferences sharedPreferences;
    private String line;
    private String price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBusOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("data",0);

        getSupportActionBar().setTitle("确定订单");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getIntExtra("id",0);
        getData(id);
        getUserInfo();
        binding.busOrderUp.setText("上车地点："+sharedPreferences.getString("bus_shang",""));
        binding.busOrderDown.setText("下车地点："+sharedPreferences.getString("bus_xia",""));
        binding.busOrderDate.setText("乘车日期："+sharedPreferences.getString("bus_date",""));

        binding.busOrderSubmit.setOnClickListener(view -> {
            doSubmit();
        });

    }

    private void doSubmit() {

        new Thread(()->{
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("start",sharedPreferences.getString("bus_shang",""));
                jsonObject.put("end",sharedPreferences.getString("bus_xia",""));
                jsonObject.put("price",price);
                jsonObject.put("path",line);
                jsonObject.put("status",0);

                String result = MyNetManger.POST_T(MyNetManger.SERVER_IP + "/prod-api/api/bus/order", jsonObject.toString(), sharedPreferences.getString("token", "k"));
                int code = new JSONObject(result).getInt("code");
                if(code == 200){
                    runOnUiThread(()->{
                        Toast.makeText(this, "订单提交成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BusOrderActivity.this, UserOrderActivity.class);
                        startActivity(intent);
                    });
                }

            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
        }).start();

    }

    private void getUserInfo() {
        MyTaskManger.getDataByToken(MyNetManger.SERVER_IP+"/prod-api/api/common/user/getInfo","user", UserInfo.class,sharedPreferences.getString("token","k")).thenAccept(userInfo -> {
            runOnUiThread(()->{
                if(userInfo!=null){
                    binding.busOrderNick.setText(userInfo.getNickName());
                    String phone = userInfo.getPhonenumber().substring(0,userInfo.getPhonenumber().length()-4)+"****";
                    binding.busOrderPhone.setText(phone);
                }else{
                    Toast.makeText(this, "请先登录", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    private void getData(int id) {
        MyTaskManger.getData(MyNetManger.SERVER_IP+"/prod-api/api/bus/line/"+id,"data", Bus.class).thenAccept(bus -> {
            line = bus.getName();
            price = String.valueOf(bus.getPrice());
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