package com.example.myapplication.data

import com.example.myapplication.domain.model.CurrentlyWeather
import com.example.myapplication.domain.model.DailyWeather
import com.example.myapplication.domain.model.HourlyWeather
import com.example.myapplication.domain.model.WeatherType
import java.util.Date

object WeatherDataSource {

    fun fetchCurrentWeather(): CurrentlyWeather {
        return CurrentlyWeather(
            /*city = "Ростов-на-Дону",*/
            temperature = 30,
            maxT = 35,
            minT = 28,
            weatherType = WeatherType.SUNNY
        )
    }

    fun getNext24HoursWeather(): List<HourlyWeather> {
        return listOf(
            HourlyWeather(
                WeatherType.SUNNY,
                6,
                21,
                16
            ),
            HourlyWeather(
                WeatherType.CLOUDY,
                7,
                21,
                19
            ),
            HourlyWeather(
                WeatherType.SUNNY,
                8,
                20,
                21
            ),
            HourlyWeather(
                WeatherType.CLOUDY,
                9,
                20,
                24
            ),
            HourlyWeather(
                WeatherType.RAINY,
                10,
                21,
                25
            ),
            HourlyWeather(
                WeatherType.RAINY,
                11,
                21,
                28
            ),
            HourlyWeather(
                WeatherType.SUNNY,
                12,
                19,
                30
            ),
            HourlyWeather(
                WeatherType.SUNNY,
                13,
                16,
                31
            ),
            HourlyWeather(
                WeatherType.SUNNY,
                14,
                16,
                30
            ),
            HourlyWeather(
                WeatherType.STORMY,
                15,
                16,
                30
            ),
            HourlyWeather(
                WeatherType.STORMY,
                16,
                17,
                32
            ),
            HourlyWeather(
                WeatherType.STORMY,
                17,
                19,
                29
            ),
            HourlyWeather(
                WeatherType.CLOUDY,
                18,
                19,
                27
            ),
            HourlyWeather(
                WeatherType.CLOUDY,
                19,
                20,
                24
            ),
            HourlyWeather(
                WeatherType.CLOUDY,
                20,
                21,
                23
            ),
            HourlyWeather(
                WeatherType.CLOUDY,
                21,
                21,
                20
            ),
            HourlyWeather(
                WeatherType.CLOUDY,
                22,
                22,
                19
            ),
            HourlyWeather(
                WeatherType.CLOUDY,
                23,
                19,
                20
            ),
            HourlyWeather(
                WeatherType.CLOUDY,
                0,
                19,
                18
            ),
            HourlyWeather(
                WeatherType.CLOUDY,
                1,
                21,
                16
            ),
            HourlyWeather(
                WeatherType.CLOUDY,
                2,
                20,
                16
            ),
            HourlyWeather(
                WeatherType.CLOUDY,
                3,
                24,
                14
            ),
            HourlyWeather(
                WeatherType.CLOUDY,
                4,
                28,
                13
            ),
            HourlyWeather(
                WeatherType.CLOUDY,
                5,
                23,
                14
            )
        )
    }


    fun getNext7dayWeather(): List<DailyWeather> {
        return listOf(
            DailyWeather(
                weatherType = WeatherType.SUNNY,
                weekDay = "Сегодня",
                date = "Авг 26",
                maxTemp = 32,
                minTemp = 18
            ),
            DailyWeather(
                weatherType = WeatherType.CLOUDY,
                weekDay = "Вс",
                date = "Авг 27",
                maxTemp = 26,
                minTemp = 16
            ),
            DailyWeather(
                weatherType = WeatherType.RAINY,
                weekDay = "Пн",
                date = "Авг 28",
                maxTemp = 24,
                minTemp = 13
            ),
            DailyWeather(
                weatherType = WeatherType.SUNNY,
                weekDay = "Вт",
                date = "Авг 29",
                maxTemp = 30,
                minTemp = 16
            ),
            DailyWeather(
                weatherType = WeatherType.SUNNY,
                weekDay = "Ср",
                date = "Авг 30",
                maxTemp = 30,
                minTemp = 15
            ),
            DailyWeather(
                weatherType = WeatherType.CLOUDY,
                weekDay = "Чт",
                date = "Авг 31",
                maxTemp = 27,
                minTemp = 17
            ),
            DailyWeather(
                weatherType = WeatherType.STORMY,
                weekDay = "Пт",
                date = "Сен 1",
                maxTemp = 22,
                minTemp = 13
            ),
        )
    }
}