package br.com.jelupi.api.apiDtos;

public record WeatherDTO(CityDTO infCidade, String clima, int temperatura, int maxTemp,
                         int minTemp, int sensTerm, int humidade,
                         float velVento, int Visibilidade) {
}
