package br.com.jelupi.api.apiDtos.openWeatherDtos;

import java.util.ArrayList;

public record WeatherResponseDTO(CityDTO infCidade, CurrentWeatherDTO infClima,
                                 ArrayList<WeatherListDTO> infClimaDiario) {
}
