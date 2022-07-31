package com.example.smartcity_0715.event.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.databinding.LayoutPinglun1Binding;
import com.example.smartcity_0715.event.pojo.Comment;
import com.example.smartcity_0715.tools.MyNetManger;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    private int resourceId;
    private List<Comment> comments;

    public CommentAdapter(int resourceId, List<Comment> comments) {
        this.resourceId = resourceId;
        this.comments = comments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        LayoutPinglun1Binding binding = LayoutPinglun1Binding.bind(inflate);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Comment comment = comments.get(position);
        holder.binding.pinglunNick.setText(comment.getNickName());
        Glide.with(holder.itemView.getContext()).load(MyNetManger.SERVER_IP+comment.getAvatar()).into(holder.binding.pinglunAvatar);
        holder.binding.pinglunTime.setText(comment.getCommentTime());
        holder.binding.pinglunContent.setText(comment.getContent());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutPinglun1Binding binding;
        public ViewHolder(@NonNull LayoutPinglun1Binding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
