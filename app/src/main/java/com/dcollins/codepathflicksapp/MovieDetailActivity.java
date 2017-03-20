package com.dcollins.codepathflicksapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.dcollins.codepathflicksapp.models.Movie;
import com.squareup.picasso.Picasso;

import static com.dcollins.codepathflicksapp.R.id.tvTitle;

/**
 * Created by dcollins on 3/18/17.
 */

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Movie movie = (Movie) getIntent().getSerializableExtra("movie");

        //int orientation = getContext().getResources().getConfiguration().orientation;
        int orientation = getApplicationContext().getResources().getConfiguration().orientation;

        //Log.d("MOVIE", movie.getOrignalTitle());

        TextView title = (TextView) findViewById(tvTitle);
        ImageView poster = (ImageView) findViewById(R.id.ivMovieImage);
        TextView overview = (TextView) findViewById(R.id.tvOverview);
        TextView releaseDate = (TextView) findViewById(R.id.tvReleaseDate);
        TextView userRating = (TextView) findViewById(R.id.tvUserRating);

        title.setText(movie.getOrignalTitle());
        poster.setImageResource(0);
        overview.setText(movie.getOverview());
        releaseDate.setText(movie.getReleaseDate());
        userRating.setText(movie.getUserRating());

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Picasso.with(getApplicationContext()).load(movie.getPosterPath()).placeholder(R.drawable.placeholder).resize(350, 0).into(poster);
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Picasso.with(getApplicationContext()).load(movie.getBackdropPath()).placeholder(R.drawable.placeholder).resize(750, 0).into(poster);
        }
    }
}
