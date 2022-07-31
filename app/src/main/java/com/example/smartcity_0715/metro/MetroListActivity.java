package com.example.smartcity_0715.metro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityMetroListBinding;
import com.example.smartcity_0715.metro.adapter.MetroAdapter;
import com.example.smartcity_0715.metro.pojo.Metro;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

public class MetroListActivity extends AppCompatActivity {

    private ActivityMetroListBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMetroListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("城市地铁");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Glide.with(this).load(MyNetManger.SERVER_IP+"/prod-api/profile/upload/image/2021/05/10/3bfb33ee-459f-4878-b89b-4b125aa84013.png").into(binding.imageView8);

        getData();


    }

    private void getData() {

        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/metro/list?currentName=建国门","data", Metro.class).thenAccept(metros -> {
            runOnUiThread(()->{
                binding.metroList.setLayoutManager(new GridLayoutManager(MetroListActivity.this,1));
                binding.metroList.setAdapter(new MetroAdapter(R.layout.layout_metro_list,metros));
            });
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.record:
                Intent intent = new Intent(MetroListActivity.this,MetroPageActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.park_menu,menu);
        return true;
    }
}