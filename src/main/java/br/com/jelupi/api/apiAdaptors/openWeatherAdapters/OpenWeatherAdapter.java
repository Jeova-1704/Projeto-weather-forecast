package br.com.jelupi.api.apiAdaptors.openWeatherAdapters;

import br.com.jelupi.api.apiAdaptors.ApiAdapter;
import br.com.jelupi.api.apiAdaptors.openWeatherAdapters.dtoGenerators.OpenWeatherDtoGenerators;
import br.com.jelupi.api.apiDtos.openWeatherDtos.WeatherCityDTO;
import br.com.jelupi.api.apiDtos.openWeatherDtos.CurrentWeatherDTO;
import br.com.jelupi.api.apiDtos.openWeatherDtos.WeatherListDTO;
import br.com.jelupi.api.apiDtos.openWeatherDtos.WeatherResponseDTO;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

/**
 * <i>Adapter</i> utilizado para tratar a requisição de informações do clima à <a href="https://openweathermap.org">OpenWeatherAPI</a>
 */
public class OpenWeatherAdapter implements ApiAdapter {
    // Atributos
    private final String jsonStringCurrentWeather;
    private final String jsonStringListWeathers;


    // Métodos
    /**
     * Recebe duas {@link String} json com informações do clima atual e previsões dos próximos 5 dias
     * @param jsonStringCurrentWeather {@link String} contendo o json com informações do clima atual
     * @param jsonStringListWeathers {@link String} contendo o json com informações do clima dos próximos 5 dias
     */
    public OpenWeatherAdapter(String jsonStringCurrentWeather, String jsonStringListWeathers) {
        this.jsonStringCurrentWeather = jsonStringCurrentWeather;
        this.jsonStringListWeathers = jsonStringListWeathers;
    }


    /**
     * Realiza o tratamento dos jsons com as informações do clima atual e dos próximos 5 dias fornecidos, coletando
     * informações e sintetizando-as em um {@link WeatherResponseDTO}
     * @return {@link WeatherResponseDTO} com informações da cidade, clima atual e clima dos próximos 5 dias
     */
    @Override
    public WeatherResponseDTO JsonToDTO() {
        JsonObject jsonObjectCurrentWeather = JsonParser.parseString(this.jsonStringCurrentWeather).getAsJsonObject();
        JsonObject jsonObjectListWeathers = JsonParser.parseString(this.jsonStringListWeathers).getAsJsonObject();

        WeatherCityDTO infCidade = OpenWeatherDtoGenerators.generateWeatherCityDTO(jsonObjectCurrentWeather);
        CurrentWeatherDTO infCurrentWeather = OpenWeatherDtoGenerators.generateWeatherDTO(jsonObjectCurrentWeather);
        ArrayList<WeatherListDTO> infDailyWeathers = OpenWeatherDtoGenerators.generateWeatherListDTO(jsonObjectListWeathers);

        return new WeatherResponseDTO(infCidade, infCurrentWeather, infDailyWeathers);
    }
}
