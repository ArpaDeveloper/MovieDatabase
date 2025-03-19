package com.example.moviedatabase;

import android.util.Log;

import java.util.Calendar;

public class Movie {

    private static final String TAG = "Movie";
    //Variables
    private String title;
    private Integer year;
    private String genre;
    private String posterResource;

    //Constructor
    public Movie(String title, Integer year, String genre, String posterResource){

        if(title == null || title.trim().isEmpty()){
            Log.e(TAG, "Error: Title can't be null or empty");
            this.title = "title";
        }
        else{
            this.title = title;
        }

        //Get the current year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        //First motion picture ever 1878 and Then newest you can put is current year + 50
        if(year == null || year < 1878 || year > currentYear+50){
            Log.e(TAG, "Error: Invalid year");
            this.year = 0;
        }
        else{
            this.year = year;
        }

        if(genre == null || genre.trim().isEmpty()){
            Log.e(TAG, "Error: Genre can't be null or empty");
            this.genre = "genre";
        }
        else {
            this.genre = genre;
        }

        if(posterResource == null || posterResource.trim().isEmpty()){
            Log.e(TAG, "Error: Poster resource can't be null or empty");
            this.posterResource = "poster";
        }
        else{
            this.posterResource = posterResource;
        }

    }

    //Getters
    public String getTitle(){
        return title;
    }
    public Integer getYear(){
        return year;
    }
    public String getGenre(){
        return genre;
    }
    public String getPosterResource(){
        return posterResource;
    }

    //Setters
    public void setTitle(){
        if(title == null || title.trim().isEmpty()){
            Log.e(TAG, "Error: Title can't be null or empty");
            this.title = "title";
        }
        else{
            this.title = title;
        }
    }
    public void setYear(Integer year){
        //Get the current year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        if(year == null || year < 1878 || year > currentYear+50){
            Log.e(TAG, "Error: Invalid year");
            this.year = 0;
        }
        else{
            this.year = year;
        }
    }
    public void setGenre(){
        if(genre == null || genre.trim().isEmpty()){
            Log.e(TAG, "Error: Genre can't be null or empty");
            this.genre = "genre";
        }
        else {
            this.genre = genre;
        }
    }
    public void setPosterResource(){
        if(posterResource == null || posterResource.trim().isEmpty()){
            Log.e(TAG, "Error: Poster resource can't be null or empty");
            this.posterResource = "poster";
        }
        else{
            this.posterResource = posterResource;
        }
    }
}
