package com.example.moviedatabase;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;


public class JsonUtils {
    private static final String TAG = "JsonUtils";

    public static List<Movie> loadMoviesFromJson(Context context, int resourceId) throws IOException, JSONException {
        List<Movie> movieList = new ArrayList<>();
        String jsonContent = readJsonFile(context, resourceId);

        //Lets Parse the JSON data
        JSONArray jsonArray = new JSONArray(jsonContent);  //Lets create JSON array from the string

        //Loop through array to get the details
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject movieObject = jsonArray.getJSONObject(i);

            //Create a Movie Object
            String title = movieObject.getString("title");
            int year = movieObject.getInt("year");
            String genre = movieObject.getString("genre");
            String posterResource = movieObject.getString("PosterResource");

            //Finally add the Movie Object to list
            movieList.add(new Movie(title, year, genre, posterResource));
        }
        return movieList;
    }

    private static String readJsonFile(Context context, int resourceId) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream inputStream = context.getResources().openRawResource(resourceId);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            Log.e(TAG, "Error reading JSON file", e);
            throw e;
        }
        return stringBuilder.toString();
    }


    private static void handleJsonException(Exception e, Context context){
        String message = "";

        if (e instanceof FileNotFoundException) {
            Log.e(TAG, "Error: File was not found", e);
            message = "File was not found";
        } else if (e instanceof JSONException) {
            Log.e(TAG, "Error: Movie data format is invalid", e);
            message = "Error movie data format is invalid";
        } else if (e instanceof IOException) {
            Log.e(TAG, "Error: Accessing the movies data", e);
            message = "Error accessing the movies data";
        } else {
            Log.e(TAG, "Error: Unexpected, Try again", e);
            message = "Unexpected error, Try again";
        }
        if (context instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) context;
            mainActivity.showError(message);
        }
    }


}
