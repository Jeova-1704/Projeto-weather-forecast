package br.com.jelupi.api.apiAdaptors.openWeatherAdapters.dtoGenerators;

import br.com.jelupi.api.apiAdaptors.openWeatherAdapters.OpenWeatherAdapter;
import br.com.jelupi.api.apiDtos.openWeatherDtos.WeatherCityDTO;
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

/**
 * Classe auxiliar com métodos utilizados em {@link OpenWeatherAdapter#JsonToDTO()} para extrair informações json,
 * retornando-as em DTOs que sintetizam suas informações
 */
public class OpenWeatherDtoGenerators {

    /**
     * Sintetiza informações da cidade a partir de um {@link JsonObject}
     * @param jsonObject {@link JsonObject} contendo as informações da cidade
     * @return {@link WeatherCityDTO} contendo informações acerca do nome da cidade, ID na
     * <a href="https://openweathermap.org">OpenWeatherAPI</a>, país, latitude e longitude
     */
    public static WeatherCityDTO generateWeatherCityDTO(JsonObject jsonObject) {
        String cidade = jsonObject.get("name").getAsString();
        String id = jsonObject.get("id").getAsString();
        String pais = jsonObject.get("sys").getAsJsonObject().get("country").getAsString();


        float lon = jsonObject.get("coord").getAsJsonObject().get("lon").getAsFloat();
        float lat = jsonObject.get("coord").getAsJsonObject().get("lat").getAsFloat();

        return new WeatherCityDTO(cidade, id, pais, lat, lon);
    }

    /**
     * Sintetiza informações do clima a partir de um {@link JsonObject}
     * @param jsonObjectCurrentWeather {@link JsonObject} contendo informações do clima
     * @return {@link CurrentWeatherDTO} contendo informações acerca do clima, temperatura, temperatura máxima, temperatura
     * mínima, sensação térmica, humidade, velocidade do vento e visibilidade
     */
    public static CurrentWeatherDTO generateWeatherDTO(JsonObject jsonObjectCurrentWeather) {

        JsonArray weather = jsonObjectCurrentWeather.getAsJsonArray("weather");
        JsonObject main = jsonObjectCurrentWeather.get("main").getAsJsonObject();
        JsonObject wind = jsonObjectCurrentWeather.get("wind").getAsJsonObject();

        String clima = weather.get(0).getAsJsonObject().get("main").getAsJsonPrimitive().getAsString();

        Float temperatura = main.get("temp").getAsJsonPrimitive().getAsFloat();

        Float maxTemp = main.get("temp_max").getAsJsonPrimitive().getAsFloat();

        Float minTemp = main.get("temp_min").getAsJsonPrimitive().getAsFloat();

        Float sensTerm = main.get("feels_like").getAsJsonPrimitive().getAsFloat();

        int humidade = main.get("humidity").getAsJsonPrimitive().getAsInt();

        float velVento = wind.get("speed").getAsJsonPrimitive().getAsFloat();

        int visibilidade = jsonObjectCurrentWeather.get("visibility").getAsJsonPrimitive().getAsInt();

        return new CurrentWeatherDTO(clima, temperatura, maxTemp,
                minTemp, sensTerm, humidade, velVento, visibilidade);
    }


    /**
     * Sintetiza informações do clima a partir de um {@link JsonObject}
     * @param jsonObjectListWeathers {@link JsonObject} contendo informações do clima dos próximos 5 dias
     * @return {@link ArrayList<WeatherListDTO>} contendo informações do clima dos próximos 5 dias
     */
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
            Float tempMedia = ArrayListHandler.getMedia(ArrayListHandler.CastArrayList(inf.get("temps"), Integer.class));
            Float tempMin = ArrayListHandler.getMedia(ArrayListHandler.CastArrayList(inf.get("temps_max"), Integer.class));
            Float tempMax = ArrayListHandler.getMedia(ArrayListHandler.CastArrayList(inf.get("temps_min"), Integer.class));
            String clima = ArrayListHandler.getPalavraRecorrente(ArrayListHandler.CastArrayList(inf.get("condicoes"), String.class));
            weatherList.add(new WeatherListDTO(clima, tempMedia, tempMax, tempMin));
        }

        return weatherList;
    }


    // AUXILIARES

    /**
     * <i>Auxiliar</i> utilizado no método {@link OpenWeatherDtoGenerators#generateWeatherListDTO} para checkar se o
     * {@link HashMap} fornecido já possui o dia que está sendo verificado. Caso não possua, insere uma nova chave
     * correspondente ao dia ligado à {@link ArrayList} que reúne informações da temperatura média, máxima,
     * mínima e o clima correspondente àquele dia
     * @param dia {@link Integer} valor correspondente ao dia que está sendo verificado contando a partir do dia atual
     * @param dias {@link HashMap} que está armazenando as informações de cada um dos dias
     * @param element {@link JsonElement} com as informações do dia que está sendo checado
     */
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


    /**
     * <i>Auxiliar</i> utilizado no método {@link OpenWeatherDtoGenerators#checkDayAndInsertInf} para inserir as
     * informações do clima no {@link HashMap} fornecido que está armazenando as informações de cada dia
     * @param dias {@link HashMap} que está armazenando as informações do clima de cada um dos dias
     * @param element {@link JsonElement} contendo a informação do dia que está sendo checado
     * @param dia {@link Integer} valor correspondente ao dia que está sendo verificado contando a partir do dia atual
     */
    private static void insertWeatherInformations(HashMap<String, HashMap<String, ArrayList<Object>>> dias, JsonElement element, int dia) {
        dias.get(("dia" + dia)).get("temps").add(element.getAsJsonObject().get("main").getAsJsonObject().get("temp").getAsFloat());
        dias.get(("dia" + dia)).get("temps_max").add(element.getAsJsonObject().get("main").getAsJsonObject().get("temp_max").getAsFloat());
        dias.get(("dia" + dia)).get("temps_min").add(element.getAsJsonObject().get("main").getAsJsonObject().get("temp_min").getAsFloat());
        dias.get(("dia" + dia)).get("condicoes").add(element.getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("main").getAsString());
    }



}
