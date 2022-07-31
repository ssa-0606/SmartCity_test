package com.example.smartcity_0715.ui.notifications.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.smartcity_0715.databinding.ActivityCunQingBinding;

public class CunQingActivity extends AppCompatActivity {
    private ActivityCunQingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCunQingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("村情");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getIntExtra("id", 0);

        String[] country=new String[]{"大明村","约克村","库伦村","鲁尔村","木叶村","基辅村","多伦村","高雄村","杜王町村","华盛村"};

        binding.cunName.setText("村庄名称："+country[id]);
        binding.cunAddress.setText("村庄地址：中华人民共和国XX省XX县XX镇"+country[id]);
        binding.cunDesc.setText("村庄简介："+country[id]+"地处偏僻，对外交流少，成年人外出打工，留在家里老人妇女和儿童，村里交通不发达，甚至生活物质匮乏，村里近一个学校共儿童们学习知识....");
        binding.cunCount.setText("村庄人数："+123);


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