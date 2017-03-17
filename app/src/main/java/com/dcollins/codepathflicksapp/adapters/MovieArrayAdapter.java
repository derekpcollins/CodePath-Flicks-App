package com.dcollins.codepathflicksapp.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.dcollins.codepathflicksapp.models.Movie;

import java.util.List;

/**
 * Created by dcollins on 3/17/17.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }
}