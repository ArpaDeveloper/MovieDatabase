package com.example.moviedatabase;

import java.util.List;


import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Movie> movies;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }


    //Constructor
    public MovieAdapter(List<Movie> movies){

    }

    public MovieViewHolder onCreateViewHolder(ViewGroup, int){

    }

    public void onBindViewHolder(MovieViewHolder, int){

    }

    @Override
    public int getItemCount(){
        return items != null ? items.size() : 0;
    }

    public void updateMovies(List<Movie>){

    }

}
