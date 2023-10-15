package br.com.jelupi.api.apiDtos.openWeatherDtos;

public record CurrentWeatherDTO(String clima, int temperatura, int maxTemp,
                                int minTemp, int sensTerm, int humidade,
                                float velVento, int Visibilidade) {
}
