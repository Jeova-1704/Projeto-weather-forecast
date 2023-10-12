package br.com.jelupi.api.apiDtos;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public record WeatherDTO(CityDTO infCidade, String clima, int temperatura, int maxTemp,
                         int minTemp, int sensTerm, int humidade,
                         float velVento, int Visibilidade, ArrayList<JsonElement> prevCincoDias) {
}
