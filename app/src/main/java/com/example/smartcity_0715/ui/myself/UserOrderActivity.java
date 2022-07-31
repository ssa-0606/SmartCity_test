package com.example.smartcity_0715.ui.myself;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityUserOrderBinding;
import com.example.smartcity_0715.pojo.OrderBus;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;
import com.example.smartcity_0715.ui.myself.adapter.OrderPayAdapter;

public class UserOrderActivity extends AppCompatActivity {

    private ActivityUserOrderBinding binding;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("data",0);

        getSupportActionBar().setTitle("用户订单");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.noPay.setOnClickListener(view -> {
            getPayData(0);
            binding.noPay.setBackgroundColor(Color.parseColor("#64B5F6"));
            binding.noPay.setTextColor(Color.parseColor("#F3F0F0"));
            binding.pay.setBackgroundColor(Color.parseColor("#FFFEFE"));
            binding.pay.setTextColor(Color.parseColor("#64B5F6"));
        });

        binding.pay.setOnClickListener(view -> {
            getPayData(1);
            binding.pay.setBackgroundColor(Color.parseColor("#64B5F6"));
            binding.pay.setTextColor(Color.parseColor("#F3F0F0"));
            binding.noPay.setBackgroundColor(Color.parseColor("#FFFEFE"));
            binding.noPay.setTextColor(Color.parseColor("#64B5F6"));
        });

        getPayData(0);




    }

    private void getPayData(int status) {
        MyTaskManger.getListDataByToken(MyNetManger.SERVER_IP+"/prod-api/api/bus/order/list?status="+status,"rows", OrderBus.class,sharedPreferences.getString("token","k")).thenAccept(orderBuses -> {
            runOnUiThread(()->{
                if(orderBuses.size()>0){
                    binding.noData.setVisibility(View.GONE);
                    binding.orderList.setVisibility(View.VISIBLE);
                    binding.orderList.setLayoutManager(new GridLayoutManager(UserOrderActivity.this,1));
                    binding.orderList.setAdapter(new OrderPayAdapter(R.layout.layout_order_pay_list,orderBuses));
                }else{
                    binding.noData.setVisibility(View.VISIBLE);
                    binding.orderList.setVisibility(View.GONE);
                }
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