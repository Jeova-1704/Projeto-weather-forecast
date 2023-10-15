package br.com.jelupi.api.apiAdaptors.nominatinAdapters.dtoGenerators;

import br.com.jelupi.api.apiAdaptors.nominatinAdapters.NominatinAdapter;
import br.com.jelupi.api.apiAdaptors.openWeatherAdapters.OpenWeatherAdapter;
import br.com.jelupi.api.apiDtos.nominatim.CityDTO;
import com.google.gson.JsonObject;

/**
 * Classe auxiliar com métodos utilizados em {@link NominatinAdapter#JsonToDTO} para extrair informações json,
 * retornando-as em DTOs que sintetizam suas informações
 */
public class DtoGenerators {

    /**
     * Sintetiza informações da cidade a partir do {@link JsonObject} fornecido
     * @param jsonObject {@link JsonObject} contendo as informações da cidade
     * @return {@link CityDTO} com as informações da cidade
     */
    public static CityDTO generateCityDTO(JsonObject jsonObject) {
        String cidade = jsonObject.get("name").getAsString();
        Float lat = jsonObject.get("lat").getAsFloat();
        Float lon = jsonObject.get("lon").getAsFloat();
        String displayName = jsonObject.get("display_name").getAsString();

        return new CityDTO(cidade, lat, lon, displayName);
    }
}
