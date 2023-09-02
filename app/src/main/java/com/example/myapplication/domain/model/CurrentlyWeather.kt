package com.example.myapplication.domain.model

data class CurrentlyWeather (
    /*TODO: Здесь не должно быть города. Потребуется завести список городов в БД, которые добавлены
    *  у пользователя в избранном*/
    /*val city: String,*/
    val temperature:Int,
    val maxT:Int,
    val minT:Int,
    val weatherType: WeatherType
){
    companion object {
        fun getDefault(): CurrentlyWeather {
            return CurrentlyWeather(
                /*city = "Ростов-на-Дону",*/
                temperature = 30,
                maxT = 35,
                minT = 28,
                weatherType = WeatherType.SUNNY
            )
        }
    }
}