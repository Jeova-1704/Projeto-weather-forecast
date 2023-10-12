package br.com.jelupi.api.apiAdaptors.openWeatherAdapters;

import br.com.jelupi.api.apiAdaptors.ApiAdapter;
import br.com.jelupi.api.apiAdaptors.openWeatherAdapters.dtoGenerators.OpenWeatherDtoGenerators;
import br.com.jelupi.api.apiAdaptors.openWeatherAdapters.jsonExtractors.OpenWeatherJsonExtractors;
import br.com.jelupi.api.apiDtos.CityDTO;
import br.com.jelupi.api.apiDtos.WeatherDTO;
import com.google.gson.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;


public class OpenWeatherAdapter implements ApiAdapter {
    private final String jsonStringCurrentWeather;
    private final String jsonStringListWeathers;

    public OpenWeatherAdapter(String jsonStringCurrentWeather, String jsonStringListWeathers) {
        this.jsonStringCurrentWeather = jsonStringCurrentWeather;
        this.jsonStringListWeathers = jsonStringListWeathers;
    }

    @Override
    public WeatherDTO JsonToDTO() {
        JsonObject jsonObjectCurrentWeather = JsonParser.parseString(this.jsonStringCurrentWeather).getAsJsonObject();
        JsonObject jsonObjectListWeathers = JsonParser.parseString(this.jsonStringListWeathers).getAsJsonObject();

        CityDTO infCidade = OpenWeatherDtoGenerators.generateCityDTO(jsonObjectCurrentWeather);

        HashMap<String, JsonPrimitive> infCurrentWeather = OpenWeatherJsonExtractors.extractCurrentWeather(jsonObjectCurrentWeather);

        ArrayList<JsonElement> infListWeathers = this.extractListWeathers(jsonObjectListWeathers);

        return OpenWeatherDtoGenerators.generateWeatherDTO(infCidade, infCurrentWeather, infListWeathers);
    }

    private ArrayList<JsonElement> extractListWeathers (JsonObject jsonObjectListWeather) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
        LocalDateTime Date = LocalDateTime.now();
        System.out.println(Date.format(formatter));
        ArrayList<JsonElement> infListWeathers = new ArrayList<>();
        System.out.println(jsonObjectListWeather);

        for (JsonElement element : jsonObjectListWeather.get("list").getAsJsonArray()) {
            if (element.getAsJsonObject().get("dt_txt").getAsString().contains(Date.plusDays(1).format(formatter))) {
                infListWeathers.add(element.getAsJsonObject().get("main").getAsJsonObject().get("temp"));
            }
        }
        return infListWeathers;
    }

}
