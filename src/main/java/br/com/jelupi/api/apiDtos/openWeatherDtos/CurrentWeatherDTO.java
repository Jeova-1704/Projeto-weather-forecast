package br.com.jelupi.api.apiDtos.openWeatherDtos;

/**
 * DTO utilizado para armazenar informações do clima de determinado dia da semana<br>
 * <b>OBS:</b> ao contrário do {@link WeatherListDTO} este é utilizado para armazenar mais informações acerca do clima,
 * já que representará o dia atual
 * @param clima {@link String} contendo o clima do local
 * @param temperatura {@link Float} contendo a temperatura atual do local (<b>Kelvin</b>)
 * @param maxTemp {@link Float} contendo a temperatura máxima daquele dia (<b>Kelvin</b>)
 * @param minTemp {@link Float} contendo a temperatura mínima daquele dia (<b>Kelvin</b>)
 * @param sensTerm {@link Float} contendo a sensação térmica atual do local (<b>Kelvin</b>)
 * @param humidade {@link Integer} contendo a porcentagem da humidade atual do local (<b>%</b>)
 * @param velVento {@link Float} contendo a velocidade atual do vento (<b>m/s</b>)
 * @param Visibilidade {@link Integer} contendo a visibilidade do local em (<b>km</b>)
 */
public record CurrentWeatherDTO(String clima, Float temperatura, Float maxTemp,
                                Float minTemp, Float sensTerm, int humidade,
                                float velVento, int Visibilidade) {
}
