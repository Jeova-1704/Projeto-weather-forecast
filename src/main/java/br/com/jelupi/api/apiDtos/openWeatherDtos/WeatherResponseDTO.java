package br.com.jelupi.api.apiDtos.openWeatherDtos;

import java.util.ArrayList;

/**
 * DTO utilizado para armazenar os DTOs que serão posteriormente convertidos em json e enviados como resposta à
 * requisição do usuário pelo Controller
 * @param infCidade {@link CityDTO} contendo informações da cidade
 * @param infClima {@link CurrentWeatherDTO} contendo informações do clima atual
 * @param infClimaDiario {@link ArrayList<WeatherListDTO>} contendo informações do clima dos próximos 5 dias
 */
public record WeatherResponseDTO(CityDTO infCidade, CurrentWeatherDTO infClima,
                                 ArrayList<WeatherListDTO> infClimaDiario) {
}
