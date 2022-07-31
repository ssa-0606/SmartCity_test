package com.example.smartcity_0715.bus.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.R;
import com.example.smartcity_0715.bus.BusDetailActivity;
import com.example.smartcity_0715.bus.BusListActivity;
import com.example.smartcity_0715.bus.pojo.Bus;
import com.example.smartcity_0715.bus.pojo.BusStop;
import com.example.smartcity_0715.databinding.LayoutBusListBinding;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

import java.util.List;

public class BusListAdapter extends RecyclerView.Adapter<BusListAdapter.ViewHolder> {

    private int resourceId;
    private List<Bus> buses;

    public BusListAdapter(int resourceId, List<Bus> buses) {
        this.resourceId = resourceId;
        this.buses = buses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        LayoutBusListBinding binding = LayoutBusListBinding.bind(inflate);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bus bus = buses.get(position);
        holder.binding.busStart.setText(bus.getFirst());
        holder.binding.busEnd.setText(bus.getEnd());
        holder.binding.busLine.setText(bus.getName());
        holder.binding.busMoney.setText(bus.getPrice()+"元");
        holder.binding.busKm.setText(bus.getMileage()+"km");
        holder.binding.busFirstTime.setText("发车时间:"+bus.getStartTime());
        holder.binding.busEndTime.setText("末班车时间:"+bus.getEndTime());
        Glide.with(holder.itemView.getContext()).load(MyNetManger.SERVER_IP+"/prod-api/profile/upload/image/2021/05/10/aa69f9d0-9718-42f9-9f79-c07b82a48c41.png").into(holder.binding.imageView12);
        BusListActivity busListActivity = (BusListActivity) holder.itemView.getContext();
        getStations(bus.getId(),busListActivity,holder.binding.busStations);

        holder.binding.busJump.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), BusDetailActivity.class);
            intent.putExtra("id",bus.getId());
            holder.itemView.getContext().startActivity(intent);
        });

        holder.binding.busShow.setOnClickListener(view -> {
            int status = holder.binding.busStations.getVisibility();
            if(status == View.GONE){
                holder.binding.busStations.setVisibility(View.VISIBLE);
                holder.binding.busShow.setImageResource(android.R.drawable.arrow_up_float);
                holder.binding.busDash.setBackgroundColor(Color.parseColor("#EFE9E9"));
            }else{
                holder.binding.busStations.setVisibility(View.GONE);
                holder.binding.busShow.setImageResource(android.R.drawable.arrow_down_float);
                holder.binding.busDash.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return buses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutBusListBinding binding;
        public ViewHolder(@NonNull LayoutBusListBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }

    private void getStations(int id, BusListActivity busListActivity, RecyclerView busStations) {

        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/bus/stop/list?linesId="+id,"rows", BusStop.class).thenAccept(busStops -> {
            busListActivity.runOnUiThread(()->{
                busStations.setLayoutManager(new GridLayoutManager(busListActivity,1));
                busStations.setAdapter(new BusStationAdapter(R.layout.layout_bus_stop,busStops));
            });
        });

    }
}
