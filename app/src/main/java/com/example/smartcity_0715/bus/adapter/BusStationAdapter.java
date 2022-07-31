package com.example.smartcity_0715.bus.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity_0715.bus.pojo.BusStop;
import com.example.smartcity_0715.databinding.LayoutBusStopBinding;

import java.util.List;

public class BusStationAdapter extends RecyclerView.Adapter<BusStationAdapter.ViewHolder> {

    private int resourceId;
    private List<BusStop> busStops;

    public BusStationAdapter(int resourceId, List<BusStop> busStops) {
        this.resourceId = resourceId;
        this.busStops = busStops;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        LayoutBusStopBinding binding = LayoutBusStopBinding.bind(inflate);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BusStop busStop = busStops.get(position);
        holder.binding.stopName.setText(busStop.getName());
    }

    @Override
    public int getItemCount() {
        return busStops.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutBusStopBinding binding;
        public ViewHolder(@NonNull LayoutBusStopBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
