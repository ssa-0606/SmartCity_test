package com.example.smartcity_0715.metro.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity_0715.databinding.LayoutLineBinding;
import com.example.smartcity_0715.metro.pojo.Line;

import java.util.List;
import java.util.Random;

public class LineAdapter extends RecyclerView.Adapter<LineAdapter.ViewHolder> {

    private int resourceId;
    private List<Line> lines;

    public LineAdapter(int resourceId, List<Line> lines) {
        this.resourceId = resourceId;
        this.lines = lines;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        LayoutLineBinding binding = LayoutLineBinding.bind(inflate);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Line line = lines.get(position);
        holder.binding.textView13.setText(line.getLineName());
        Random random = new Random();
        holder.binding.textView13.setTextColor(Color.rgb(random.nextInt(150),random.nextInt(150),random.nextInt(150)));

    }

    @Override
    public int getItemCount() {
        return lines.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutLineBinding binding;
        public ViewHolder(@NonNull LayoutLineBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
