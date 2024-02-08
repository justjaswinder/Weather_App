package com.jass.weather.data.remote

import com.jass.weather.data.remote.dto.WeatherInfoDto
import com.jass.weather.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getWeatherByCoordinate(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appId") apiKey: String = Constants.API_KEY
    ): WeatherInfoDto

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/"
    }
}