package com.example.smartcity_0715.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityPingLunBinding;
import com.example.smartcity_0715.library.adapter.PingLunAdapter;
import com.example.smartcity_0715.pojo.PingLun;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

public class PingLunActivity extends AppCompatActivity {

    private ActivityPingLunBinding binding;
    private SharedPreferences sharedPreferences;
    private int num = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPingLunBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("data",0);

        getSupportActionBar().setTitle("评论");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getIntExtra("id", 10);

        getData(id,num);

        binding.pinglunMore.setOnClickListener(view -> {
            getData(id,++num);
        });

        binding.button6.setOnClickListener(view -> {
            if(TextUtils.isEmpty(binding.pinglunEdit.getText())){
                Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
            }else{
                comment(id);
            }
        });

    }

    private void comment(int id) {
        Thread thread = new Thread(()->{
            try {
                Log.d("TAG", "comment: "+id);

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("libraryId",id);
                jsonObject.put("content",binding.pinglunEdit.getText().toString());
                String result = MyNetManger.POST_T(MyNetManger.SERVER_IP + "/prod-api/api/digital-library/library-comment", jsonObject.toString(), sharedPreferences.getString("token", "k"));
                Log.d("TAG", "comment: "+result);
                JSONObject jsonObject1 = new JSONObject(result);
                int code = jsonObject1.getInt("code");
                String msg = jsonObject1.getString("msg");
                Log.d("TAG", "comment: "+code +msg);
                if(code == 200){
                    runOnUiThread(()->{
                        Toast.makeText(this, "评论成功", Toast.LENGTH_SHORT).show();
                        binding.pinglunEdit.setText("");
                        getData(id,1);
                    });
                }else{
                    runOnUiThread(()->{
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                        binding.pinglunEdit.setText("");
                    });
                }
            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    private void getData(int id,int num) {
        MyTaskManger.getListDataByToken(MyNetManger.SERVER_IP+"/prod-api/api/digital-library/library-comment/list?libraryId="+id+"&pageNum="+(num-1)+"&pageSize="+(num*10),"data", PingLun.class,sharedPreferences.getString("token","k")).thenAccept(pingLuns -> {
           runOnUiThread(()->{
               binding.pinglunList.setLayoutManager(new GridLayoutManager(this,1));
               binding.pinglunList.setAdapter(new PingLunAdapter(R.layout.layout_pinglun,pingLuns));
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