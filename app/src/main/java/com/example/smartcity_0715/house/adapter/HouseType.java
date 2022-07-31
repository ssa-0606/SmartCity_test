package com.example.smartcity_0715.house.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.databinding.LayoutServiceBinding;
import com.example.smartcity_0715.house.HouseListActivity;
import com.example.smartcity_0715.tools.MyNetManger;

import java.util.List;

public class HouseType extends RecyclerView.Adapter<HouseType.ViewHolder> {
    private int resourceId;
    private String[] types;

    public HouseType(int resourceId, String[] types) {
        this.resourceId = resourceId;
        this.types = types;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        LayoutServiceBinding binding = LayoutServiceBinding.bind(inflate);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String type = types[position];
        holder.binding.serviceName.setText(type);
        Glide.with(holder.itemView.getContext()).load(MyNetManger.SERVER_IP+"/prod-api/profile/upload/image/2021/05/10/022a6703-cebf-4c47-9218-207e2874a030.png").into(holder.binding.serviceIcon);
        HouseListActivity activity = (HouseListActivity) holder.itemView.getContext();
        holder.binding.serviceJump.setOnClickListener(view -> {
           activity.getData(type);
        });
    }

    @Override
    public int getItemCount() {
        return types.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutServiceBinding binding;
        public ViewHolder(@NonNull LayoutServiceBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
