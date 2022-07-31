package com.example.smartcity_0715.ui.myself;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityLogInBinding;
import com.example.smartcity_0715.tools.MyNetManger;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class LogInActivity extends AppCompatActivity {

    private ActivityLogInBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("登录账户");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sharedPreferences = getSharedPreferences("data",0);
        editor = sharedPreferences.edit();

        binding.button3.setOnClickListener(view -> {
            if(TextUtils.isEmpty(binding.loginUsername.getText())||TextUtils.isEmpty(binding.loginPwd.getText())){
                Toast.makeText(this, "请输入账号和密码", Toast.LENGTH_SHORT).show();
            }else{
                dosubmit();
            }
        });


    }

    private void dosubmit() {
        Thread thread = new Thread(()->{

            String username  = binding.loginUsername.getText().toString();
            String pwd = binding.loginPwd.getText().toString();
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("username",username);
                jsonObject.put("password",pwd);
                String result = MyNetManger.POST(MyNetManger.SERVER_IP + "/prod-api/api/login", jsonObject.toString());
                int code = new JSONObject(result).getInt("code");
                if(code == 200){
                    String token = new JSONObject(result).getString("token");
                    runOnUiThread(()->{
                        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                        editor.putString("username",username);
                        editor.putString("password",pwd);
                        editor.putString("token",token);
                        editor.commit();
                        // TODO: 2022/7/18 退回首页（个人中心页面）
                        finish();
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