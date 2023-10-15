package br.com.jelupi.api.apiDtos.nominatim;

import br.com.jelupi.api.apiDtos.DTO;

import java.util.ArrayList;

/**
 * <i>DTO</i> que armazena um {@link ArrayList} de {@link CityDTO} para armazenar as informações de diferentes cidades
 * @param cityResults {@link ArrayList} com as informações das cidades
 */
public record CityResponseDTO(ArrayList<CityDTO> cityResults) implements DTO {
}
