package br.com.jelupi.api.apiAdaptors.openWeatherAdapters.dtoGenerators;

import br.com.jelupi.api.apiDtos.openWeatherDtos.CityDTO;
import br.com.jelupi.api.apiDtos.openWeatherDtos.CurrentWeatherDTO;
import br.com.jelupi.api.apiDtos.openWeatherDtos.WeatherListDTO;
import br.com.jelupi.utils.ArrayListHandler;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class OpenWeatherDtoGenerators {

    public static CityDTO generateCityDTO(JsonObject jsonObject) {
        String cidade = jsonObject.get("name").getAsString();
        String id = jsonObject.get("id").getAsString();
        String pais = jsonObject.get("sys").getAsJsonObject().get("country").getAsString();


        float lon = jsonObject.get("coord").getAsJsonObject().get("lon").getAsFloat();
        float lat = jsonObject.get("coord").getAsJsonObject().get("lat").getAsFloat();

        return new CityDTO(cidade, id, pais, lat, lon);
    }

    public static CurrentWeatherDTO generateWeatherDTO(JsonObject jsonObjectCurrentWeather) {

        JsonArray weather = jsonObjectCurrentWeather.getAsJsonArray("weather");
        JsonObject main = jsonObjectCurrentWeather.get("main").getAsJsonObject();
        JsonObject wind = jsonObjectCurrentWeather.get("wind").getAsJsonObject();

        String clima = weather.get(0).getAsJsonObject().get("main").getAsJsonPrimitive().getAsString();

        int temperatura = main.get("temp").getAsJsonPrimitive().getAsInt();

        int maxTemp = main.get("temp_max").getAsJsonPrimitive().getAsInt();

        int minTemp = main.get("temp_min").getAsJsonPrimitive().getAsInt();

        int sensTerm = main.get("feels_like").getAsJsonPrimitive().getAsInt();

        int humidade = main.get("humidity").getAsJsonPrimitive().getAsInt();

        float velVento = wind.get("speed").getAsJsonPrimitive().getAsFloat();

        int visibilidade = jsonObjectCurrentWeather.get("visibility").getAsJsonPrimitive().getAsInt();

        return new CurrentWeatherDTO(clima, temperatura, maxTemp,
                minTemp, sensTerm, humidade, velVento, visibilidade);
    }

    public static ArrayList<WeatherListDTO> generateWeatherListDTO(JsonObject jsonObjectListWeathers) {
        LocalDateTime dataAtual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        HashMap<String, HashMap<String, ArrayList<Object>>> dias = new HashMap<>();

        for (JsonElement element : jsonObjectListWeathers.get("list").getAsJsonArray()) {
            if (element.getAsJsonObject().get("dt_txt").getAsString().contains(dataAtual.plusDays(1).format(formato))) {
                checkDayAndInsertInf(1, dias, element);
            } else if (element.getAsJsonObject().get("dt_txt").getAsString().contains(dataAtual.plusDays(2).format(formato))) {
                checkDayAndInsertInf(2, dias, element);
            } else if (element.getAsJsonObject().get("dt_txt").getAsString().contains(dataAtual.plusDays(3).format(formato))) {
                checkDayAndInsertInf(3, dias, element);
            } else if (element.getAsJsonObject().get("dt_txt").getAsString().contains(dataAtual.plusDays(4).format(formato))) {
                checkDayAndInsertInf(4, dias, element);
            } else if (element.getAsJsonObject().get("dt_txt").getAsString().contains(dataAtual.plusDays(5).format(formato))) {
                checkDayAndInsertInf(5, dias, element);
            }
        }

        ArrayList<WeatherListDTO> weatherList = new ArrayList<>();
        for (HashMap<String, ArrayList<Object>> inf : dias.values()) {
            Float tempMedia = ArrayListHandler.getMedia(ArrayListHandler.CastArrayList(inf.get("temps"), Float.class));
            Float tempMin = ArrayListHandler.getMedia(ArrayListHandler.CastArrayList(inf.get("temps_max"), Float.class));
            Float tempMax = ArrayListHandler.getMedia(ArrayListHandler.CastArrayList(inf.get("temps_min"), Float.class));
            String clima = ArrayListHandler.getPalavraRecorrente(ArrayListHandler.CastArrayList(inf.get("condicoes"), String.class));
            weatherList.add(new WeatherListDTO(clima, tempMedia, tempMax, tempMin));
        }

        return weatherList;
    }

    private static void checkDayAndInsertInf(int dia, HashMap<String, HashMap<String, ArrayList<Object>>> dias, JsonElement element) {
        if (!dias.containsKey("dia" + dia)) {
            dias.put(("dia" + dia), new HashMap<>());
            dias.get(("dia" + dia)).put("temps", new ArrayList<>());
            dias.get(("dia" + dia)).put("temps_max", new ArrayList<>());
            dias.get(("dia" + dia)).put("temps_min", new ArrayList<>());
            dias.get(("dia" + dia)).put("condicoes", new ArrayList<>());
        }
        insertWeatherInformations(dias, element, dia);
    }

    private static void insertWeatherInformations(HashMap<String, HashMap<String, ArrayList<Object>>> dias, JsonElement element, int dia) {
        dias.get(("dia" + dia)).get("temps").add(element.getAsJsonObject().get("main").getAsJsonObject().get("temp").getAsFloat());
        dias.get(("dia" + dia)).get("temps_max").add(element.getAsJsonObject().get("main").getAsJsonObject().get("temp_max").getAsFloat());
        dias.get(("dia" + dia)).get("temps_min").add(element.getAsJsonObject().get("main").getAsJsonObject().get("temp_min").getAsFloat());
        dias.get(("dia" + dia)).get("condicoes").add(element.getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("main").getAsString());
    }



}
