package com.example.moviedatabase;

//Imports
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * This class calls the other classes
 * All classes were made with the help Teachers examples
 * ChatGPT was also used in some parts that I couldn't figure out (Mostly things to do with recyclerView and JSON file handling)
 * @author ArpaDev
 */
public class MainActivity extends AppCompatActivity {

    //Variables
    private RecyclerView movieRecyclerView;
    private TextView errorTextView;
    private MovieAdapter adapter;
    private List<Movie> movies;

    //Start method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Setup the RecyclerView
        SetupRecyclerView();

        //Load the data from Json
        loadMovieData();

    }

    //Method to setup the recyclerView
    public void SetupRecyclerView(){
        //Find the recyclerview and set it layout and size.
        movieRecyclerView = findViewById(R.id.movieRecyclerView);
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieRecyclerView.setHasFixedSize(true);
    }

    //Method to load movie data
    public void loadMovieData(){
        //Try loading from the JSON and catch errors
        try{
            movies = JsonUtils.loadMoviesFromJson(this, R.raw.movies);
        }
        catch (IOException | JSONException e) {
            showError("Error: Failed to load Json");
        }

        //Initialize the adapter and check for listener
        if (movies != null && !movies.isEmpty()) {
            adapter = new MovieAdapter(movies, position -> {
                Movie clickedMovie = movies.get(position);
                Log.d("Movie Clicked", clickedMovie.getTitle());
            });
            movieRecyclerView.setAdapter(adapter);
        } else {
            showError("No movies found.");
        }
    }

    //Method to print the errors for user
    public void showError(String message){
        errorTextView = findViewById(R.id.errorTextView);
        errorTextView.setText(message);
    }
}