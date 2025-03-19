package com.example.moviedatabase;

import android.content.Context;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class JsonUtils {
    private static final String TAG = "JsonUtils";

    public static List<Movie> loadMoviesFromJson(Context context){
        List<Movie> movieList = new ArrayList<>();

        try {
            //Open the movies.json from res/raw
            InputStream inputStream = context.getResources().openRawResource(R.raw.movies);
            InputStreamReader reader = new InputStreamReader(inputStream);
        }
    }

    private static void handleJsonException(Exception e){

    }
}
