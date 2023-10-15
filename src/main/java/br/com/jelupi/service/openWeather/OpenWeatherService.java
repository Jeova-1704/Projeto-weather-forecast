package br.com.jelupi.service.openWeather;

import br.com.jelupi.api.apiAdaptors.openWeatherAdapters.OpenWeatherAdapter;
import br.com.jelupi.api.apiConfigs.OpenWeatherAPI;
import br.com.jelupi.api.apiDtos.openWeatherDtos.WeatherResponseDTO;
import br.com.jelupi.service.IWeatherService;
import br.com.jelupi.utils.HttpRequestHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;

public class OpenWeatherService implements IWeatherService {

    /**
     * Fornece {@link String} com as informações da cidade, clima atual e previsões dos próximos 5 dias
     * @param jsonRequest {@link String} contendo o Json da requisição com informações da longitude ("lon")
     *                                 e latitude ("lat")
     * @return {@link String} do Json com as informações
     */
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
        WeatherResponseDTO currentWeatherDTO = weatherAdapter.JsonToDTO();

        return this.generateJsonFromDTO(currentWeatherDTO);
    }


    // AUXILIARES

    /**
     * Auxiliar no método {@link OpenWeatherService#getWeatherInformation} para extrair informações da latitude
     * e longitude passados no Json
     * @param jsonRequest {@link String} do Json com as informações
     * @return {@link HashMap} com a latitude e longitude já convertidos em {@link Float}
     */
    private HashMap<String, Float> extrairLogLat(String jsonRequest) {
        JsonObject jsonRequestObject = JsonParser.parseString(jsonRequest).getAsJsonObject();
        Float latitude = jsonRequestObject.get("lat").getAsFloat();
        Float longitude = jsonRequestObject.get("lon").getAsFloat();

        HashMap<String, Float> cityCoordinates = new HashMap<>();

        cityCoordinates.put("lat", latitude);
        cityCoordinates.put("lon", longitude);

        return cityCoordinates;
    }


    /**
     * Auxiliar no método {@link OpenWeatherService#getWeatherInformation} para transformar o DTO fornecido em uma
     * {@link String } com o json
     * @param weatherResponseDTO {@link WeatherResponseDTO} contendo as informações da cidade, clima atual e previsões
*                                                           para os próximos 5 dias
     * @return {@link String} contendo o Json com as informações extraídas do {@link WeatherResponseDTO}
     */
    private String generateJsonFromDTO(WeatherResponseDTO weatherResponseDTO) {
        Gson gson = new Gson();
        return gson.toJson(weatherResponseDTO);
    }
}
