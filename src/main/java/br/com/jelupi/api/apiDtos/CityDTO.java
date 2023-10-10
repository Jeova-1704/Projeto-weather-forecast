package br.com.jelupi.api.apiDtos;

import java.math.BigDecimal;

public record CityDTO(String cidade, String id, String pais,
                      float latitude, float longitude) {
}
