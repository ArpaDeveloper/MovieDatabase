package com.example.moviedatabase;

import java.util.Calendar;

public class Movie {

    //Variables
    private String title;
    private Integer year;
    private String genre;
    private String posterResource;

    //Constructor
    public Movie(String title, Integer year, String genre, String posterResource){

        if(title == null || title.trim().isEmpty()){
            throw new IllegalArgumentException("Error: Title can't be null or empty");
        }

        //Get the current year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        //First motion picture ever 1878 and Then newest you can put is current year + 50
        if(year == null || year < 1878 || year > currentYear+50){
            throw new IllegalArgumentException("Error: Invalid year");
        }
        if(genre == null || genre.trim().isEmpty()){
            throw new IllegalArgumentException("Error: Genre can't be null or empty");
        }
        if(posterResource == null || posterResource.trim().isEmpty()){
            throw new IllegalArgumentException("Error: Poster resource can't be null or empty");
        }

        this.title = title;
        this.year = year;
        this.genre = genre;
        this.posterResource = posterResource;
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
            throw new IllegalArgumentException("Error: Title can't be null or empty");
        }
        this.title = title;
    }
    public void setYear(Integer year){
        //Get the current year
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        if(year == null || year < 1878 || year > currentYear+50){
            throw new IllegalArgumentException("Error: Invalid year");
        }
        this.year = year;
    }
    public void setGenre(){
        if(genre == null || genre.trim().isEmpty()){
            throw new IllegalArgumentException("Error: Genre can't be null or empty");
        }
        this.genre = genre;
    }
    public void setPosterResource(){
        if(posterResource == null || posterResource.trim().isEmpty()){
            throw new IllegalArgumentException("Error: Poster resource can't be null or empty");
        }
        this.posterResource = posterResource;
    }
}
