package com.example.smartcity_0715.ui.myself;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityFeedBinding;

public class FeedActivity extends AppCompatActivity {

    private ActivityFeedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFeedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("提交意见");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        binding.editFeed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()>150){
                    binding.editFeed.setText(charSequence.subSequence(0,149));
                    binding.editFeed.setSelection(149);
                }
                binding.textView10.setText(charSequence.length()+"/150");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.button5.setOnClickListener(view -> {
            if(TextUtils.isEmpty(binding.editFeed.getText())){
                Toast.makeText(this, "请输入您的意见", Toast.LENGTH_SHORT).show();
            }else{
                binding.editFeed.setText("");
                Toast.makeText(this, "提交意见成功，我们会仔细听取您的意见", Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}