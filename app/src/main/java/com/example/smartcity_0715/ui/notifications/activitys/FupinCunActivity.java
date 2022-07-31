package com.example.smartcity_0715.ui.notifications.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityFupinCunBinding;

public class FupinCunActivity extends AppCompatActivity {
    private ActivityFupinCunBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFupinCunBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("扶贫对象");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] names = new String[]{"小明","小刚","华强","小德","小李","小花","小志","小刘","小芳","小军"};
        String[] country=new String[]{"大明村","约克村","库伦村","鲁尔村","木叶村","基辅村","多伦村","高雄村","杜王町村","华盛村"};
        String[] ages = new  String[]{"45","34","45","56","46","45","67","45","34","35"};


        binding.duixiangList.setLayoutManager(new GridLayoutManager(this,1));
        binding.duixiangList.setAdapter(new RecyclerView.Adapter() {

            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_anli, null);
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(inflate) {};
                return holder;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                ImageView imageView = holder.itemView.findViewById(R.id.anli_img);
                imageView.setImageResource(R.drawable.avatartemp);
                View itemView = holder.itemView;
                TextView textView = itemView.findViewById(R.id.help_content);
                textView.setText("年龄:"+ages[position]);
                TextView textView1 = itemView.findViewById(R.id.help_name);
                textView1.setText("姓名："+names[position]);
                TextView textView2 = itemView.findViewById(R.id.help_address);
                textView2.setText("村庄："+country[position]);
                TextView textView3 = itemView.findViewById(R.id.help_date);
                textView3.setText("重点扶贫对象");
                CardView cardView = itemView.findViewById(R.id.card);
                Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.my_tran2);
                cardView.setAnimation(animation);
                cardView.setOnClickListener(view -> {
                    Intent intent = new Intent(holder.itemView.getContext(),FupinDuixiangActivity.class);
                    intent.putExtra("id",position);
                    holder.itemView.getContext().startActivity(intent);
                });
            }

            @Override
            public int getItemCount() {
                return names.length;
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ((item.getItemId())){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}