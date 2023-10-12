package br.com.jelupi.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String json = """
                {
                    "cod": "200",
                    "message": 0,
                    "cnt": 40,
                    "list": [
                        {
                            "dt": 1697144400,
                            "main": {
                                "temp": 299.56,
                                "feels_like": 299.56,
                                "temp_min": 299.49,
                                "temp_max": 299.56,
                                "pressure": 1013,
                                "sea_level": 1013,
                                "grnd_level": 1014,
                                "humidity": 79,
                                "temp_kf": 0.07
                            },
                            "weather": [
                                {
                                    "id": 500,
                                    "main": "Rain",
                                    "description": "light rain",
                                    "icon": "10n"
                                }
                            ],
                            "clouds": {
                                "all": 4
                            },
                            "wind": {
                                "speed": 7.16,
                                "deg": 124,
                                "gust": 8.11
                            },
                            "visibility": 10000,
                            "pop": 0.36,
                            "rain": {
                                "3h": 0.38
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-12 21:00:00"
                        },
                        {
                            "dt": 1697155200,
                            "main": {
                                "temp": 299.41,
                                "feels_like": 299.41,
                                "temp_min": 299.32,
                                "temp_max": 299.41,
                                "pressure": 1014,
                                "sea_level": 1014,
                                "grnd_level": 1015,
                                "humidity": 80,
                                "temp_kf": 0.09
                            },
                            "weather": [
                                {
                                    "id": 500,
                                    "main": "Rain",
                                    "description": "light rain",
                                    "icon": "10n"
                                }
                            ],
                            "clouds": {
                                "all": 6
                            },
                            "wind": {
                                "speed": 8.33,
                                "deg": 115,
                                "gust": 9.13
                            },
                            "visibility": 10000,
                            "pop": 0.28,
                            "rain": {
                                "3h": 0.13
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-13 00:00:00"
                        },
                        {
                            "dt": 1697166000,
                            "main": {
                                "temp": 299.23,
                                "feels_like": 299.23,
                                "temp_min": 299.23,
                                "temp_max": 299.23,
                                "pressure": 1013,
                                "sea_level": 1013,
                                "grnd_level": 1013,
                                "humidity": 80,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 3
                            },
                            "wind": {
                                "speed": 8.76,
                                "deg": 110,
                                "gust": 9.61
                            },
                            "visibility": 10000,
                            "pop": 0,
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-13 03:00:00"
                        },
                        {
                            "dt": 1697176800,
                            "main": {
                                "temp": 299.22,
                                "feels_like": 299.22,
                                "temp_min": 299.22,
                                "temp_max": 299.22,
                                "pressure": 1013,
                                "sea_level": 1013,
                                "grnd_level": 1013,
                                "humidity": 79,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 7
                            },
                            "wind": {
                                "speed": 8.57,
                                "deg": 101,
                                "gust": 9.31
                            },
                            "visibility": 10000,
                            "pop": 0,
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-13 06:00:00"
                        },
                        {
                            "dt": 1697187600,
                            "main": {
                                "temp": 299.43,
                                "feels_like": 299.43,
                                "temp_min": 299.43,
                                "temp_max": 299.43,
                                "pressure": 1014,
                                "sea_level": 1014,
                                "grnd_level": 1014,
                                "humidity": 76,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 802,
                                    "main": "Clouds",
                                    "description": "scattered clouds",
                                    "icon": "03d"
                                }
                            ],
                            "clouds": {
                                "all": 48
                            },
                            "wind": {
                                "speed": 8.76,
                                "deg": 101,
                                "gust": 9.23
                            },
                            "visibility": 10000,
                            "pop": 0,
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-13 09:00:00"
                        },
                        {
                            "dt": 1697198400,
                            "main": {
                                "temp": 299.5,
                                "feels_like": 299.5,
                                "temp_min": 299.5,
                                "temp_max": 299.5,
                                "pressure": 1016,
                                "sea_level": 1016,
                                "grnd_level": 1016,
                                "humidity": 79,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 500,
                                    "main": "Rain",
                                    "description": "light rain",
                                    "icon": "10d"
                                }
                            ],
                            "clouds": {
                                "all": 74
                            },
                            "wind": {
                                "speed": 7.87,
                                "deg": 101,
                                "gust": 8.22
                            },
                            "visibility": 10000,
                            "pop": 0.2,
                            "rain": {
                                "3h": 0.13
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-13 12:00:00"
                        },
                        {
                            "dt": 1697209200,
                            "main": {
                                "temp": 299.54,
                                "feels_like": 299.54,
                                "temp_min": 299.54,
                                "temp_max": 299.54,
                                "pressure": 1014,
                                "sea_level": 1014,
                                "grnd_level": 1014,
                                "humidity": 78,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 803,
                                    "main": "Clouds",
                                    "description": "broken clouds",
                                    "icon": "04d"
                                }
                            ],
                            "clouds": {
                                "all": 60
                            },
                            "wind": {
                                "speed": 7.34,
                                "deg": 103,
                                "gust": 7.6
                            },
                            "visibility": 10000,
                            "pop": 0.08,
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-13 15:00:00"
                        },
                        {
                            "dt": 1697220000,
                            "main": {
                                "temp": 299.58,
                                "feels_like": 299.58,
                                "temp_min": 299.58,
                                "temp_max": 299.58,
                                "pressure": 1014,
                                "sea_level": 1014,
                                "grnd_level": 1014,
                                "humidity": 76,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 802,
                                    "main": "Clouds",
                                    "description": "scattered clouds",
                                    "icon": "03d"
                                }
                            ],
                            "clouds": {
                                "all": 34
                            },
                            "wind": {
                                "speed": 6.43,
                                "deg": 107,
                                "gust": 6.82
                            },
                            "visibility": 10000,
                            "pop": 0,
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-13 18:00:00"
                        },
                        {
                            "dt": 1697230800,
                            "main": {
                                "temp": 299.53,
                                "feels_like": 299.53,
                                "temp_min": 299.53,
                                "temp_max": 299.53,
                                "pressure": 1015,
                                "sea_level": 1015,
                                "grnd_level": 1015,
                                "humidity": 78,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 500,
                                    "main": "Rain",
                                    "description": "light rain",
                                    "icon": "10n"
                                }
                            ],
                            "clouds": {
                                "all": 23
                            },
                            "wind": {
                                "speed": 6.39,
                                "deg": 105,
                                "gust": 7
                            },
                            "visibility": 10000,
                            "pop": 0.24,
                            "rain": {
                                "3h": 0.13
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-13 21:00:00"
                        },
                        {
                            "dt": 1697241600,
                            "main": {
                                "temp": 299.41,
                                "feels_like": 299.41,
                                "temp_min": 299.41,
                                "temp_max": 299.41,
                                "pressure": 1016,
                                "sea_level": 1016,
                                "grnd_level": 1016,
                                "humidity": 79,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 500,
                                    "main": "Rain",
                                    "description": "light rain",
                                    "icon": "10n"
                                }
                            ],
                            "clouds": {
                                "all": 14
                            },
                            "wind": {
                                "speed": 9.32,
                                "deg": 96,
                                "gust": 9.62
                            },
                            "visibility": 10000,
                            "pop": 0.28,
                            "rain": {
                                "3h": 0.19
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-14 00:00:00"
                        },
                        {
                            "dt": 1697252400,
                            "main": {
                                "temp": 299.2,
                                "feels_like": 299.2,
                                "temp_min": 299.2,
                                "temp_max": 299.2,
                                "pressure": 1014,
                                "sea_level": 1014,
                                "grnd_level": 1014,
                                "humidity": 77,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 5
                            },
                            "wind": {
                                "speed": 8.93,
                                "deg": 98,
                                "gust": 9.51
                            },
                            "visibility": 10000,
                            "pop": 0,
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-14 03:00:00"
                        },
                        {
                            "dt": 1697263200,
                            "main": {
                                "temp": 299.16,
                                "feels_like": 299.16,
                                "temp_min": 299.16,
                                "temp_max": 299.16,
                                "pressure": 1013,
                                "sea_level": 1013,
                                "grnd_level": 1013,
                                "humidity": 75,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 7
                            },
                            "wind": {
                                "speed": 9.13,
                                "deg": 96,
                                "gust": 10
                            },
                            "visibility": 10000,
                            "pop": 0,
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-14 06:00:00"
                        },
                        {
                            "dt": 1697274000,
                            "main": {
                                "temp": 299.7,
                                "feels_like": 299.7,
                                "temp_min": 299.7,
                                "temp_max": 299.7,
                                "pressure": 1015,
                                "sea_level": 1015,
                                "grnd_level": 1015,
                                "humidity": 71,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 802,
                                    "main": "Clouds",
                                    "description": "scattered clouds",
                                    "icon": "03d"
                                }
                            ],
                            "clouds": {
                                "all": 47
                            },
                            "wind": {
                                "speed": 7.75,
                                "deg": 99,
                                "gust": 8.7
                            },
                            "visibility": 10000,
                            "pop": 0,
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-14 09:00:00"
                        },
                        {
                            "dt": 1697284800,
                            "main": {
                                "temp": 299.72,
                                "feels_like": 299.72,
                                "temp_min": 299.72,
                                "temp_max": 299.72,
                                "pressure": 1017,
                                "sea_level": 1017,
                                "grnd_level": 1017,
                                "humidity": 74,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 803,
                                    "main": "Clouds",
                                    "description": "broken clouds",
                                    "icon": "04d"
                                }
                            ],
                            "clouds": {
                                "all": 73
                            },
                            "wind": {
                                "speed": 7.29,
                                "deg": 106,
                                "gust": 7.73
                            },
                            "visibility": 10000,
                            "pop": 0,
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-14 12:00:00"
                        },
                        {
                            "dt": 1697295600,
                            "main": {
                                "temp": 300,
                                "feels_like": 301.76,
                                "temp_min": 300,
                                "temp_max": 300,
                                "pressure": 1015,
                                "sea_level": 1015,
                                "grnd_level": 1015,
                                "humidity": 70,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 802,
                                    "main": "Clouds",
                                    "description": "scattered clouds",
                                    "icon": "03d"
                                }
                            ],
                            "clouds": {
                                "all": 35
                            },
                            "wind": {
                                "speed": 5.79,
                                "deg": 111,
                                "gust": 7.72
                            },
                            "visibility": 10000,
                            "pop": 0,
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-14 15:00:00"
                        },
                        {
                            "dt": 1697306400,
                            "main": {
                                "temp": 299.86,
                                "feels_like": 301.88,
                                "temp_min": 299.86,
                                "temp_max": 299.86,
                                "pressure": 1014,
                                "sea_level": 1014,
                                "grnd_level": 1014,
                                "humidity": 75,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 803,
                                    "main": "Clouds",
                                    "description": "broken clouds",
                                    "icon": "04d"
                                }
                            ],
                            "clouds": {
                                "all": 52
                            },
                            "wind": {
                                "speed": 7.32,
                                "deg": 108,
                                "gust": 7.71
                            },
                            "visibility": 10000,
                            "pop": 0,
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-14 18:00:00"
                        },
                        {
                            "dt": 1697317200,
                            "main": {
                                "temp": 299.64,
                                "feels_like": 299.64,
                                "temp_min": 299.64,
                                "temp_max": 299.64,
                                "pressure": 1015,
                                "sea_level": 1015,
                                "grnd_level": 1015,
                                "humidity": 73,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 803,
                                    "main": "Clouds",
                                    "description": "broken clouds",
                                    "icon": "04n"
                                }
                            ],
                            "clouds": {
                                "all": 63
                            },
                            "wind": {
                                "speed": 6.71,
                                "deg": 117,
                                "gust": 8.11
                            },
                            "visibility": 10000,
                            "pop": 0,
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-14 21:00:00"
                        },
                        {
                            "dt": 1697328000,
                            "main": {
                                "temp": 299.7,
                                "feels_like": 299.7,
                                "temp_min": 299.7,
                                "temp_max": 299.7,
                                "pressure": 1017,
                                "sea_level": 1017,
                                "grnd_level": 1017,
                                "humidity": 74,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 500,
                                    "main": "Rain",
                                    "description": "light rain",
                                    "icon": "10n"
                                }
                            ],
                            "clouds": {
                                "all": 69
                            },
                            "wind": {
                                "speed": 7.56,
                                "deg": 111,
                                "gust": 8.42
                            },
                            "visibility": 10000,
                            "pop": 0.2,
                            "rain": {
                                "3h": 0.13
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-15 00:00:00"
                        },
                        {
                            "dt": 1697338800,
                            "main": {
                                "temp": 299.35,
                                "feels_like": 299.35,
                                "temp_min": 299.35,
                                "temp_max": 299.35,
                                "pressure": 1015,
                                "sea_level": 1015,
                                "grnd_level": 1015,
                                "humidity": 71,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 500,
                                    "main": "Rain",
                                    "description": "light rain",
                                    "icon": "10n"
                                }
                            ],
                            "clouds": {
                                "all": 100
                            },
                            "wind": {
                                "speed": 8.03,
                                "deg": 114,
                                "gust": 8.4
                            },
                            "visibility": 10000,
                            "pop": 0.2,
                            "rain": {
                                "3h": 0.13
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-15 03:00:00"
                        },
                        {
                            "dt": 1697349600,
                            "main": {
                                "temp": 299.58,
                                "feels_like": 299.58,
                                "temp_min": 299.58,
                                "temp_max": 299.58,
                                "pressure": 1015,
                                "sea_level": 1015,
                                "grnd_level": 1015,
                                "humidity": 67,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 500,
                                    "main": "Rain",
                                    "description": "light rain",
                                    "icon": "10n"
                                }
                            ],
                            "clouds": {
                                "all": 100
                            },
                            "wind": {
                                "speed": 7.22,
                                "deg": 117,
                                "gust": 8.31
                            },
                            "visibility": 10000,
                            "pop": 0.2,
                            "rain": {
                                "3h": 0.13
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-15 06:00:00"
                        },
                        {
                            "dt": 1697360400,
                            "main": {
                                "temp": 299.95,
                                "feels_like": 301.67,
                                "temp_min": 299.95,
                                "temp_max": 299.95,
                                "pressure": 1016,
                                "sea_level": 1016,
                                "grnd_level": 1016,
                                "humidity": 70,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 804,
                                    "main": "Clouds",
                                    "description": "overcast clouds",
                                    "icon": "04d"
                                }
                            ],
                            "clouds": {
                                "all": 100
                            },
                            "wind": {
                                "speed": 7.61,
                                "deg": 122,
                                "gust": 8.8
                            },
                            "visibility": 10000,
                            "pop": 0.12,
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-15 09:00:00"
                        },
                        {
                            "dt": 1697371200,
                            "main": {
                                "temp": 299.7,
                                "feels_like": 299.7,
                                "temp_min": 299.7,
                                "temp_max": 299.7,
                                "pressure": 1017,
                                "sea_level": 1017,
                                "grnd_level": 1017,
                                "humidity": 72,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 804,
                                    "main": "Clouds",
                                    "description": "overcast clouds",
                                    "icon": "04d"
                                }
                            ],
                            "clouds": {
                                "all": 98
                            },
                            "wind": {
                                "speed": 7.61,
                                "deg": 120,
                                "gust": 8.6
                            },
                            "visibility": 10000,
                            "pop": 0.04,
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-15 12:00:00"
                        },
                        {
                            "dt": 1697382000,
                            "main": {
                                "temp": 299.28,
                                "feels_like": 299.28,
                                "temp_min": 299.28,
                                "temp_max": 299.28,
                                "pressure": 1016,
                                "sea_level": 1016,
                                "grnd_level": 1016,
                                "humidity": 74,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 500,
                                    "main": "Rain",
                                    "description": "light rain",
                                    "icon": "10d"
                                }
                            ],
                            "clouds": {
                                "all": 54
                            },
                            "wind": {
                                "speed": 9.35,
                                "deg": 131,
                                "gust": 9.41
                            },
                            "visibility": 10000,
                            "pop": 0.4,
                            "rain": {
                                "3h": 0.19
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-15 15:00:00"
                        },
                        {
                            "dt": 1697392800,
                            "main": {
                                "temp": 299.42,
                                "feels_like": 299.42,
                                "temp_min": 299.42,
                                "temp_max": 299.42,
                                "pressure": 1014,
                                "sea_level": 1014,
                                "grnd_level": 1014,
                                "humidity": 69,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 802,
                                    "main": "Clouds",
                                    "description": "scattered clouds",
                                    "icon": "03d"
                                }
                            ],
                            "clouds": {
                                "all": 45
                            },
                            "wind": {
                                "speed": 7.9,
                                "deg": 130,
                                "gust": 8.2
                            },
                            "visibility": 10000,
                            "pop": 0.04,
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-15 18:00:00"
                        },
                        {
                            "dt": 1697403600,
                            "main": {
                                "temp": 298.99,
                                "feels_like": 299.59,
                                "temp_min": 298.99,
                                "temp_max": 298.99,
                                "pressure": 1015,
                                "sea_level": 1015,
                                "grnd_level": 1015,
                                "humidity": 75,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 7
                            },
                            "wind": {
                                "speed": 8.55,
                                "deg": 135,
                                "gust": 8.9
                            },
                            "visibility": 10000,
                            "pop": 0.12,
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-15 21:00:00"
                        },
                        {
                            "dt": 1697414400,
                            "main": {
                                "temp": 299.12,
                                "feels_like": 299.12,
                                "temp_min": 299.12,
                                "temp_max": 299.12,
                                "pressure": 1016,
                                "sea_level": 1016,
                                "grnd_level": 1016,
                                "humidity": 72,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 500,
                                    "main": "Rain",
                                    "description": "light rain",
                                    "icon": "10n"
                                }
                            ],
                            "clouds": {
                                "all": 32
                            },
                            "wind": {
                                "speed": 8.92,
                                "deg": 130,
                                "gust": 9
                            },
                            "visibility": 10000,
                            "pop": 0.2,
                            "rain": {
                                "3h": 0.19
                            },
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-16 00:00:00"
                        },
                        {
                            "dt": 1697425200,
                            "main": {
                                "temp": 299,
                                "feels_like": 299.47,
                                "temp_min": 299,
                                "temp_max": 299,
                                "pressure": 1014,
                                "sea_level": 1014,
                                "grnd_level": 1014,
                                "humidity": 70,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 802,
                                    "main": "Clouds",
                                    "description": "scattered clouds",
                                    "icon": "03n"
                                }
                            ],
                            "clouds": {
                                "all": 33
                            },
                            "wind": {
                                "speed": 7.3,
                                "deg": 132,
                                "gust": 8.2
                            },
                            "visibility": 10000,
                            "pop": 0.04,
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-16 03:00:00"
                        },
                        {
                            "dt": 1697436000,
                            "main": {
                                "temp": 299.12,
                                "feels_like": 299.12,
                                "temp_min": 299.12,
                                "temp_max": 299.12,
                                "pressure": 1014,
                                "sea_level": 1014,
                                "grnd_level": 1014,
                                "humidity": 67,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 801,
                                    "main": "Clouds",
                                    "description": "few clouds",
                                    "icon": "02n"
                                }
                            ],
                            "clouds": {
                                "all": 19
                            },
                            "wind": {
                                "speed": 7.28,
                                "deg": 132,
                                "gust": 7.72
                            },
                            "visibility": 10000,
                            "pop": 0.12,
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-16 06:00:00"
                        },
                        {
                            "dt": 1697446800,
                            "main": {
                                "temp": 298.55,
                                "feels_like": 299.16,
                                "temp_min": 298.55,
                                "temp_max": 298.55,
                                "pressure": 1014,
                                "sea_level": 1014,
                                "grnd_level": 1014,
                                "humidity": 77,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 500,
                                    "main": "Rain",
                                    "description": "light rain",
                                    "icon": "10d"
                                }
                            ],
                            "clouds": {
                                "all": 5
                            },
                            "wind": {
                                "speed": 7.42,
                                "deg": 127,
                                "gust": 8.11
                            },
                            "visibility": 10000,
                            "pop": 0.32,
                            "rain": {
                                "3h": 0.38
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-16 09:00:00"
                        },
                        {
                            "dt": 1697457600,
                            "main": {
                                "temp": 299.3,
                                "feels_like": 299.3,
                                "temp_min": 299.3,
                                "temp_max": 299.3,
                                "pressure": 1015,
                                "sea_level": 1015,
                                "grnd_level": 1015,
                                "humidity": 70,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 500,
                                    "main": "Rain",
                                    "description": "light rain",
                                    "icon": "10d"
                                }
                            ],
                            "clouds": {
                                "all": 22
                            },
                            "wind": {
                                "speed": 8.27,
                                "deg": 121,
                                "gust": 8.9
                            },
                            "visibility": 10000,
                            "pop": 0.4,
                            "rain": {
                                "3h": 0.56
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-16 12:00:00"
                        },
                        {
                            "dt": 1697468400,
                            "main": {
                                "temp": 299.4,
                                "feels_like": 299.4,
                                "temp_min": 299.4,
                                "temp_max": 299.4,
                                "pressure": 1013,
                                "sea_level": 1013,
                                "grnd_level": 1013,
                                "humidity": 65,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01d"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 8.08,
                                "deg": 130,
                                "gust": 8.14
                            },
                            "visibility": 10000,
                            "pop": 0.04,
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-16 15:00:00"
                        },
                        {
                            "dt": 1697479200,
                            "main": {
                                "temp": 299.18,
                                "feels_like": 299.18,
                                "temp_min": 299.18,
                                "temp_max": 299.18,
                                "pressure": 1012,
                                "sea_level": 1012,
                                "grnd_level": 1012,
                                "humidity": 70,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01d"
                                }
                            ],
                            "clouds": {
                                "all": 2
                            },
                            "wind": {
                                "speed": 8.02,
                                "deg": 135,
                                "gust": 8.2
                            },
                            "visibility": 10000,
                            "pop": 0,
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-16 18:00:00"
                        },
                        {
                            "dt": 1697490000,
                            "main": {
                                "temp": 299.14,
                                "feels_like": 299.14,
                                "temp_min": 299.14,
                                "temp_max": 299.14,
                                "pressure": 1013,
                                "sea_level": 1013,
                                "grnd_level": 1013,
                                "humidity": 70,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 1
                            },
                            "wind": {
                                "speed": 7.82,
                                "deg": 134,
                                "gust": 8.13
                            },
                            "visibility": 10000,
                            "pop": 0,
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-16 21:00:00"
                        },
                        {
                            "dt": 1697500800,
                            "main": {
                                "temp": 299.04,
                                "feels_like": 299.46,
                                "temp_min": 299.04,
                                "temp_max": 299.04,
                                "pressure": 1014,
                                "sea_level": 1014,
                                "grnd_level": 1014,
                                "humidity": 68,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 7.44,
                                "deg": 129,
                                "gust": 7.71
                            },
                            "visibility": 10000,
                            "pop": 0,
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-17 00:00:00"
                        },
                        {
                            "dt": 1697511600,
                            "main": {
                                "temp": 298.68,
                                "feels_like": 299.06,
                                "temp_min": 298.68,
                                "temp_max": 298.68,
                                "pressure": 1012,
                                "sea_level": 1012,
                                "grnd_level": 1012,
                                "humidity": 68,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 7.42,
                                "deg": 124,
                                "gust": 7.71
                            },
                            "visibility": 10000,
                            "pop": 0,
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-17 03:00:00"
                        },
                        {
                            "dt": 1697522400,
                            "main": {
                                "temp": 298.5,
                                "feels_like": 299,
                                "temp_min": 298.5,
                                "temp_max": 298.5,
                                "pressure": 1011,
                                "sea_level": 1011,
                                "grnd_level": 1011,
                                "humidity": 73,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 800,
                                    "main": "Clear",
                                    "description": "clear sky",
                                    "icon": "01n"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 6.71,
                                "deg": 120,
                                "gust": 7.21
                            },
                            "visibility": 10000,
                            "pop": 0,
                            "sys": {
                                "pod": "n"
                            },
                            "dt_txt": "2023-10-17 06:00:00"
                        },
                        {
                            "dt": 1697533200,
                            "main": {
                                "temp": 298.64,
                                "feels_like": 299.18,
                                "temp_min": 298.64,
                                "temp_max": 298.64,
                                "pressure": 1013,
                                "sea_level": 1013,
                                "grnd_level": 1013,
                                "humidity": 74,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 500,
                                    "main": "Rain",
                                    "description": "light rain",
                                    "icon": "10d"
                                }
                            ],
                            "clouds": {
                                "all": 0
                            },
                            "wind": {
                                "speed": 6.95,
                                "deg": 118,
                                "gust": 7.3
                            },
                            "visibility": 10000,
                            "pop": 0.24,
                            "rain": {
                                "3h": 0.13
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-17 09:00:00"
                        },
                        {
                            "dt": 1697544000,
                            "main": {
                                "temp": 298.79,
                                "feels_like": 299.37,
                                "temp_min": 298.79,
                                "temp_max": 298.79,
                                "pressure": 1014,
                                "sea_level": 1014,
                                "grnd_level": 1014,
                                "humidity": 75,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 500,
                                    "main": "Rain",
                                    "description": "light rain",
                                    "icon": "10d"
                                }
                            ],
                            "clouds": {
                                "all": 26
                            },
                            "wind": {
                                "speed": 7.15,
                                "deg": 126,
                                "gust": 7.51
                            },
                            "visibility": 10000,
                            "pop": 0.36,
                            "rain": {
                                "3h": 0.44
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-17 12:00:00"
                        },
                        {
                            "dt": 1697554800,
                            "main": {
                                "temp": 298.91,
                                "feels_like": 299.47,
                                "temp_min": 298.91,
                                "temp_max": 298.91,
                                "pressure": 1012,
                                "sea_level": 1012,
                                "grnd_level": 1012,
                                "humidity": 74,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 500,
                                    "main": "Rain",
                                    "description": "light rain",
                                    "icon": "10d"
                                }
                            ],
                            "clouds": {
                                "all": 58
                            },
                            "wind": {
                                "speed": 7.03,
                                "deg": 121,
                                "gust": 7.01
                            },
                            "visibility": 10000,
                            "pop": 0.32,
                            "rain": {
                                "3h": 0.56
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-17 15:00:00"
                        },
                        {
                            "dt": 1697565600,
                            "main": {
                                "temp": 299.2,
                                "feels_like": 299.2,
                                "temp_min": 299.2,
                                "temp_max": 299.2,
                                "pressure": 1011,
                                "sea_level": 1011,
                                "grnd_level": 1011,
                                "humidity": 70,
                                "temp_kf": 0
                            },
                            "weather": [
                                {
                                    "id": 500,
                                    "main": "Rain",
                                    "description": "light rain",
                                    "icon": "10d"
                                }
                            ],
                            "clouds": {
                                "all": 38
                            },
                            "wind": {
                                "speed": 7.59,
                                "deg": 126,
                                "gust": 8.02
                            },
                            "visibility": 10000,
                            "pop": 0.52,
                            "rain": {
                                "3h": 0.13
                            },
                            "sys": {
                                "pod": "d"
                            },
                            "dt_txt": "2023-10-17 18:00:00"
                        }
                    ],
                    "city": {
                        "id": 3404558,
                        "name": "Cabedelo",
                        "coord": {
                            "lat": -7,
                            "lon": -34
                        },
                        "country": "BR",
                        "population": 54839,
                        "timezone": -7200,
                        "sunrise": 1697097325,
                        "sunset": 1697141363
                    }
                }
                        """;

        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        //HashMap<String, ArrayList>
    }
}