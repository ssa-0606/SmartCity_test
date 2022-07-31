package com.example.smartcity_0715.event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityEventDetailBinding;
import com.example.smartcity_0715.event.adapter.EventListAdapter;
import com.example.smartcity_0715.event.pojo.Event;
import com.example.smartcity_0715.library.PingLunActivity;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class EventDetailActivity extends AppCompatActivity {

    private ActivityEventDetailBinding binding;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEventDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("data",0);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 47);

        getData(id);
        getTuijian();

        binding.signBtn.setOnClickListener(view -> {
            new Thread(()->{
                try {
                    String result = MyNetManger.GET_T(MyNetManger.SERVER_IP + "/prod-api/api/activity/signup/check?activityId=" + id, sharedPreferences.getString("token", "k"));
                    JSONObject jsonObject = new JSONObject(result);
                    int code = jsonObject.getInt("code");
                    if(code == 200){
                        boolean isSignup = jsonObject.getBoolean("isSignup");
                        if(isSignup){
                            runOnUiThread(()->{
                                Toast.makeText(this, "您已经报名过此活动了", Toast.LENGTH_SHORT).show();
                            });
                        }else{
                            JSONObject jsonObject1 = new JSONObject();
                            jsonObject1.put("activityId",id);
                            String s = MyNetManger.POST_T(MyNetManger.SERVER_IP + "/prod-api/api/activity/signup", jsonObject1.toString(), sharedPreferences.getString("token", "k"));
                            int code1 = new JSONObject(s).getInt("code");
                            if(code1 == 200){
                                runOnUiThread(()->{
                                    Toast.makeText(this, "报名成功", Toast.LENGTH_SHORT).show();
                                });
                            }else{
                                runOnUiThread(()->{
                                    Toast.makeText(this, "请重试", Toast.LENGTH_SHORT).show();
                                });
                            }
                        }
                    }else{
                        runOnUiThread(()->{
                            Toast.makeText(this, "请登录后在尝试", Toast.LENGTH_SHORT).show();
                        });
                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }).start();
        });

        binding.commentJump.setOnClickListener(view -> {
            Intent intent1 = new Intent(EventDetailActivity.this, EventPingLunActivity.class);
            intent1.putExtra("id",id);
            startActivity(intent1);
        });

    }

    private void getTuijian() {
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/activity/activity/list?recommend=Y","rows", Event.class).thenAccept(events -> {
            runOnUiThread(()->{
                events.sort((t1,t2)->t2.getPublishTime().compareTo(t1.getPublishTime()));
                binding.tuijianEvent.setLayoutManager(new GridLayoutManager(EventDetailActivity.this,1));
                binding.tuijianEvent.setAdapter(new EventListAdapter(R.layout.layout_event_list,events));
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

    private void getData(int id) {
        MyTaskManger.getData(MyNetManger.SERVER_IP+"/prod-api/api/activity/activity/"+id,"data", Event.class).thenAccept(event -> {
           runOnUiThread(()->{
               getSupportActionBar().setTitle(event.getName());
               Glide.with(EventDetailActivity.this).load(MyNetManger.SERVER_IP+event.getImgUrl()).into(binding.eventDetailImg);
               StringBuilder builder = new StringBuilder(event.getContent());
               String replace = builder.toString().replace("<img", "<img width=\"100%\"");
               binding.myWeb.setBackgroundColor(0);
               binding.myWeb.getSettings().setJavaScriptEnabled(true);//支持js
               binding.myWeb.loadDataWithBaseURL(null,replace,"text/html","UTF-8",null);
           });
        });
    }

}