package br.com.jelupi.api.apiDtos.nominatim;

import br.com.jelupi.api.apiDtos.DTO;

/**
 * <i>DTO</i> que armazena as informações de determinada cidade
 * <b>OBS:</b> os dados podem ser armazenados em um {@link java.util.ArrayList} e guardados em um {@link CityResponseDTO}
 * para guardar as informações de diferentes cidades
 * @param cidade {@link String} com o nome da cidade
 * @param lat {@link Float} com a latitude
 * @param lon {@link Float} com a longitude
 * @param displayName {@link String} com a localização detalhada da cidade (cidade, micro-região, estado, país, etc...)
 */
public record CityDTO(String cidade, Float lat, Float lon, String displayName) implements DTO {
}
