package com.example.smartcity_0715.ui.home.adapter;

import android.content.Intent;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.activities.PressDetailActivity;
import com.example.smartcity_0715.databinding.LayoutPressBinding;
import com.example.smartcity_0715.pojo.Press;
import com.example.smartcity_0715.tools.MyNetManger;

import java.util.List;

public class PressAdapter extends RecyclerView.Adapter<PressAdapter.ViewHolder> {

    private int resourceId;
    private List<Press> pressList;

    public PressAdapter(int resourceId, List<Press> pressList) {
        this.resourceId = resourceId;
        this.pressList = pressList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        LayoutPressBinding binding = LayoutPressBinding.bind(inflate);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Press press = pressList.get(position);
        holder.binding.pressTitle.setText(press.getTitle());
        Glide.with(holder.itemView).load(MyNetManger.SERVER_IP+press.getCover()).into(holder.binding.pressCover);
        holder.binding.pressContent.setText(Html.fromHtml(TextUtils.replace(press.getContent(),new String[]{"&nbsp;",""},new String[]{"",""}).toString()));
        holder.binding.pressRead.setText(String.valueOf(press.getReadNum()));
        holder.binding.pressDate.setText(press.getPublishDate());
        holder.binding.pressJump.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), PressDetailActivity.class);
            intent.putExtra("content",press.getContent());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return pressList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutPressBinding binding;
        public ViewHolder(@NonNull LayoutPressBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
