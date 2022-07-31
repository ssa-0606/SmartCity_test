package com.example.smartcity_0715.event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityEventBinding;
import com.example.smartcity_0715.event.adapter.EventListAdapter;
import com.example.smartcity_0715.event.pojo.Event;
import com.example.smartcity_0715.pojo.LunBo;
import com.example.smartcity_0715.pojo.PressCate;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;
import com.google.android.material.tabs.TabLayout;

public class EventActivity extends AppCompatActivity {

    private ActivityEventBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEventBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("活动管理");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        getLunBo();
        getTab();
        getList(1);

        binding.eventTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                getList((Integer) tab.getTag());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void getList(int id) {

        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/activity/activity/list?categoryId="+id,"rows", Event.class).thenAccept(events -> {
           runOnUiThread(()->{
               events.sort((t1,t2)->t2.getPublishTime().compareTo(t1.getPublishTime()));
               binding.eventList.setLayoutManager(new GridLayoutManager(EventActivity.this,1));
               binding.eventList.setAdapter(new EventListAdapter(R.layout.layout_event_list,events));
           });
        });

    }

    private void getTab() {
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/activity/category/list","data", PressCate.class).thenAccept(pressCates -> {
           runOnUiThread(()->{
               for (PressCate pressCate : pressCates) {
                   binding.eventTab.addTab(binding.eventTab.newTab().setText(pressCate.getName()).setTag(pressCate.getId()));
               }
           });
        });
    }

    private void getLunBo() {
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/activity/rotation/list","rows", LunBo.class).thenAccept(lunBos -> {
            runOnUiThread(()->{
                for (LunBo lunBo : lunBos) {
                    ImageView imageView = new ImageView(EventActivity.this);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    Log.d("TAG", "getData: "+MyNetManger.SERVER_IP+lunBo.getAdvImg());
                    Glide.with(EventActivity.this).load(MyNetManger.SERVER_IP+lunBo.getAdvImg()).into(imageView);
                    binding.eventVf.addView(imageView);
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