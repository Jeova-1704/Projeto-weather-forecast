package br.com.jelupi.service.nominatim;

import br.com.jelupi.api.apiAdaptors.nominatinAdapters.NominatinAdapter;
import br.com.jelupi.api.apiConfigs.NominatimAPI;
import br.com.jelupi.api.apiDtos.nominatim.CityResponseDTO;
import br.com.jelupi.api.apiDtos.openWeatherDtos.WeatherResponseDTO;
import br.com.jelupi.service.ICityService;
import br.com.jelupi.service.openWeather.OpenWeatherService;
import br.com.jelupi.utils.HttpRequestHandler;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class NominatimCityService implements ICityService {

    /**
     * Fornece uma {@link String} json composto de um <i>array</i> de <i>objetos</i> com as informações
     * sintetizadas das cidades encontradas
     * @param jsonRequest {@link String} json com as informações da requisição da cidade (cidade, micro-região, país, etc...)
     * @return {@link String} json
     */
    @Override
    public String getCityInformation(String jsonRequest) {
        JsonObject jsonObject = JsonParser.parseString(jsonRequest).getAsJsonObject();
        String pesquisaCidade = jsonObject.get("pesquisa_cidade").getAsString();

        String urlRequestCity = NominatimAPI.CITY_UNFORMATED_URL.value().formatted(pesquisaCidade);
        System.out.println(urlRequestCity);

        String jsonResponse = HttpRequestHandler.getJsonResponse(urlRequestCity);

        NominatinAdapter nominatinAdapter = new NominatinAdapter(jsonResponse);
        CityResponseDTO cityResponseDTO = nominatinAdapter.JsonToDTO();

        return generateJsonFromDTO(cityResponseDTO);
    }

    /**
     * Auxiliar no método {@link OpenWeatherService#getWeatherInformation} para transformar o DTO fornecido em uma
     * {@link String } com o json
     * @param cityResponseDTO {@link CityResponseDTO} contendo as informações sintetizadas das cidades armazenadas em
*                                                     um {@link java.util.ArrayList}
     * @return {@link String} contendo o Json com as informações extraídas do {@link CityResponseDTO}
     */
    private String generateJsonFromDTO(CityResponseDTO cityResponseDTO) {
        Gson gson = new Gson();
        return gson.toJson(cityResponseDTO);
    }
}
