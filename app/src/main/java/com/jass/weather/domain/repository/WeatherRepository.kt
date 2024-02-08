package com.jass.weather.domain.repository

import com.jass.weather.domain.model.City
import com.jass.weather.domain.model.WeatherInfo
import com.jass.weather.utils.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherInfo(latitude: Double, longitude: Double): Flow<Resource<WeatherInfo>>

    fun loadCitiesFromJson(): List<City>
}