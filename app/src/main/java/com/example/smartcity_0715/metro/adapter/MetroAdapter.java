package com.example.smartcity_0715.metro.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity_0715.databinding.LayoutMetroListBinding;
import com.example.smartcity_0715.metro.MetroDetailActivity;
import com.example.smartcity_0715.metro.pojo.Metro;

import java.util.List;

public class MetroAdapter extends RecyclerView.Adapter<MetroAdapter.ViewHolder> {

    private int resourceId;
    private List<Metro> metroList;

    public MetroAdapter(int resourceId, List<Metro> metroList) {
        this.resourceId = resourceId;
        this.metroList = metroList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        LayoutMetroListBinding binding = LayoutMetroListBinding.bind(inflate);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Metro metro = metroList.get(position);
        holder.binding.metroName.setText(metro.getLineName());
        holder.binding.metroNext.setText("下一站："+metro.getNextStep().getName());
        holder.binding.metroReach.setText(metro.getReachTime()+"分钟后");

        holder.binding.metroJump.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), MetroDetailActivity.class);
            intent.putExtra("id",metro.getLineId());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return metroList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutMetroListBinding binding;
        public ViewHolder(@NonNull LayoutMetroListBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
