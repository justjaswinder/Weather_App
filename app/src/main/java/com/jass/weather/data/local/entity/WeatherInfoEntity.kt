package com.jass.weather.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jass.weather.data.remote.dto.Coord
import com.jass.weather.data.remote.dto.Main
import com.jass.weather.data.remote.dto.Sys
import com.jass.weather.data.remote.dto.Weather
import com.jass.weather.data.remote.dto.Wind
import com.jass.weather.domain.model.WeatherInfo

@Entity
data class WeatherInfoEntity(
    val coordinate: Coord,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: Int,
    val wind: Wind,
    val sys: Sys,
    val locationName: String,
    @PrimaryKey val id: Long? = null
) {
    fun toWeatherInfo(): WeatherInfo {
        return WeatherInfo(
            latitude = coordinate.lat,
            longitude = coordinate.lon,
            mainData = com.jass.weather.domain.model.Main(
                temp = main.temp,
                feelsLike = main.feels_like,
                tempMin = main.temp_min,
                tempMax = main.temp_max,
                pressure = main.pressure,
                humidity = main.humidity,
                seaLevel = main.sea_level,
                groundLevel = main.grnd_level,
                main = weather[0].main,
                description = weather[0].description
            ),
            windData = com.jass.weather.domain.model.Wind(
                speed = wind.speed,
                deg = wind.deg,
                gust = wind.gust
            ),
            locationName = locationName
        )
    }
}
