package com.example.moviedatabase;

import android.content.Context;

import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtils {
    private static final String TAG = "JsonUtils";

    public static List<Movie> loadMoviesFromJson(Context context, int resourceID) throws IOException{
        InputStreamReader reader = new InputStreamReader(context.getAssets().open("movies.json"));
    }

    private static void handleJsonException(Exception e){

    }
}
