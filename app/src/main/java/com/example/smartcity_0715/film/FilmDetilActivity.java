package com.example.smartcity_0715.film;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityFilmDetilBinding;
import com.example.smartcity_0715.film.pojo.Movie;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

public class FilmDetilActivity extends AppCompatActivity {

    private ActivityFilmDetilBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFilmDetilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("电影详情");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int id = getIntent().getIntExtra("id",1);

        getData(id);

        binding.backBtn.setOnClickListener(view -> {
            finish();
        });



    }

    private void getData(int id) {

        MyTaskManger.getData(MyNetManger.SERVER_IP+"/prod-api/api/movie/film/detail/"+id,"data", Movie.class).thenAccept(movie -> {
            runOnUiThread(()->{
                Glide.with(FilmDetilActivity.this).load(MyNetManger.SERVER_IP+movie.getCover()).into(binding.filmImg);
                binding.movieDetailName.setText(movie.getName());
                binding.movieDetailLong.setText(movie.getDuration()+"分钟");
                binding.movieDetailTime.setText(movie.getPlayDate());
                binding.movieDetailDesc.loadDataWithBaseURL(null,movie.getIntroduction(),"text/html","UTF-8",null);
                binding.movieScore.setText("某瓣评分"+Float.valueOf(movie.getScore())+"分");
                binding.movieWant.setText("有"+movie.getFavoriteNum()+"想看");
            });
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}