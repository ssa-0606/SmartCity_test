package com.example.smartcity_0715.event.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.databinding.LayoutEventListBinding;
import com.example.smartcity_0715.event.EventDetailActivity;
import com.example.smartcity_0715.event.pojo.Event;
import com.example.smartcity_0715.tools.MyNetManger;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder> {

    private int resourceId;
    private List<Event> events;

    public EventListAdapter(int resourceId, List<Event> events) {
        this.resourceId = resourceId;
        this.events = events;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        LayoutEventListBinding binding = LayoutEventListBinding.bind(inflate);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Event event = events.get(position);
        Glide.with(holder.itemView.getContext()).load(MyNetManger.SERVER_IP+event.getImgUrl()).into(holder.binding.imageView11);
        holder.binding.eventTitle.setText(event.getName());
        holder.binding.niceCount.setText(event.getLikeNum()+"点赞");
        holder.binding.signCount.setText(event.getSignupNum()+"已报名");
        holder.binding.eventJump.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), EventDetailActivity.class);
            intent.putExtra("id",event.getId());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutEventListBinding binding;
        public ViewHolder(@NonNull LayoutEventListBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
