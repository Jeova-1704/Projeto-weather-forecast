package br.com.jelupi.api.apiAdaptors.openWeatherAdapters.jsonExtractors;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.HashMap;

public class OpenWeatherJsonExtractors {
    public static HashMap<String, JsonPrimitive> extractCurrentWeather(JsonObject jsonObjectCurrentWeather) {
        HashMap<String, JsonPrimitive> infCurrentWeather = new HashMap<>();

        JsonArray weather = jsonObjectCurrentWeather.getAsJsonArray("weather");
        JsonObject main = jsonObjectCurrentWeather.get("main").getAsJsonObject();
        JsonObject wind = jsonObjectCurrentWeather.get("wind").getAsJsonObject();

        infCurrentWeather.put("clima", weather.get(0).getAsJsonObject().get("main").getAsJsonPrimitive());

        infCurrentWeather.put("temperatura", main.get("temp").getAsJsonPrimitive());

        infCurrentWeather.put("maxTemp", main.get("temp_max").getAsJsonPrimitive());

        infCurrentWeather.put("minTemp", main.get("temp_min").getAsJsonPrimitive());

        infCurrentWeather.put("sensTerm", main.get("feels_like").getAsJsonPrimitive());

        infCurrentWeather.put("humidade", main.get("humidity").getAsJsonPrimitive());

        infCurrentWeather.put("velVento", wind.get("speed").getAsJsonPrimitive());

        infCurrentWeather.put("visibilidade", jsonObjectCurrentWeather.get("visibility").getAsJsonPrimitive());

        return infCurrentWeather;
    }
}
