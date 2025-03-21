package com.example.moviedatabase;

//Imports
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * This class manages UI for single movie object
 * @author ArpaDev
 */
public class MovieViewHolder extends RecyclerView.ViewHolder{

    //Variables
    private final ImageView posterImageView;
    private final TextView titleTextView;
    private final TextView yearTextView;
    private final TextView genreTextView;

    //Constructor
    public MovieViewHolder(@NonNull View itemView, final MovieAdapter.OnItemClickListener listener) {
        super(itemView);

        posterImageView = itemView.findViewById(R.id.posterImageView);
        titleTextView = itemView.findViewById(R.id.titleTextView);
        yearTextView = itemView.findViewById(R.id.yearTextView);
        genreTextView = itemView.findViewById(R.id.genreTextView);
        //Define a listener
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

    //Binds the movies data to the ui
    public void bind(Movie movie) {

        titleTextView.setText(movie.getTitle());
        yearTextView.setText(String.valueOf(movie.getYear()));
        genreTextView.setText(movie.getGenre());
        String posterName = movie.getPosterResource();

        int imageResId = itemView.getContext().getResources()
                .getIdentifier(posterName, "drawable", itemView.getContext().getPackageName());

        posterImageView.setImageResource(imageResId);

    }


}
