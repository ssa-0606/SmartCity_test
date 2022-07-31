package com.example.smartcity_0715.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityLibraryDetailBinding;
import com.example.smartcity_0715.library.pojo.Library;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

public class LibraryDetailActivity extends AppCompatActivity {

    private ActivityLibraryDetailBinding binding;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLibraryDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("data",0);

        getSupportActionBar().setTitle("图书馆详情");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getIntExtra("id", 10);

        getData(id);

        binding.commentJump.setOnClickListener(view -> {
            Intent intent = new Intent(LibraryDetailActivity.this,PingLunActivity.class);
            intent.putExtra("id",id);
            startActivity(intent);
        });


    }


    private void getData(int id) {
        MyTaskManger.getDataByToken(MyNetManger.SERVER_IP+"/prod-api/api/digital-library/library/"+id,"data", Library.class,sharedPreferences.getString("token","k")).thenAccept(library -> {
           runOnUiThread(()->{
               Glide.with(this).load(MyNetManger.SERVER_IP+library.getImgUrl()).into(binding.imageView5);
               binding.libraryDetailName.setText(library.getName());
               if(TextUtils.equals("1",library.getBusinessState())){
                   binding.libraryDetailState.setText("正在营业"); binding.libraryDetailState.setTextColor(Color.parseColor("#81C784"));
               }else{
                   binding.libraryDetailState.setText("暂停营业"); binding.libraryDetailState.setTextColor(Color.parseColor("#F06292"));
               }
               binding.libraryDetailContent.setText(library.getDescription());
               binding.libraryAddress.setText(library.getAddress());
               binding.libraryTime.setText(library.getBusinessHours());
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