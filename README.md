# Weather API Application

## Overview

This Java application fetches and displays weather information for a given city using a weather API. The program allows the user to enter a city name and retrieves the current weather details, including temperature, description, local time, and an icon URL representing the weather condition.

## Code Structure

The code is organized into several classes, each with specific responsibilities:

1. `WeatherApiApp2` - Main application class that handles user input and coordinates the fetching and displaying of weather data.
2. `Weather` - A data model class to store weather information.
3. `Connection` - A utility class to handle HTTP connections to the weather API.
4. `ApiService` - A service class that interacts with the API and processes the response.

## Detailed Explanation

### `WeatherApiApp2` Class

This is the main entry point of the application. It includes the `run` method, which continuously prompts the user to enter a city name until they choose to quit by typing "No".

#### Key Methods:

- **run()**: 
  - Prompts the user for a city name.
  - If the user inputs "No", the loop breaks and the program exits.
  - Otherwise, it calls `displayWeatherData` method of `ApiService` to fetch and display the weather information.

- **main(String[] args)**: 
  - Creates an instance of `WeatherApiApp2` and invokes the `run` method.

### `Weather` Class

This class represents the weather data model, with attributes for city, temperature, description, icon URL, and local time.

### `Connection` Class

This class handles the creation of HTTP connections to the weather API.

#### Key Methods:

- **fetchApiResponse(String urlString)**: 
  - Establishes an HTTP GET connection to the provided URL.
  - Returns an `HttpURLConnection` object if successful, otherwise returns null.

### `ApiService` Class

This class manages the interaction with the weather API, including sending requests, parsing responses, and displaying the data.

#### Key Methods:

- **displayWeatherData(String city, Connection connection)**: 
  - Constructs the API URL using the provided city name and API key.
  - Fetches the API response using the `Connection` class.
  - Parses the JSON response to extract weather information.
  - Displays the weather details (temperature, description, local time, icon URL).
  - Stores the weather data in a `Weather` object.

- **readApiResponse(HttpURLConnection apiConnection)**: 
  - Reads the API response from the `HttpURLConnection` input stream.
  - Returns the response as a JSON string.


## Notes

- **Dependencies**: Ensure you have the `org.json.simple` library included in your project for JSON parsing.
- **API Key**: Replace the placeholder API key (`437ff40d4bf2412581d135526241807`) with a valid key from the weather API provider.

