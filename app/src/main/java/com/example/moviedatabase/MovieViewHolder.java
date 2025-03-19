package com.example.moviedatabase;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieViewHolder extends RecyclerView.ViewHolder{

    //Variables
    private final ImageView posterImageView;
    private final TextView titleTextView;
    private final TextView yearTextView;
    private final TextView genreTextView;

    // Constructor
    public MovieViewHolder(@NonNull View itemView, final MovieAdapter.OnItemClickListener listener) {
        super(itemView);

        posterImageView = itemView.findViewById(R.id.posterImageView);
        titleTextView = itemView.findViewById(R.id.titleTextView);
        yearTextView = itemView.findViewById(R.id.yearTextView);
        genreTextView = itemView.findViewById(R.id.genreTextView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onItemClick(position);
                }
            }
        });
    }

    public void bind(Movie movie) {
        // Set the movie poster image from a drawable resource
        int posterResId = movie.getPosterResId();  // Assume you have a method that returns the resource ID
        posterImageView.setImageResource(posterResId);

        // Set the movie title
        titleTextView.setText(movie.getTitle());

        // Set the movie year
        yearTextView.setText(String.valueOf(movie.getYear()));

        // Set the movie genre
        genreTextView.setText(movie.getGenre());
    }

    //Getters
    public ImageView getPosterImageView() {
        return posterImageView;
    }

    public TextView getTitleTextView() {
        return titleTextView;
    }

    public TextView getYearTextView() {
        return yearTextView;
    }

    public TextView getGenreTextView() {
        return genreTextView;
    }



    // Set the text for the TextViews
        titleTextView.setText(movie.getTitle());
        yearTextView.setText(String.valueOf(movie.getYear()));
        genreTextView.setText(movie.getGenre());

    // Set the image for the ImageView (you can use a library like Glide or Picasso)
    // Example using Glide (you'll need to add Glide dependency to your build.gradle)
        Glide.with(itemView.getContext())
                .load(movie.getPosterResource())
            .into(posterImageView);
}
