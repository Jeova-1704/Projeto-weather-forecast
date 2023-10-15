package br.com.jelupi.api.apiAdaptors.nominatinAdapters;

import br.com.jelupi.api.apiAdaptors.ApiAdapter;
import br.com.jelupi.api.apiAdaptors.nominatinAdapters.dtoGenerators.DtoGenerators;
import br.com.jelupi.api.apiDtos.nominatim.CityDTO;
import br.com.jelupi.api.apiDtos.nominatim.CityResponseDTO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;

/**
 * <i>Adapter</i> utilizado para tratar as informações obtidas a partir da requisição à
 * <a href="https://nominatim.org/release-docs/latest/api/Overview/">NomitatinAPI</a>
 */
public class NominatinAdapter implements ApiAdapter {
    private final String jsonCityInf;

    /**
     * Recebe uma {@link String} json com as informações da cidade
     * @param jsonCityInf {@link String} json
     */
    public NominatinAdapter (String jsonCityInf) {
        this.jsonCityInf = jsonCityInf;
    }


    /**
     * Realiza o tratamento do Json com as informações da cidade, sintetizando-as em um {@link CityResponseDTO}
     * @return {@link CityResponseDTO} composto de um {@link ArrayList} de {@link CityDTO} que armazena o nome da cidade,
     * latitude, longitude e displayName
     */
    @Override
    public CityResponseDTO JsonToDTO() {
        JsonArray jsonObject = JsonParser.parseString(this.jsonCityInf).getAsJsonArray();

        ArrayList<CityDTO> cityDTOS = new ArrayList<>();

        for (JsonElement element : jsonObject) {
            cityDTOS.add(DtoGenerators.generateCityDTO(element.getAsJsonObject()));
        }

        return new CityResponseDTO(cityDTOS);
    }

}
