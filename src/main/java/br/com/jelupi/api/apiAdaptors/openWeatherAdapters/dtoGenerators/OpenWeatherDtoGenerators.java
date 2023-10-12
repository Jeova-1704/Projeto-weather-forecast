package br.com.jelupi.api.apiAdaptors.openWeatherAdapters.dtoGenerators;

import br.com.jelupi.api.apiDtos.CityDTO;
import br.com.jelupi.api.apiDtos.WeatherDTO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenWeatherDtoGenerators {

    public static WeatherDTO generateWeatherDTO(CityDTO infCidade, HashMap<String, JsonPrimitive> infCurrentWeather,
                                          ArrayList<JsonElement> infListWheaters) {

        String clima = infCurrentWeather.get("clima").getAsString();

        int temperatura = infCurrentWeather.get("temperatura").getAsInt();

        int maxTemp = infCurrentWeather.get("maxTemp").getAsInt();

        int minTemp = infCurrentWeather.get("minTemp").getAsInt();

        int sensTerm = infCurrentWeather.get("sensTerm").getAsInt();

        int humidade = infCurrentWeather.get("humidade").getAsInt();

        float velVento = infCurrentWeather.get("velVento").getAsFloat();

        int visibilidade = infCurrentWeather.get("visibilidade").getAsInt();

        return new WeatherDTO(infCidade, clima, temperatura, maxTemp,
                minTemp, sensTerm, humidade, velVento, visibilidade, infListWheaters);
    }

    public static CityDTO generateCityDTO(JsonObject jsonObject) {
        String cidade = jsonObject.get("name").getAsString();
        String id = jsonObject.get("id").getAsString();
        String pais = jsonObject.get("sys").getAsJsonObject().get("country").getAsString();


        float lon = jsonObject.get("coord").getAsJsonObject().get("lon").getAsFloat();
        float lat = jsonObject.get("coord").getAsJsonObject().get("lat").getAsFloat();

        return new CityDTO(cidade, id, pais, lat, lon);
    }

}
