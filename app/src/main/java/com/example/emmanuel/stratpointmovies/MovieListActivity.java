package com.example.emmanuel.stratpointmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class MovieListActivity extends FragmentActivity
        implements MovieListFragment.Callbacks {

    private boolean mTwoPane;
    public static final String DEBUG_LOG = "DEBUG";
    public static final String URL = "https://dl.dropboxusercontent.com/u/5624850/movielist/list_movies_page1.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Singleton.requestQueue = Volley.newRequestQueue(this);
        Singleton.imageLoader = new ImageLoader(Singleton.requestQueue, new LruBitmapCache(
                LruBitmapCache.getCacheSize(this)));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        if (findViewById(R.id.movie_detail_container) != null) {
            mTwoPane = true;
            ((MovieListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.movie_list))
                    .setActivateOnItemClick(true);
        }
    }

    @Override
    public void onItemSelected(int pos) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putInt(MovieDetailFragment.ARG_ITEM_POSITION, pos);
            MovieDetailFragment fragment = new MovieDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.movie_detail_container, fragment)
                    .commit();

        } else {
            Intent detailIntent = new Intent(this, MovieDetailActivity.class);
            detailIntent.putExtra(MovieDetailFragment.ARG_ITEM_POSITION, pos);
            startActivity(detailIntent);
        }
    }
}
