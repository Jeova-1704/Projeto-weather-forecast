package br.com.jelupi.api.apiAdaptors;

import br.com.jelupi.api.apiDtos.CityDTO;
import br.com.jelupi.api.apiDtos.WeatherDTO;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class OpenWeatherAdapter implements ApiAdapter {
    private final String jsonString;

    public OpenWeatherAdapter(String jsonString) {
        this.jsonString = jsonString;
    }

    @Override
    public WeatherDTO JsonToDTO() {
        JsonObject jsonObject = JsonParser.parseString(this.jsonString).getAsJsonObject();

        JsonArray weather = jsonObject.getAsJsonArray("weather");
        JsonObject main = jsonObject.get("main").getAsJsonObject();
        JsonObject wind = jsonObject.get("wind").getAsJsonObject();

        CityDTO infCidade = this.generateCityDTO(jsonObject);

        String clima = weather.get(0).getAsJsonObject().get("main").getAsString();

        int temperatura = main.get("temp").getAsInt();

        int maxTemp = main.get("temp_max").getAsInt();

        int minTemp = main.get("temp_min").getAsInt();

        int sensTerm = main.get("feels_like").getAsInt();

        int humidade = main.get("humidity").getAsInt();

        float velVento = wind.get("speed").getAsFloat();

        int visibilidade = jsonObject.get("visibility").getAsInt();


        return new WeatherDTO(infCidade, clima, temperatura, maxTemp, minTemp, sensTerm, humidade, velVento, visibilidade);

    }

    private CityDTO generateCityDTO(JsonObject jsonObject) {
        String cidade = jsonObject.get("name").getAsString();
        String id = jsonObject.get("id").getAsString();
        String pais = jsonObject.get("sys").getAsJsonObject().get("country").getAsString();


        float lon = jsonObject.get("coord").getAsJsonObject().get("lon").getAsFloat();
        float lat = jsonObject.get("coord").getAsJsonObject().get("lon").getAsFloat();

        return new CityDTO(cidade, id, pais, lat, lon);
    }
}
