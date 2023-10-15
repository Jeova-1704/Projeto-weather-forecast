package br.com.jelupi.api.apiAdaptors.openWeatherAdapters;

import br.com.jelupi.api.apiAdaptors.ApiAdapter;
import br.com.jelupi.api.apiAdaptors.openWeatherAdapters.dtoGenerators.OpenWeatherDtoGenerators;
import br.com.jelupi.api.apiDtos.openWeatherDtos.CityDTO;
import br.com.jelupi.api.apiDtos.openWeatherDtos.CurrentWeatherDTO;
import br.com.jelupi.api.apiDtos.openWeatherDtos.WeatherListDTO;
import br.com.jelupi.api.apiDtos.openWeatherDtos.WeatherResponseDTO;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;


public class OpenWeatherAdapter implements ApiAdapter {
    private final String jsonStringCurrentWeather;
    private final String jsonStringListWeathers;

    public OpenWeatherAdapter(String jsonStringCurrentWeather, String jsonStringListWeathers) {
        this.jsonStringCurrentWeather = jsonStringCurrentWeather;
        this.jsonStringListWeathers = jsonStringListWeathers;
    }

    @Override
    public WeatherResponseDTO JsonToDTO() {
        JsonObject jsonObjectCurrentWeather = JsonParser.parseString(this.jsonStringCurrentWeather).getAsJsonObject();
        JsonObject jsonObjectListWeathers = JsonParser.parseString(this.jsonStringListWeathers).getAsJsonObject();

        CityDTO infCidade = OpenWeatherDtoGenerators.generateCityDTO(jsonObjectCurrentWeather);
        CurrentWeatherDTO infCurrentWeather = OpenWeatherDtoGenerators.generateWeatherDTO(jsonObjectCurrentWeather);
        ArrayList<WeatherListDTO> infDailyWeathers = OpenWeatherDtoGenerators.generateWeatherListDTO(jsonObjectListWeathers);

        return new WeatherResponseDTO(infCidade, infCurrentWeather, infDailyWeathers);
    }
}
