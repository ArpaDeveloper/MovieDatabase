package com.example.moviedatabase;

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

public class MainActivity extends AppCompatActivity {

    //Variables
    private RecyclerView movieRecyclerView;
    private TextView errorTextView;
    private MovieAdapter adapter;
    private List<Movie> movies;

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

    public void SetupRecyclerView(){
        movieRecyclerView = findViewById(R.id.movieRecyclerView);
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieRecyclerView.setHasFixedSize(true);
    }

    public void loadMovieData(){
        try{
            movies = JsonUtils.loadMoviesFromJson(this, R.raw.movies);
        }
        catch (IOException | JSONException e) {
            showError("Error: Failed to load Json");
        }

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

    public void showError(String message){
        errorTextView = findViewById(R.id.errorTextView);
        errorTextView.setText(message);
    }
}