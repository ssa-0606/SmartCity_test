package com.example.smartcity_0715.ui.myself;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityChagePwdBinding;
import com.example.smartcity_0715.tools.MyNetManger;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;

public class ChagePwdActivity extends AppCompatActivity {

    private ActivityChagePwdBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChagePwdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("data",0);
        editor = sharedPreferences.edit();

        getSupportActionBar().setTitle("修改密码");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.button4.setOnClickListener(view -> {
            if(TextUtils.isEmpty(binding.editOldPwd.getText())|| TextUtils.isEmpty(binding.editNewPwd.getText())){
                Toast.makeText(this, "输入内容不得为空", Toast.LENGTH_SHORT).show();
            }else{
                do_change();
            }
        });


    }

    private void do_change() {
        Thread thread = new Thread(()->{
            try {
                String oldPwd = binding.editOldPwd.getText().toString();
                String newPwd = binding.editNewPwd.getText().toString();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("newPassword",newPwd);
                jsonObject.put("oldPassword",oldPwd);
                String result = MyNetManger.PUT_T(MyNetManger.SERVER_IP+"/prod-api/api/common/user/resetPwd", jsonObject.toString(), sharedPreferences.getString("token", "k"));
                int code = new JSONObject(result).getInt("code");
                if(code == 200){
                    runOnUiThread(()->{
                        Toast.makeText(this, "密码修改成功", Toast.LENGTH_SHORT).show();
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