package br.com.jelupi.service;

import br.com.jelupi.api.apiAdaptors.OpenWeatherAdapter;
import br.com.jelupi.api.apiConfigs.OpenWeather;
import br.com.jelupi.api.apiDtos.WeatherDTO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class OpenWeatherService implements IWeatherService {

    @Override
    public String getWeatherInformation(String jsonRequest) {

        HashMap<String, Float> cityCoordinates = this.extrairLogLat(jsonRequest);

        String apiKey = OpenWeather.API_KEY.value();
        String urlRequest = OpenWeather.CITY_WEATHER_UNFORMATED_URL.value()
                .formatted(cityCoordinates.get("lat"), cityCoordinates.get("log"), apiKey);

        String JsonApiRequest = this.getWeatherJsonResponse(urlRequest);

        OpenWeatherAdapter weatherAdapter = new OpenWeatherAdapter(JsonApiRequest);
        WeatherDTO weatherDTO = weatherAdapter.JsonToDTO();

        return this.generateJsonFromDTO(weatherDTO);
    }

    private HashMap<String, Float> extrairLogLat(String jsonRequest) {
        JsonObject jsonRequestObject = JsonParser.parseString(jsonRequest).getAsJsonObject();
        Float latitude = jsonRequestObject.get("lat").getAsFloat();
        Float longitude = jsonRequestObject.get("log").getAsFloat();

        HashMap<String, Float> cityCoordinates = new HashMap<>();

        cityCoordinates.put("lat", latitude);
        cityCoordinates.put("log", longitude);

        return cityCoordinates;
    }

    private String getWeatherJsonResponse(String urlRequest) {
        HttpRequest getRequest;               // Usado para fazer uma requisição com method "GET"
        HttpResponse<String> httpResponse;   // Encapsula os resultados da requisição
        HttpClient client;                  //  Cliente HTTP para receber a requisição e enviar o resultado

        try {
            client = HttpClient.newHttpClient();

            getRequest = HttpRequest.newBuilder()
                    .uri(new URI(urlRequest))
                    .GET().build();

            httpResponse =  client.send(getRequest, HttpResponse.BodyHandlers.ofString());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            System.out.printf("Não foi possível acessar a API na seguinte URL: %s", urlRequest);
            return null;
        }

        return httpResponse.body();
    }

    private String generateJsonFromDTO(WeatherDTO weatherDTO) {
        Gson gson = new Gson();
        return gson.toJson(weatherDTO);
    }
}
