package com.example.smartcity_0715.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityLibraryBinding;
import com.example.smartcity_0715.library.adapter.LibraryAdapter;
import com.example.smartcity_0715.library.pojo.Library;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

public class LibraryActivity extends AppCompatActivity {

    private ActivityLibraryBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLibraryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("data",0);
        editor = sharedPreferences.edit();

        getSupportActionBar().setTitle("数字图书");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getData();


    }

    private void getData() {
        MyTaskManger.getListDataByToken(MyNetManger.SERVER_IP+"/prod-api/api/digital-library/library/list","rows", Library.class,sharedPreferences.getString("token","k")).thenAccept(libraries -> {
           runOnUiThread(()->{
               if(libraries.size()<=0){
                   Toast.makeText(this, "请先登录在访问此模块", Toast.LENGTH_SHORT).show();
               }
               binding.libraryList.setLayoutManager(new GridLayoutManager(this,1));
               binding.libraryList.setAdapter(new LibraryAdapter(R.layout.layout_library_list,libraries));

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