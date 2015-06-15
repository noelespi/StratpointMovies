package com.example.emmanuel.stratpointmovies;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

public class MovieListAdapter extends BaseAdapter {

    private ArrayList<Movie> mItems = new ArrayList<Movie>();
    private Context mContext;
    RequestQueue mRequestQueue;
    ImageLoader mImageLoader;

    public MovieListAdapter(ArrayList<Movie> items, Context context, ImageLoader loader) {
        mItems = items;
        mContext = context;
        mImageLoader = loader;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mItems.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolderItem viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.movie_list_item, viewGroup, false);
            viewHolder = new ViewHolderItem();
            viewHolder.title = (TextView) convertView.findViewById(R.id.item_title);
            viewHolder.year = (TextView) convertView.findViewById(R.id.item_year);
            viewHolder.imageView = (NetworkImageView) convertView.findViewById(R.id.item_image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderItem) convertView.getTag();
        }
        Movie movie = mItems.get(i);
        if (movie != null) {
            viewHolder.title.setText(movie.getTitle());
            viewHolder.year.setText("(" + movie.getYear() + ")");
            viewHolder.imageView.setImageUrl(movie.getMovieCoverURL(), mImageLoader);
            viewHolder.title.setTag(movie.getId());
            viewHolder.year.setTag(movie.getId());
            viewHolder.imageView.setTag(movie.getId());
        }

        return convertView;
    }

    static class ViewHolderItem {
        TextView title;
        TextView year;
        NetworkImageView imageView;
    }
}
