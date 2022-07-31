package com.example.smartcity_0715.part;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityParkListBinding;
import com.example.smartcity_0715.part.adapter.ParkListAdapter;
import com.example.smartcity_0715.part.pojo.ParkSpace;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

import java.util.ArrayList;
import java.util.List;

public class ParkListActivity extends AppCompatActivity {

    private ActivityParkListBinding binding;
    private int i = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityParkListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("停哪儿");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getData(i);

        binding.button2.setOnClickListener(view -> {
            i = i+3;
            getData(i);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.park_menu,menu);
        return true;
    }

    private void getData(int i) {
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/park/lot/list","rows", ParkSpace.class).thenAccept(parkSpaces -> {
            parkSpaces.sort((t1,t2)->Integer.valueOf(t1.getDistance())-Integer.valueOf(t2.getDistance()));
            List<ParkSpace> list = new ArrayList<>();
            if(parkSpaces.size()<=i){
                runOnUiThread(()->{
                    Toast.makeText(this, "已经加载全部", Toast.LENGTH_SHORT).show();
                });
            }
            for (int j = 0; j < i; j++) {
                list.add(parkSpaces.get(j));
            }
            runOnUiThread(()->{
                Log.d("TAG", "getData: "+parkSpaces.size()+i);
                binding.recyclerView.setLayoutManager(new GridLayoutManager(ParkListActivity.this,1));
                binding.recyclerView.setAdapter(new ParkListAdapter(R.layout.layout_list_card,list));
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
                Intent intent = new Intent(this,RecordActivity.class);
                startActivity(intent);
                break;
        }
        return false;
    }
}