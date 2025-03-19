package com.example.moviedatabase;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
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






    private static void handleJsonException(Exception e){

    }
}
