package br.com.jelupi.api.apiConfigs;

public enum OpenWeatherAPI {

    API_KEY("ce24c0f548b6498c469460ff2f8cf943"),

    // 1º Latitude, 2º Longitude e 3º APIKEY
    CITY_WEATHER_UNFORMATED_URL("https://api.openweathermap.org/data/2.5/weather?lat="+"%s"+
            "&lon="+"%s"+"&appid="+"%s"),


    // 1º Cidade, 2º Estado (Nome completo ou abreviação), 3º País (Apenas abreviação)
    GET_CITY_UNFORMATED_URL("https://api.openweathermap.org/geo/1.0/direct?q="
                            +"%s,"+"%s,"+"%s"+"&limit=5&appid=ce24c0f548b6498c469460ff2f8cf943");


    final String value;
    OpenWeatherAPI(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
