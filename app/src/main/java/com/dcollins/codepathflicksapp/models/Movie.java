package com.dcollins.codepathflicksapp.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by dcollins on 3/17/17.
 */

public class Movie implements Serializable {

    private static final long serialVersionUID = 5177222050535318633L;

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w780/%s", backdropPath);
    }

    public String getOrignalTitle() {
        return orignalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getUserRating() {
        return rating;
    }

    String posterPath;
    String backdropPath;
    String orignalTitle;
    String overview;
    String releaseDate;
    String rating;

    public Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.orignalTitle = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
        this.releaseDate = jsonObject.getString("release_date");
        this.rating = jsonObject.getString("vote_average");
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();

        for (int x = 0; x < array.length(); x++) {
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return results;
    }

}
