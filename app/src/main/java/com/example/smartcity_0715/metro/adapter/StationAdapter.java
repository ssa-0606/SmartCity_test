package com.example.smartcity_0715.metro.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity_0715.databinding.LayoutStationBinding;
import com.example.smartcity_0715.metro.pojo.Station;

import java.util.List;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.ViewHolder> {

    private int resourceId;
    private List<Station.MetroStepListDTO> stations;
    private String name;

    public StationAdapter(int resourceId, List<Station.MetroStepListDTO> stations,String name) {
        this.resourceId = resourceId;
        this.stations = stations;
        this.name = name;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        LayoutStationBinding binding = LayoutStationBinding.bind(inflate);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Station.MetroStepListDTO station = stations.get(position);
        holder.binding.stationName.setText(station.getName());
        if(TextUtils.equals(station.getName(),name)){
            holder.binding.imageView10.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutStationBinding binding;
        public ViewHolder(@NonNull LayoutStationBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
