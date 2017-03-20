package com.dcollins.codepathflicksapp.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dcollins.codepathflicksapp.R;
import com.dcollins.codepathflicksapp.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.dcollins.codepathflicksapp.R.id.tvOverview;
import static com.dcollins.codepathflicksapp.R.id.tvTitle;

/**
 * Created by dcollins on 3/17/17.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    private static class ViewHolder {
        ImageView poster;
        TextView title;
        TextView overview;
    }

    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for position
        Movie movie = getItem(position);

        int orientation = getContext().getResources().getConfiguration().orientation;

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.poster = (ImageView) convertView.findViewById(R.id.ivMovieImage);
            viewHolder.title = (TextView) convertView.findViewById(tvTitle);
            viewHolder.overview = (TextView) convertView.findViewById(tvOverview);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data from the data object via the viewHolder boject
        // into the template view.
        viewHolder.poster.setImageResource(0);
        viewHolder.title.setText(movie.getOrignalTitle());
        viewHolder.overview.setText(movie.getOverview());

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Picasso.with(getContext()).load(movie.getPosterPath()).placeholder(R.drawable.placeholder).resize(350, 0).into(viewHolder.poster);
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Picasso.with(getContext()).load(movie.getBackdropPath()).placeholder(R.drawable.placeholder).resize(750, 0).into(viewHolder.poster);
        }

        // return the view
        return convertView;
    }
}
