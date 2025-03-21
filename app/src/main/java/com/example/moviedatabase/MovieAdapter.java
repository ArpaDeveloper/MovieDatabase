package com.example.moviedatabase;

//Imports
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * This class handles the Movies in the recyclerview
 * @author ArpaDev
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    //Define a list of movies and a listener
    private List<Movie> movies;
    private final OnItemClickListener listener;

    //Defines click listener
    public interface OnItemClickListener{
        void onItemClick(int position);
    }


    //Constructor
    public MovieAdapter(List<Movie> movies, OnItemClickListener listener){
        this.movies = movies;
        this.listener = listener;
    }

    //This method creates the view holder to manage the UI
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_layout, parent, false);
        return new MovieViewHolder(view, listener);
    }

    //This method gets the Movies position and binds it to right place
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position){
        Movie movie = movies.get(position);
        holder.bind(movie);
    }

    //This method returns the amount of movies in the list
    @Override
    public int getItemCount(){
        return movies != null ? movies.size() : 0;
    }

    //This method calls to refresh the recycler view
    public void updateMovies(List<Movie> newMovies){
        this.movies = newMovies;
        notifyDataSetChanged();
    }

}
