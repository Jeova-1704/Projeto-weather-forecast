package br.com.jelupi.api.apiAdaptors;

import br.com.jelupi.api.apiDtos.WeatherDTO;

public interface ApiAdapter {
    WeatherDTO JsonToDTO();
}
