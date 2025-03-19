package com.example.moviedatabase;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> movies;
    private final OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }


    //Constructor
    public MovieAdapter(List<Movie> movies, OnItemClickListener listener){
        this.movies = movies;
        this.listener = listener;
    }
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_layout, parent, false);
        return new MovieViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position){
        Movie movie = movies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount(){
        return movies != null ? movies.size() : 0;
    }

    public void updateMovies(List<Movie> newMovies){
        this.movies = newMovies;
        notifyDataSetChanged();
    }

}
