package com.example.smartcity_0715.part.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity_0715.databinding.LayoutRecordCardBinding;
import com.example.smartcity_0715.part.pojo.ParkRecord;

import java.util.List;

public class RecordListAdapter extends RecyclerView.Adapter<RecordListAdapter.ViewHolder> {

    private int resourceId;
    private List<ParkRecord> records;

    public RecordListAdapter(int resourceId, List<ParkRecord> records) {
        this.resourceId = resourceId;
        this.records = records;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        LayoutRecordCardBinding binding = LayoutRecordCardBinding.bind(inflate);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ParkRecord parkRecord = records.get(position);
        holder.binding.recordPlate.setText(parkRecord.getPlateNumber());
        holder.binding.recordPay.setText("收费金额："+parkRecord.getMonetary()+"元");
        holder.binding.recordEntry.setText("入场时间   "+parkRecord.getEntryTime());
        holder.binding.recordOut.setText("出场时间   "+parkRecord.getOutTime());
        holder.binding.recordName.setText(parkRecord.getParkName());
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutRecordCardBinding binding;
        public ViewHolder(@NonNull LayoutRecordCardBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
