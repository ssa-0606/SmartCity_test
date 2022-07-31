package com.example.smartcity_0715.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityPressDetailBinding;
import com.example.smartcity_0715.event.EventDetailActivity;
import com.example.smartcity_0715.event.pojo.Event;
import com.example.smartcity_0715.pojo.Press;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

public class PressDetailActivity extends AppCompatActivity {

    private ActivityPressDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPressDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        getData(id);

    }

    private void getData(int id) {
        MyTaskManger.getData(MyNetManger.SERVER_IP+"/prod-api/press/press/"+id,"data", Press.class).thenAccept(press -> {
            runOnUiThread(()->{
                getSupportActionBar().setTitle(press.getTitle());
                Glide.with(PressDetailActivity.this).load(MyNetManger.SERVER_IP+press.getCover()).into(binding.pressDetailImg);
                StringBuilder builder = new StringBuilder(press.getContent());
                String str = "<img src=\"";
                int i = builder.indexOf(str);
                while (i!=-1){
                    builder.insert(i+str.length(),MyNetManger.SERVER_IP);
                    i = builder.indexOf(str,i+str.length()+MyNetManger.SERVER_IP.length()-1);
                }
                Log.d("TAG", "onCreate: "+builder.toString());
                String replace = builder.toString().replace("<img", "<img width=\"100%\"");
                binding.pressWeb.setBackgroundColor(0);
                binding.pressWeb.getSettings().setDomStorageEnabled(true);
                binding.pressWeb.getSettings().setJavaScriptEnabled(true);//支持js
                binding.pressWeb.loadDataWithBaseURL(null,replace,"text/html","UTF-8",null);
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