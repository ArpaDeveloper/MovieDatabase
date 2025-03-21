package com.example.moviedatabase;

//Imports
import android.util.Log;

import java.util.Calendar;

/**
 * This class defines Movie Objects
 * @author ArpaDev
 */
public class Movie {
    //Tag for errors
    private static final String TAG = "Movie";
    //Variables
    private String title;
    private Integer year;
    private String genre;
    private String posterResource;

    //Constructor
    public Movie(String title, Integer year, String genre, String posterResource){

        //Check if the title is correct
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
            this.year = -1;
        }
        else{
            this.year = year;
        }

        //Check if the genre is correct
        if(genre == null || genre.trim().isEmpty()){
            Log.e(TAG, "Error: Genre can't be null or empty");
            this.genre = "genre";
        }
        else {
            this.genre = genre;
        }

        //Check if the poster is correct
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


}
