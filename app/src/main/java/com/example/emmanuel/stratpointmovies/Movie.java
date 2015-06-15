package com.example.emmanuel.stratpointmovies;

import java.util.ArrayList;

/**
 * Created by Emmanuel on 6/14/2015.
 */
public class Movie {
    private Double rating;
    private ArrayList<String> genres;
    private String language;
    private String title;
    private String url;
    private String titleLong;
    private String imdbCode;
    private Integer id;
    private String state;
    private Integer year;
    private Integer runtime;
    private String overview;
    private String slug;
    private String mpaRating;
    private boolean isActive = false;

    public Movie(ArrayList<String> genres, Double rating, String language, String title,
                 String url, String titleLong, String imdbCode, Integer id, String state, Integer year,
                 Integer runtime, String overview, String slug, String mpaRating) {
        this.genres = genres;
        this.rating = rating;
        this.language = language;
        this.title = title;
        this.url = url;
        this.titleLong = titleLong;
        this.imdbCode = imdbCode;
        this.id = id;
        this.state = state;
        this.year = year;
        this.runtime = runtime;
        this.overview = overview;
        this.slug = slug;
        this.mpaRating = mpaRating;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitleLong() {
        return titleLong;
    }

    public void setTitleLong(String titleLong) {
        this.titleLong = titleLong;
    }

    public String getImdbCode() {
        return imdbCode;
    }

    public void setImdbCode(String imdbCode) {
        this.imdbCode = imdbCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getMpaRating() {
        return mpaRating;
    }

    public void setMpaRating(String mpaRating) {
        this.mpaRating = mpaRating;
    }

    public String getMovieCoverURL() {
        return "https://dl.dropboxusercontent.com/u/5624850/movielist/images/" + slug
                + "-cover.jpg";
    }

    public String getMovieBackDropURL() {
        return "https://dl.dropboxusercontent.com/u/5624850/movielist/images/" + slug
                + "-backdrop.jpg";
    }
}
