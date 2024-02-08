package com.jass.weather.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jass.weather.data.local.entity.WeatherInfoEntity

@Database(
    entities = [WeatherInfoEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class WeatherInfoDatabase : RoomDatabase() {
    abstract val dao: WeatherInfoDao
}