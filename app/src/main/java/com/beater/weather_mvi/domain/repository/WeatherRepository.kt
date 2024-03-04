package com.beater.weather_mvi.domain.repository

import com.beater.weather_mvi.domain.util.Resource
import com.beater.weather_mvi.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double) : Resource<WeatherInfo>
}