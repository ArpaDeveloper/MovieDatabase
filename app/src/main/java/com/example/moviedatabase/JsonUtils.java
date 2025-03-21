package com.example.moviedatabase;

//Imports
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

/**
 * This class handles errors and JSON files
 * @author ArpaDev
 */
public class JsonUtils {
    //This tag is used in error messages
    private static final String TAG = "JsonUtils";

    //This methods handles the loading of the file contents
    public static List<Movie> loadMoviesFromJson(Context context, int resourceId) throws IOException, JSONException {
        //Declare a ArrayList of movies
        List<Movie> movieList = new ArrayList<>();
        //String to store the contents of JSON file
        String jsonContent = readJsonFile(context, resourceId);
        Log.d("JSON Debug", "Loaded JSON: " + jsonContent);

        //Lets Parse the JSON data
        //Lets create JSON array from the string
        JSONArray jsonArray = new JSONArray(jsonContent);

        //Loop through array to get the details
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject movieObject = jsonArray.getJSONObject(i);
            //Get all the details and if they are incorrect/missing put a placeholder
            String title = movieObject.has("title") && !movieObject.isNull("title")
                    ? movieObject.optString("title", "Unknown Title")
                    : "Unknown Title";

            int year = movieObject.has("year") ? movieObject.optInt("year", -1) : -1;

            String genre = movieObject.has("genre") && !movieObject.isNull("genre")
                    ? movieObject.optString("genre", "Unknown Genre")
                    : "Unknown Genre";

            String posterResource = movieObject.has("poster") && !movieObject.isNull("poster")
                    ? movieObject.optString("poster", "poster")
                    : "poster";

            //Finally add the Movie Object to list
            movieList.add(new Movie(title, year, genre, posterResource));
        }
        //Return the list
        return movieList;
    }

    //This method reads the JSON file and returns a string
    private static String readJsonFile(Context context, int resourceId) throws IOException {
        //Declare a String builder, which allows for better string manipulation
        StringBuilder stringBuilder = new StringBuilder();
        //Read the JSON file using buffered reader
        try (InputStream inputStream = context.getResources().openRawResource(resourceId);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            //Loop through as long as there is a line
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        //Catch IOException and throw it
        } catch (IOException e) {
            Log.e(TAG, "Error reading JSON file", e);
            throw e;
        }
        //Return the full string
        return stringBuilder.toString();
    }

    //This method handles exceptions
    private static void handleJsonException(Exception e, Context context){
        //Declare message (This will be returned to MainActivity and printed)
        String message = "";
        //Different message for different errors
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
        //If the context is from MainActivity call the print method there
        if (context instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) context;
            mainActivity.showError(message);
        }
    }


}
