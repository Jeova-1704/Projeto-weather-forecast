package br.com.jelupi.service;

import br.com.jelupi.api.apiAdaptors.openWeatherAdapters.OpenWeatherAdapter;
import br.com.jelupi.api.apiConfigs.OpenWeatherAPI;
import br.com.jelupi.api.apiDtos.WeatherDTO;
import br.com.jelupi.utils.HttpRequestHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;

public class OpenWeatherService implements IWeatherService {

    @Override
    public String getWeatherInformation(String jsonRequest) {

        HashMap<String, Float> cityCoordinates = this.extrairLogLat(jsonRequest);

        String apiKey = OpenWeatherAPI.API_KEY.value();
        String urlRequestCurrentWeather = OpenWeatherAPI.CITY_WEATHER_UNFORMATED_URL.value()
                            .formatted(cityCoordinates.get("lat"), cityCoordinates.get("lon"), apiKey);
        String urlRequestListWeathers = OpenWeatherAPI.CITY_WEATHER_LIST_UNFORMATED_URL.value()
                            .formatted(cityCoordinates.get("lat"), cityCoordinates.get("lon"), apiKey);

        String jsonApiRequestCurrentWeather = HttpRequestHandler.getJsonResponse(urlRequestCurrentWeather);
        String jsonApiRequestListWeathers = HttpRequestHandler.getJsonResponse(urlRequestListWeathers);

        OpenWeatherAdapter weatherAdapter = new OpenWeatherAdapter(jsonApiRequestCurrentWeather, jsonApiRequestListWeathers);
        WeatherDTO weatherDTO = weatherAdapter.JsonToDTO();

        return this.generateJsonFromDTO(weatherDTO);
    }

    private HashMap<String, Float> extrairLogLat(String jsonRequest) {
        JsonObject jsonRequestObject = JsonParser.parseString(jsonRequest).getAsJsonObject();
        Float latitude = jsonRequestObject.get("lat").getAsFloat();
        Float longitude = jsonRequestObject.get("lon").getAsFloat();

        HashMap<String, Float> cityCoordinates = new HashMap<>();

        cityCoordinates.put("lat", latitude);
        cityCoordinates.put("lon", longitude);

        return cityCoordinates;
    }

    private String generateJsonFromDTO(WeatherDTO weatherDTO) {
        Gson gson = new Gson();
        return gson.toJson(weatherDTO);
    }
}
