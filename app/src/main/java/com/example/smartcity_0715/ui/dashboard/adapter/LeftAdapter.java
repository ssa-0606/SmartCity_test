package com.example.smartcity_0715.ui.dashboard.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smartcity_0715.R;

public class LeftAdapter extends ArrayAdapter<String> {

    private int resourceId;
    private int i;

    public LeftAdapter(@NonNull Context context, int resource, @NonNull String[] objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    public void setSelect(int i){
        this.i = i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String item = getItem(position);
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        TextView textView = inflate.findViewById(R.id.textView);
        textView.setText(item);

        if(position == 0){
            textView.setBackgroundColor(Color.parseColor("#ffffff"));
        }

        if(i == position){
            textView.setBackgroundColor(Color.parseColor("#ffffff"));
        }else {
            textView.setBackgroundColor(Color.parseColor("#E3DDDD"));
        }

        return inflate;
    }
}
