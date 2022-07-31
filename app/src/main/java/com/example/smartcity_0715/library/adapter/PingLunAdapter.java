package com.example.smartcity_0715.library.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.LayoutPinglunBinding;
import com.example.smartcity_0715.pojo.PingLun;

import java.util.List;

public class PingLunAdapter extends RecyclerView.Adapter<PingLunAdapter.ViewHolder> {

    private int resourceId;
    private List<PingLun> pingLuns;

    public PingLunAdapter(int resourceId, List<PingLun> pingLuns) {
        this.resourceId = resourceId;
        this.pingLuns = pingLuns;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        LayoutPinglunBinding binding = LayoutPinglunBinding.bind(inflate);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PingLun pingLun = pingLuns.get(position);
        holder.binding.pinglunNick.setText(pingLun.getUserName());
        holder.binding.pinglunContent.setText(pingLun.getContent());
        holder.binding.pinglunTime.setText(pingLun.getCreateTime());
        if(pingLun.isMyLikeState()){
            holder.binding.imageView7.setImageResource(R.drawable.yidianzan);
        }else{
            holder.binding.imageView7.setImageResource(R.drawable.dianzan);
        }
    }

    @Override
    public int getItemCount() {
        return pingLuns.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutPinglunBinding binding;
        public ViewHolder(@NonNull LayoutPinglunBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
