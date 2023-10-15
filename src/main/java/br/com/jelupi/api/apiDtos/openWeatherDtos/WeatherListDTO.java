package br.com.jelupi.api.apiDtos.openWeatherDtos;

import br.com.jelupi.api.apiDtos.DTO;

import java.util.ArrayList;

/**
 * DTO contendo informações básicas acerca do clima e temperaturas <br>
 * <b>Obs:</b> Pode ser armazenado em {@link ArrayList<WeatherListDTO>} para armazenar informações de previsões de diferentes dias
 * @param clima {@link String} contendo o clima atual do local
 * @param tempMedia {@link Float} contendo a temperatura média daquele dia (<b>Kelvin</b>)
 * @param tempMax {@link Float} contendo a temperatura máxima daquele dia (<b>Kelvin</b>)
 * @param tempMin {@link Float} contendo a temperatura mínima daquele dia (<b>Kelvin</b>)
 */
public record WeatherListDTO(String clima, Float tempMedia, Float tempMax, Float tempMin) implements DTO {
}
