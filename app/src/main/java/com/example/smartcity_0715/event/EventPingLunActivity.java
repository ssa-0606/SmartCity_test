package com.example.smartcity_0715.event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityEventPingLunBinding;
import com.example.smartcity_0715.event.adapter.CommentAdapter;
import com.example.smartcity_0715.event.pojo.Comment;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class EventPingLunActivity extends AppCompatActivity {
    private ActivityEventPingLunBinding binding;
    private int i = 1;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEventPingLunBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("data",0);

        getSupportActionBar().setTitle("评论页面");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getIntExtra("id",47);

        getData(id,i);

        binding.pinglunMore.setOnClickListener(view -> {
            getData(id,++i);
        });

        getCount(id);

        binding.button6.setOnClickListener(view -> {

            if(TextUtils.isEmpty(binding.pinglunEdit.getText())){
                Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
            }else{
                comment(id);
            }

        });


    }

    private void comment(int id) {
        new Thread(()->{
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("activityId",id);
                jsonObject.put("content",binding.pinglunEdit.getText());
                String s = MyNetManger.POST_T(MyNetManger.SERVER_IP + "/prod-api/api/activity/comment", jsonObject.toString(), sharedPreferences.getString("token", "k"));
                int code = new JSONObject(s).getInt("code");
                if(code == 200){
                    runOnUiThread(()->{
                        Toast.makeText(this, "评论成功", Toast.LENGTH_SHORT).show();
                        binding.pinglunEdit.setText("");
                        getData(id,1);
                        getCount(id);
                    });
                }else{
                    runOnUiThread(()->{
                        Toast.makeText(this, "请重新登录后继续尝试", Toast.LENGTH_SHORT).show();
                    });
                }
            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }

        }).start();
    }

    private void getCount(int id) {
        new Thread(()->{
            try {
                String get = MyNetManger.GET(MyNetManger.SERVER_IP + "/prod-api/api/activity/comment/number?activityId=" + id);
                int count = new JSONObject(get).getInt("commentNum");
                runOnUiThread(()->{
                    binding.pinglunCount.setText("共有"+count+"条评论");
                });
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void getData(int id,int i) {
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/activity/comment/list?activityId="+id+"&pageNum=1&pageSize="+(i*10),"rows", Comment.class).thenAccept(comments -> {
           runOnUiThread(()->{
               binding.pinglunList.setLayoutManager(new GridLayoutManager(EventPingLunActivity.this,1));
               binding.pinglunList.setAdapter(new CommentAdapter(R.layout.layout_pinglun1,comments));
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
        return  true;
    }
}