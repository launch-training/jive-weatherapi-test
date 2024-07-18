package com.acn.jive.weatherApi;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class ApiService {


    public void displayWeatherData(String city, Connection connection){
        try{
            // 1. Fetch the API response based on API Link
            String API_KEY = "437ff40d4bf2412581d135526241807";
            String url = "https://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=" + city;
            HttpURLConnection apiConnection = connection.fetchApiResponse(url);

            // check for response status
            // 200 - means that the connection was a success
            if(apiConnection.getResponseCode() != 200){
                System.out.println("Error: Could not connect to API");
                return;
            }

            // 2. Read the response and convert store String type
            String jsonResponse = readApiResponse(apiConnection);

            // 3. Parse the string into a JSON Object
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);
            JSONObject currentWeatherJson = (JSONObject) jsonObject.get("current");
//            System.out.println(currentWeatherJson.toJSONString());

            // 4. Store the data into their corresponding data type
            double temperature = (double) currentWeatherJson.get("temp_c");
            System.out.println("Current Temperature (C): " + temperature);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private String readApiResponse(HttpURLConnection apiConnection) {
        try {
            // Create a StringBuilder to store the resulting JSON data
            StringBuilder resultJson = new StringBuilder();

            // Create a Scanner to read from the InputStream of the HttpURLConnection
            Scanner scanner = new Scanner(apiConnection.getInputStream());

            // Loop through each line in the response and append it to the StringBuilder
            while (scanner.hasNext()) {
                // Read and append the current line to the StringBuilder
                resultJson.append(scanner.nextLine());
            }

            // Close the Scanner to release resources associated with it
            scanner.close();

            // Return the JSON data as a String
            return resultJson.toString();

        } catch (IOException e) {
            // Print the exception details in case of an IOException
            e.printStackTrace();
        }

        // Return null if there was an issue reading the response
        return null;
    }
}
