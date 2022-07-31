package com.example.smartcity_0715.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.FragmentNotificationsBinding;
import com.example.smartcity_0715.ui.notifications.activitys.AnliActivity;
import com.example.smartcity_0715.ui.notifications.activitys.FupinCunActivity;
import com.example.smartcity_0715.ui.notifications.activitys.HelpActivity;
import com.example.smartcity_0715.ui.notifications.activitys.RuHuActivity;

import java.util.Random;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.my_tran1);
        Animation animation1 = AnimationUtils.loadAnimation(getContext(),R.anim.my_tran2);
        binding.textView14.setAnimation(animation);
        binding.textView15.setAnimation(animation);
        int[] values = new int[]{R.drawable.fupin,R.drawable.fupin1,R.drawable.fupin2,R.drawable.fupin3};
        int[] values1 = new int[]{R.drawable.cunqingjianjie,R.drawable.fabuqiuzhu,R.drawable.xianchangzoufang,R.drawable.anli};
        String[] values3 = new String[]{"村情村貌","收到求助","入户走访","案例发布"};
        for (int value : values) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(value);
            binding.fupinVf.addView(imageView);
        }

        binding.fupinService.setLayoutManager(new GridLayoutManager(getContext(),4));
        binding.fupinService.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_service, null);
                RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(inflate) {};
                return holder;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                ImageView imageView = holder.itemView.findViewById(R.id.service_icon);
                imageView.setImageResource(values1[position]);
                TextView textView = holder.itemView.findViewById(R.id.service_name);
                textView.setText(values3[position]);
                LinearLayout layout = holder.itemView.findViewById(R.id.service_jump);
                layout.setOnClickListener(view -> {
                    if(TextUtils.equals("村情村貌",values3[position])){
                        Intent intent = new Intent(holder.itemView.getContext(), FupinCunActivity.class);
                        holder.itemView.getContext().startActivity(intent);
                    }else if(TextUtils.equals("收到求助",values3[position])){
                        Intent intent = new Intent(holder.itemView.getContext(), HelpActivity.class);
                        holder.itemView.getContext().startActivity(intent);
                    }else if(TextUtils.equals("入户走访",values3[position])){
                        Intent intent = new Intent(holder.itemView.getContext(), RuHuActivity.class);
                        holder.itemView.getContext().startActivity(intent);
                    }else if(TextUtils.equals("案例发布",values3[position])){
                        Intent intent = new Intent(holder.itemView.getContext(), AnliActivity.class);
                        holder.itemView.getContext().startActivity(intent);
                    }
                });
            }

            @Override
            public int getItemCount() {
                return values1.length;
            }
        });

        String[] stringArray = getContext().getResources().getStringArray(R.array.anli);

        binding.anliList.setLayoutManager(new GridLayoutManager(getContext(),1));
        binding.anliList.setAdapter(new RecyclerView.Adapter() {
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
                textView.setText(stringArray[position]);
                TextView textView1 = itemView.findViewById(R.id.help_name);
                textView1.setText("案例"+(position+1));
                TextView textView2 = itemView.findViewById(R.id.help_address);
                i = random.nextInt(500);
                textView2.setText("点赞："+i);
                TextView textView3 = itemView.findViewById(R.id.help_date);
                textView3.setOnClickListener(view -> {
                    int j = Integer.valueOf(textView2.getText().toString().substring(3));
                    textView2.setText("点赞："+(++j));
                });
                CardView cardView = itemView.findViewById(R.id.card);
                cardView.setAnimation(animation1);
            }

            @Override
            public int getItemCount() {
                return 5;
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}