package br.com.jelupi.api.apiDtos.openWeatherDtos;

import br.com.jelupi.api.apiDtos.DTO;

import java.util.ArrayList;

/**
 * DTO utilizado para armazenar os DTOs que serão posteriormente convertidos em json e enviados como resposta à
 * requisição do usuário pelo Controller
 * @param infCidade {@link WeatherCityDTO} contendo informações da cidade
 * @param infClima {@link CurrentWeatherDTO} contendo informações do clima atual
 * @param infClimaDiario {@link ArrayList<WeatherListDTO>} contendo informações do clima dos próximos 5 dias
 */
public record WeatherResponseDTO(WeatherCityDTO infCidade, CurrentWeatherDTO infClima,
                                 ArrayList<WeatherListDTO> infClimaDiario) implements DTO {
}
