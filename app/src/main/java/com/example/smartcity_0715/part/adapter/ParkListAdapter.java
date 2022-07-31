package com.example.smartcity_0715.part.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity_0715.databinding.LayoutListCardBinding;
import com.example.smartcity_0715.part.ParkDetailActivity;
import com.example.smartcity_0715.part.pojo.ParkSpace;

import java.util.List;

public class ParkListAdapter extends RecyclerView.Adapter<ParkListAdapter.ViewHolder> {

    private int resourceId;
    private List<ParkSpace> parkSpaceList;

    public ParkListAdapter(int resourceId, List<ParkSpace> parkSpaceList) {
        this.resourceId = resourceId;
        this.parkSpaceList = parkSpaceList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        LayoutListCardBinding binding = LayoutListCardBinding.bind(inflate);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ParkSpace parkSpace = parkSpaceList.get(position);
        holder.binding.parkName.setText(parkSpace.getParkName());
        holder.binding.parkDistance.setText(parkSpace.getDistance()+"公里");
        holder.binding.parkInfo.setText("空位"+parkSpace.getVacancy()+"个 ｜ 停车费"+parkSpace.getRates()+"元/小时");
        holder.binding.parkAdd.setText(parkSpace.getAddress());
        holder.binding.parkJump.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), ParkDetailActivity.class);
            intent.putExtra("id",parkSpace.getId());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        Log.d("TAG", "getItemCount: "+parkSpaceList.size());
        return parkSpaceList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private LayoutListCardBinding binding;
        public ViewHolder(@NonNull LayoutListCardBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
