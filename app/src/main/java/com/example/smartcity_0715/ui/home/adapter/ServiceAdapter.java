package com.example.smartcity_0715.ui.home.adapter;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.R;
import com.example.smartcity_0715.bus.BusListActivity;
import com.example.smartcity_0715.databinding.LayoutServiceBinding;
import com.example.smartcity_0715.event.EventActivity;
import com.example.smartcity_0715.film.FilmListActivity;
import com.example.smartcity_0715.house.HouseListActivity;
import com.example.smartcity_0715.house.adapter.HouseType;
import com.example.smartcity_0715.library.LibraryActivity;
import com.example.smartcity_0715.metro.MetroListActivity;
import com.example.smartcity_0715.part.ParkListActivity;
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

        holder.binding.serviceJump.setOnClickListener(view -> {
            if(TextUtils.equals("全部服务",cityService.getServiceName())){
                NavController navController = Navigation.findNavController(holder.itemView);
                navController.navigate(R.id.action_navigation_home_to_navigation_dashboard);
            }else if(TextUtils.equals("停哪儿",cityService.getServiceName())){
                Intent intent = new Intent(holder.itemView.getContext(), ParkListActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }else if(TextUtils.equals("数字图书馆",cityService.getServiceName())){
                Intent intent = new Intent(holder.itemView.getContext(), LibraryActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }else if (TextUtils.equals("城市地铁",cityService.getServiceName())){
                Intent intent = new Intent(holder.itemView.getContext(), MetroListActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }else if (TextUtils.equals("看电影",cityService.getServiceName())){
                Intent intent = new Intent(holder.itemView.getContext(), FilmListActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }else if (TextUtils.equals("活动管理",cityService.getServiceName())){
                Intent intent = new Intent(holder.itemView.getContext(), EventActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }else if (TextUtils.equals("找房子",cityService.getServiceName())){
                Intent intent = new Intent(holder.itemView.getContext(), HouseListActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }else if (TextUtils.equals("智慧巴士",cityService.getServiceName())){
                Intent intent = new Intent(holder.itemView.getContext(), BusListActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });





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
