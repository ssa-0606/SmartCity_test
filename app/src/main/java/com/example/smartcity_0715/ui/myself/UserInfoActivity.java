package com.example.smartcity_0715.ui.myself;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityUserInfoBinding;
import com.example.smartcity_0715.pojo.UserInfo;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class UserInfoActivity extends AppCompatActivity {

    private ActivityUserInfoBinding binding;
    private SharedPreferences sharedPreferences ;
    private SharedPreferences.Editor editor;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("data",0);
        editor = sharedPreferences.edit();

        getSupportActionBar().setTitle("用户信息");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getData();

        binding.doChange.setOnClickListener(view -> {
            if(TextUtils.isEmpty(binding.editNick.getText())||TextUtils.isEmpty(binding.editPhone.getText())||TextUtils.isEmpty(binding.editEdit.getText())){
                Toast.makeText(this, "请补全用户信息后在确认", Toast.LENGTH_SHORT).show();
            }else{
                doChange();
            }
        });



    }

    private void doChange() {
        Thread thread = new Thread(()->{

            String nick = binding.editNick.getText().toString();
            String phone = binding.editPhone.getText().toString();
            String email = binding.editEdit.getText().toString();
            String sex = "0";
            if(binding.woman.isChecked()){
                sex = "1";
            }

            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("nickName",nick);
                jsonObject.put("phonenumber",phone);
                jsonObject.put("email",email);
                jsonObject.put("sex",sex);
                String result = MyNetManger.PUT_T(MyNetManger.SERVER_IP + "/prod-api/api/common/user", jsonObject.toString(), sharedPreferences.getString("token", "k"));
                int code = new JSONObject(result).getInt("code");
                if(code == 200){
                    runOnUiThread(()->{
                        Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                    });
                }else{
                    String msg = new JSONObject(result).getString("msg");
                    runOnUiThread(()->{
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                    });
                }

            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }

        });
        thread.start();
    }

    private void getData() {
        MyTaskManger.getDataByToken(MyNetManger.SERVER_IP+"/prod-api/api/common/user/getInfo","user", UserInfo.class,sharedPreferences.getString("token","k")).thenAccept(userInfo -> {
           runOnUiThread(()->{
               Glide.with(this).load(MyNetManger.SERVER_IP+userInfo.getAvatar()).into(binding.imageView4);
               binding.editNick.setText(userInfo.getNickName());
               String phone = userInfo.getPhonenumber().substring(0,userInfo.getPhonenumber().length()-4)+"****";
               binding.editPhone.setText(phone);
               if(TextUtils.equals("0",userInfo.getSex())){
                    binding.man.setChecked(true);
               }else{
                   binding.woman.setChecked(true);
               }
               binding.editEdit.setText(userInfo.getEmail());
           });
        });
    }
}