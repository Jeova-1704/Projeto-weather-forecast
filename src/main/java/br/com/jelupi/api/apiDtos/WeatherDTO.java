package br.com.jelupi.api.apiDtos;

public record WeatherDTO(String clima, int temperatura, int maxTemp,
                         int minTemp, int sensTerm, int humidade,
                         float velVento, int Visibilidade) {
}
