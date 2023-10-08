package br.com.jelupi.api.apiDtos;

import java.math.BigDecimal;

public record CityDTO(String nome, String estado, String pais,
                      BigDecimal latitude, BigDecimal longitude) {
}
