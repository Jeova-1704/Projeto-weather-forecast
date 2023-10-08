package br.com.jelupi.api.apiConfigs;

public enum OpenWeather {
    // 1º Latitude, 2º Longitude e 3º APIKEY
    CITY_WEATHER_UNFORMATED_URL("https://api.openweathermap.org/data/2.5/weather?lat="+"%s"+
            "&lon="+"%s"+"&appid="+"%s"),
    API_KEY("ce24c0f548b6498c469460ff2f8cf943");


    String value;
    OpenWeather(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
