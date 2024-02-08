package com.jass.weather.di

import android.content.Context
import com.jass.weather.data.local.WeatherInfoDatabase
import com.jass.weather.data.remote.WeatherApi
import com.jass.weather.data.repository.WeatherRepositoryImpl
import com.jass.weather.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun bindWeatherRepository(
        context: Context,
        db: WeatherInfoDatabase,
        api: WeatherApi
    ): WeatherRepository {
        return WeatherRepositoryImpl(context, api, db.dao)
    }
}