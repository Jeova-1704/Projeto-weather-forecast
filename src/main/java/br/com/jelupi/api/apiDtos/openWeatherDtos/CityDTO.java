package br.com.jelupi.api.apiDtos.openWeatherDtos;

import java.math.BigDecimal;

/**
 * DTO contendo as informações da cidade
 * @param cidade {@link String} com o nome da cidade
 * @param id {@link Integer} contendo o ID da cidade no <a href="https://openweathermap.org">OpenWeatherAPI</a>
 * @param pais {@link String} contendo o país onde a cidade está localizada
 * @param latitude {@link Float} com a latitude do local
 * @param longitude {@link Float} com a longitude do local
 */
public record CityDTO(String cidade, String id, String pais,
                      Float latitude, Float longitude) {
}
