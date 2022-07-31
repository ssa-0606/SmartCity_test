package com.example.smartcity_0715.bus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.smartcity_0715.databinding.ActivityBusDataBinding;

import java.util.Calendar;

public class BusDataActivity extends AppCompatActivity {

    private ActivityBusDataBinding binding;
    private String data;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBusDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("data",0);
        editor = sharedPreferences.edit();

        getSupportActionBar().setTitle("乘车日期");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getIntExtra("id", 1);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        data = year+"年"+month+"月"+day+"日";
        binding.busDataTxt.setText("您乘车的日期为："+year+"年"+month+"月"+day+"日");
        binding.calendarView.setOnDateChangeListener((calendarView, i, i1, i2) -> {
            binding.busDataTxt.setText("您的乘车日期为："+i+"年"+(i1+1)+"月"+i2+"日");
            data = i+"年"+(i1+1)+"月"+i2+"日";
        });

        binding.busInfoNext.setOnClickListener(view -> {
            editor.putString("bus_date",data);
            editor.commit();
            Intent intent = new Intent(BusDataActivity.this,BusInfoActivity.class);
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