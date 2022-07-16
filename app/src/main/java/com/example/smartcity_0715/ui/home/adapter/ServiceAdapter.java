package com.example.smartcity_0715.ui.home.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.LayoutServiceBinding;
import com.example.smartcity_0715.pojo.CityService;
import com.example.smartcity_0715.tools.MyNetManger;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder> {

    private int resourceId;
    private List<CityService> cityServices;

    public ServiceAdapter(int resourceId, List<CityService> cityServices) {
        this.resourceId = resourceId;
        this.cityServices = cityServices;
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
        CityService cityService = cityServices.get(position);
        holder.binding.serviceName.setText(cityService.getServiceName());
        if(TextUtils.equals("全部服务",cityService.getServiceName())){
            holder.binding.serviceIcon.setImageResource(R.drawable.ic_dashboard_black_24dp);
        }else{
            Glide.with(holder.itemView).load(MyNetManger.SERVER_IP+cityService.getImgUrl()).into(holder.binding.serviceIcon);
        }

    }

    @Override
    public int getItemCount() {
        return cityServices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutServiceBinding binding;
        public ViewHolder(@NonNull LayoutServiceBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
