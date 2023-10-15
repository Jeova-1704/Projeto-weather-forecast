package br.com.jelupi.api.apiAdaptors;

import br.com.jelupi.api.apiDtos.DTO;
import br.com.jelupi.api.apiDtos.openWeatherDtos.CurrentWeatherDTO;
import br.com.jelupi.api.apiDtos.openWeatherDtos.WeatherResponseDTO;

public interface ApiAdapter {
    DTO JsonToDTO();
}
