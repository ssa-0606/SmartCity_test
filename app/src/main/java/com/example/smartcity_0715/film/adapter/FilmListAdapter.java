package com.example.smartcity_0715.film.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.databinding.LayoutMovieListBinding;
import com.example.smartcity_0715.film.FilmDetilActivity;
import com.example.smartcity_0715.film.pojo.Movie;
import com.example.smartcity_0715.tools.MyNetManger;

import java.util.List;

public class FilmListAdapter extends RecyclerView.Adapter<FilmListAdapter.ViewHolder> {

    private int resourceId;
    private List<Movie> movies;

    public FilmListAdapter(int resourceId, List<Movie> movies) {
        this.resourceId = resourceId;
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(resourceId, null);
        LayoutMovieListBinding binding = LayoutMovieListBinding.bind(inflate);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.binding.movieName.setText(movie.getName());
        Glide.with(holder.itemView.getContext()).load(MyNetManger.SERVER_IP+movie.getCover()).into(holder.binding.imageView13);
        holder.binding.movieLong.setText(movie.getDuration()+"分钟");
        holder.binding.movieTime.setText("上映时间"+movie.getPlayDate());
        holder.binding.movieJump.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), FilmDetilActivity.class);
            intent.putExtra("id",movie.getId());
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private LayoutMovieListBinding binding;
        public ViewHolder(@NonNull LayoutMovieListBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
