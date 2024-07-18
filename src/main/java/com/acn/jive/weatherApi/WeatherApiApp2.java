package com.acn.jive.weatherApi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.Scanner;

public class WeatherApiApp2 {
    public void run() {
        Connection connection = new Connection();
        ApiService apiService = new ApiService();
        try{
            Scanner scanner = new Scanner(System.in);
            String city;
            do{
                // Retrieve user input
                System.out.println("===================================================");
                System.out.print("Enter City (Say No to Quit): ");
                city = scanner.nextLine();

                if(city.equalsIgnoreCase("No")) break;


                apiService.displayWeatherData(city, connection);
            }while(!city.equalsIgnoreCase("No"));

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        WeatherApiApp2 main = new WeatherApiApp2();
        main.run();
    }


}