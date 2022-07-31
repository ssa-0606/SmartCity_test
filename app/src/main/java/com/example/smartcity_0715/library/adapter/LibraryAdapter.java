package com.example.smartcity_0715.library.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartcity_0715.databinding.LayoutLibraryListBinding;
import com.example.smartcity_0715.databinding.LayoutListCardBinding;
import com.example.smartcity_0715.library.LibraryActivity;
import com.example.smartcity_0715.library.LibraryDetailActivity;
import com.example.smartcity_0715.library.pojo.Library;
import com.example.smartcity_0715.part.ParkDetailActivity;
import com.example.smartcity_0715.part.pojo.ParkSpace;

import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.ViewHolder> {
    private int resourceId;
    private List<Library> parkSpaceList;

    public LibraryAdapter(int resourceId, List<Library> parkSpaceList) {
        this.resourceId = resourceId;
        this.parkSpaceList = parkSpaceList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        LayoutLibraryListBinding binding = LayoutLibraryListBinding.bind(inflate);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Library library = parkSpaceList.get(position);
        holder.binding.libraryName.setText(library.getName());
        if(TextUtils.equals("1",library.getBusinessState())){
            holder.binding.libraryState.setText("正在营业"); holder.binding.libraryState.setTextColor(Color.parseColor("#81C784"));
        }else{
            holder.binding.libraryState.setText("暂停营业"); holder.binding.libraryState.setTextColor(Color.parseColor("#F06292"));
        }
        holder.binding.libraryTime.setText(library.getBusinessHours());
        holder.binding.libraryAddress.setText(library.getAddress());
        holder.binding.parkJump.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), LibraryDetailActivity.class);
            intent.putExtra("id",library.getId());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return parkSpaceList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutLibraryListBinding binding;
        public ViewHolder(@NonNull LayoutLibraryListBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
