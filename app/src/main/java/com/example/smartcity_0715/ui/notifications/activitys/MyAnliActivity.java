package com.example.smartcity_0715.ui.notifications.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityAnliBinding;
import com.example.smartcity_0715.databinding.ActivityMyAnliBinding;
import com.example.smartcity_0715.ui.notifications.anli.Anli;
import com.example.smartcity_0715.ui.notifications.anli.Data;

import java.util.List;
import java.util.Random;

public class MyAnliActivity extends AppCompatActivity {

    private ActivityMyAnliBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyAnliBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("我的案例");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.myAnliList.setLayoutManager(new GridLayoutManager(this,1));
        binding.myAnliList.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_anli, null);
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(inflate) {
                };
                return holder;
            }

            List<Anli> anlis = Data.anlis;
            Random random = new Random();
            int i;

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                ImageView imageView = holder.itemView.findViewById(R.id.anli_img);
                imageView.setImageResource(R.drawable.fupin3);
                View itemView = holder.itemView;
                TextView textView = itemView.findViewById(R.id.help_content);
                textView.setText(anlis.get(position).getContent());
                TextView textView1 = itemView.findViewById(R.id.help_name);
                textView1.setText(anlis.get(position).getContent());
                TextView textView2 = itemView.findViewById(R.id.help_address);
                i = random.nextInt(500);
                textView2.setText("点赞：" + i);
                TextView textView3 = itemView.findViewById(R.id.help_date);
                textView3.setOnClickListener(view -> {
                    int j = Integer.valueOf(textView2.getText().toString().substring(3));
                    textView2.setText("点赞：" + (++j));
                });
            }

            @Override
            public int getItemCount() {
                return anlis.size();
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