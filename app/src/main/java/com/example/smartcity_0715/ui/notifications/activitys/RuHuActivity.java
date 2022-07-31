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
import com.example.smartcity_0715.databinding.ActivityRuHuBinding;

import java.util.Random;

public class RuHuActivity extends AppCompatActivity {

    private ActivityRuHuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRuHuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("入户走访");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] shequ = new String[]{"一号社区走访","二号社区走访","三号社区走访","四号社区走访","五号社区走访"};
        String[] infos = new String[]{"党支部党员下片走访退休老人家中，了解退休后的生活保障情况","某大学党支部团支部组织大学生进入社区打扫卫生",
        "专业人才入户传授生产技能...","企业线下招聘贫困人员，进行培训入职","脱贫演讲会，在五号社区成功举办"};

        binding.ruhuList.setLayoutManager(new GridLayoutManager(this,1));
        binding.ruhuList.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_anli, null);
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(inflate) {};
                return holder;
            }

            Random random = new Random();
            int i;
            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                ImageView imageView = holder.itemView.findViewById(R.id.anli_img);
                imageView.setImageResource(R.drawable.fupin3);
                View itemView = holder.itemView;
                TextView textView = itemView.findViewById(R.id.help_content);
                textView.setText(infos[position]);
                TextView textView1 = itemView.findViewById(R.id.help_name);
                textView1.setText(shequ[position]);
                TextView textView2 = itemView.findViewById(R.id.help_address);
                i = random.nextInt(500);
                textView2.setText("点赞："+i);
                TextView textView3 = itemView.findViewById(R.id.help_date);
                textView3.setOnClickListener(view -> {
                    int j = Integer.valueOf(textView2.getText().toString().substring(3));
                    textView2.setText("点赞："+(++j));
                });

            }

            @Override
            public int getItemCount() {
                return 5;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}