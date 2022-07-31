package com.example.smartcity_0715.house.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.databinding.LayoutHouseListBinding;
import com.example.smartcity_0715.house.HouseDetailActivity;
import com.example.smartcity_0715.house.HouseListActivity;
import com.example.smartcity_0715.house.pojo.House;
import com.example.smartcity_0715.tools.MyNetManger;

import java.util.List;

public class HouseListAdapter extends RecyclerView.Adapter<HouseListAdapter.ViewHolder> {
    private int resourceId;
    private List<House> houses;

    public HouseListAdapter(int resourceId, List<House> houses) {
        this.resourceId = resourceId;
        this.houses = houses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        LayoutHouseListBinding  binding = LayoutHouseListBinding.bind(inflate);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        House house = houses.get(position);
        Glide.with(holder.itemView.getContext()).load(MyNetManger.SERVER_IP+house.getPic()).into(holder.binding.houseImg);
        holder.binding.houseTitle.setText(house.getSourceName());
        holder.binding.houseInfo.setText(house.getAreaSize()+"平 ｜ "+house.getPrice());
        holder.binding.houseDesc.setText(house.getDescription());
        holder.binding.houseJump.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), HouseDetailActivity.class);
            intent.putExtra("id",house.getId());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return houses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutHouseListBinding binding;
        public ViewHolder(@NonNull LayoutHouseListBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
