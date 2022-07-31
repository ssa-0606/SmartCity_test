package com.example.smartcity_0715.metro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityMetroPageBinding;
import com.example.smartcity_0715.metro.adapter.LineAdapter;
import com.example.smartcity_0715.metro.pojo.Line;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MetroPageActivity extends AppCompatActivity {
    private ActivityMetroPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMetroPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("地铁总揽图");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getData();
        getImg();


    }

    private void getImg() {
        Thread thread = new Thread(()->{
            try {
                String result = MyNetManger.GET(MyNetManger.SERVER_IP + "/prod-api/api/metro/city");
                String string = new JSONObject(result).getJSONObject("data").getString("imgUrl");
                runOnUiThread(()->{
                    Glide.with(MetroPageActivity.this).load(MyNetManger.SERVER_IP+string).into(binding.metroMap);
                });
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        });
        thread.start();

    }

    private void getData() {

        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/metro/line/list","data", Line.class).thenAccept(lines -> {
            runOnUiThread(()->{
                binding.linList.setLayoutManager(new GridLayoutManager(MetroPageActivity.this,1));
                binding.linList.setAdapter(new LineAdapter(R.layout.layout_line,lines));
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