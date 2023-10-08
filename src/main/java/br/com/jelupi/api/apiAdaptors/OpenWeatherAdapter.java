package br.com.jelupi.api.apiAdaptors;

import br.com.jelupi.api.apiDtos.WeatherDTO;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class OpenWeatherAdapter implements WeatherApiAdapter {
    private final String jsonString;

    public OpenWeatherAdapter(String jsonString) {
        this.jsonString = jsonString;
    }

    @Override
    public WeatherDTO JsonToDTO() {
        JsonObject jsonObject = JsonParser.parseString(this.jsonString).getAsJsonObject();
        System.out.println(this.jsonString);

        JsonArray weather = jsonObject.getAsJsonArray("weather");
        JsonObject main = jsonObject.get("main").getAsJsonObject();
        JsonObject wind = jsonObject.get("wind").getAsJsonObject();

        String clima = weather.get(0).getAsJsonObject().get("main").getAsString();

        int temperatura = main.get("temp").getAsInt();

        int maxTemp = main.get("temp_max").getAsInt();

        int minTemp = main.get("temp_min").getAsInt();

        int sensTerm = main.get("feels_like").getAsInt();

        int humidade = main.get("humidity").getAsInt();

        float velVento = wind.get("speed").getAsFloat();

        int visibilidade = jsonObject.get("visibility").getAsInt();


        return new WeatherDTO(clima, temperatura, maxTemp, minTemp, sensTerm, humidade, velVento, visibilidade);

    }
}
