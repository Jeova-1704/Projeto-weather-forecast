package br.com.jelupi.api.apiAdaptors;

import br.com.jelupi.api.apiDtos.openWeatherDtos.CurrentWeatherDTO;
import br.com.jelupi.api.apiDtos.openWeatherDtos.WeatherResponseDTO;

public interface ApiAdapter {
    WeatherResponseDTO JsonToDTO();
}
