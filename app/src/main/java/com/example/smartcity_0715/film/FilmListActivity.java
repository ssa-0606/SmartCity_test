package com.example.smartcity_0715.film;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.smartcity_0715.R;
import com.example.smartcity_0715.databinding.ActivityFilmListBinding;
import com.example.smartcity_0715.film.adapter.FilmListAdapter;
import com.example.smartcity_0715.film.pojo.Movie;
import com.example.smartcity_0715.pojo.LunBo;
import com.example.smartcity_0715.tools.MyNetManger;
import com.example.smartcity_0715.tools.MyTaskManger;

public class FilmListActivity extends AppCompatActivity {

    private ActivityFilmListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFilmListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("看电影");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getLunbo();
        getFilm();


    }

    private void getFilm() {
        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/movie/film/list","rows", Movie.class).thenAccept(movies -> {
            runOnUiThread(()->{
                binding.movieList.setLayoutManager(new GridLayoutManager(FilmListActivity.this,1));
                binding.movieList.setAdapter(new FilmListAdapter(R.layout.layout_movie_list,movies));
            });
        });
    }

    private void getLunbo() {

        MyTaskManger.getListData(MyNetManger.SERVER_IP+"/prod-api/api/movie/rotation/list","rows", LunBo.class).thenAccept(lunBos -> {

            runOnUiThread(()->{
                for (LunBo lunBo : lunBos) {
                    ImageView imageView = new ImageView(FilmListActivity.this);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    Glide.with(FilmListActivity.this).load(MyNetManger.SERVER_IP+lunBo.getAdvImg()).into(imageView);
                    binding.movieVf.addView(imageView);
                }
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