package com.jass.weather.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jass.weather.data.local.entity.WeatherInfoEntity
import com.jass.weather.data.remote.dto.Coord

@Dao
interface WeatherInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherInfo(weatherInfo: WeatherInfoEntity)

    @Query("SELECT * FROM WeatherInfoEntity WHERE coordinate = :coord LIMIT 1")
    suspend fun getWeatherInfo(coord: Coord): WeatherInfoEntity?

    @Query("DELETE FROM WeatherInfoEntity WHERE coordinate = :coord")
    suspend fun deleteWeatherInfo(coord: Coord)
}