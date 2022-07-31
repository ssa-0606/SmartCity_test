package com.example.smartcity_0715.ui.notifications.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityAnliBinding;
import com.example.smartcity_0715.ui.notifications.anli.Anli;
import com.example.smartcity_0715.ui.notifications.anli.Data;

public class AnliActivity extends AppCompatActivity {
    private ActivityAnliBinding binding;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_anli,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAnliBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("案例发布");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.anliBtn.setOnClickListener(view -> {
            if(TextUtils.isEmpty(binding.anliTitle.getText())||TextUtils.isEmpty(binding.anliContent.getText())){
                Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
            }else{
                String title = binding.anliTitle.getText().toString();
                String content = binding.anliContent.getText().toString();
                Anli anli = new Anli(title,content);
                Data.anlis.add(anli);
                Toast.makeText(this, "案例提交成功", Toast.LENGTH_SHORT).show();
                binding.anliTitle.setText("");
                binding.anliContent.setText("");
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.anli:
                Intent intent = new Intent(AnliActivity.this,MyAnliActivity.class);
                AnliActivity.this.startActivity(intent);
                break;
        }
        return true;
    }
}