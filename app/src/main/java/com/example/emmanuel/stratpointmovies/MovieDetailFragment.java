package com.example.emmanuel.stratpointmovies;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MovieDetailFragment extends Fragment {

    public static final String ARG_ITEM_POSITION = "item_position";
    public Movie mItem;

    public MovieDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        final NetworkImageView backDrop = (NetworkImageView) rootView.findViewById(R.id.movie_detail_backdrop);
        final NetworkImageView cover = (NetworkImageView) rootView.findViewById(R.id.movie_detail_cover);
        final TextView title = (TextView) rootView.findViewById(R.id.movie_detail_title);
        final TextView year = (TextView) rootView.findViewById(R.id.movie_detail_year);
        final TextView rating = (TextView) rootView.findViewById(R.id.movie_detail_rating);
        final TextView overview = (TextView) rootView.findViewById(R.id.movie_detail_overview);

        if (getArguments().containsKey(ARG_ITEM_POSITION)) {
            final int position = getArguments().getInt(ARG_ITEM_POSITION);
            JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, MovieListActivity.URL, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONObject data = response.getJSONObject("data");
                                JSONArray array = data.getJSONArray("movies");
                                JSONObject movieJson = array.getJSONObject(position);
                                mItem = new Movie(new ArrayList<String>(), movieJson.getDouble("rating"),
                                        (String) movieJson.get("language"), (String) movieJson.get("title"),
                                        (String) movieJson.get("url"), (String) movieJson.get("title_long"),
                                        (String) movieJson.get("imdb_code"), movieJson.getInt("id"),
                                        (String) movieJson.get("state"), movieJson.getInt("year"),
                                        movieJson.getInt("runtime"), (String) movieJson.get("overview"),
                                        (String) movieJson.get("slug"), (String) movieJson.get("mpa_rating")
                                );
                            } catch (JSONException e) {
                                Log.d(MovieListActivity.DEBUG_LOG, e.getLocalizedMessage());
                                e.printStackTrace();
                            }
                            title.setText(mItem.getTitle());
                            year.setText("(" + mItem.getYear() + ")");
                            rating.setText(mItem.getRating().toString());
                            overview.setText(mItem.getOverview());
                            cover.setImageUrl(mItem.getMovieCoverURL(), Singleton.imageLoader);
                            backDrop.setImageUrl(mItem.getMovieBackDropURL(), Singleton.imageLoader);
                        }
                    }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d(MovieListActivity.DEBUG_LOG, error.getLocalizedMessage());
                }
            });
            Singleton.requestQueue.add(jsObjRequest);
        }
        return rootView;
    }
}
