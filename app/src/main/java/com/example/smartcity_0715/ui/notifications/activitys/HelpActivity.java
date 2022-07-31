package com.example.smartcity_0715.ui.notifications.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityHelpBinding;

public class HelpActivity extends AppCompatActivity {
    private ActivityHelpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHelpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("收到的求助信息");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.helpList.setLayoutManager(new GridLayoutManager(this,1));
        binding.helpList.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_help, null);
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(inflate) {};
                return holder;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                View itemView = holder.itemView;
                TextView textView = itemView.findViewById(R.id.help_name);
                textView.setText("张三"+position);
                TextView textView1 = itemView.findViewById(R.id.help_content);textView1.setText("我需要帮助");
                TextView textView2 = itemView.findViewById(R.id.help_address);textView2.setText("XX社区101号");
                TextView textView3 = itemView.findViewById(R.id.help_date);textView3.setText("2022年1月1日");
            }

            @Override
            public int getItemCount() {
                return 8;
            }
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