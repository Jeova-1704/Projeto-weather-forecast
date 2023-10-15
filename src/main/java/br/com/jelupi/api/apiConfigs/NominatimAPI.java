package br.com.jelupi.api.apiConfigs;

public enum NominatimAPI {

    CITY_UNFORMATED_URL("https://nominatim.openstreetmap.org/search?q=%s&format=json&featureType=city&limit=5");

    final String value;
    NominatimAPI(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
