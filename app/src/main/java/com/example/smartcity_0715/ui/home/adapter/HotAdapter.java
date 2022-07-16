package com.example.smartcity_0715.ui.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.databinding.LayoutHotBinding;
import com.example.smartcity_0715.pojo.Press;
import com.example.smartcity_0715.tools.MyNetManger;

import java.util.List;

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.ViewHolder> {

    private int resourceId;
    private List<Press> pressList;

    public HotAdapter(int resourceId, List<Press> pressList) {
        this.resourceId = resourceId;
        this.pressList = pressList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        LayoutHotBinding binding = LayoutHotBinding.bind(inflate);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Press press = pressList.get(position);
        Glide.with(holder.itemView).load(MyNetManger.SERVER_IP+press.getCover()).into(holder.binding.hotImg);
        holder.binding.textView2.setText(press.getTitle());
    }

    @Override
    public int getItemCount() {
        return pressList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutHotBinding binding;
        public ViewHolder(@NonNull LayoutHotBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
