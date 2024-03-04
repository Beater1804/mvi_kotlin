package com.beater.weather_mvi.data.repository

import com.beater.weather_mvi.data.mappers.toWeatherInfo
import com.beater.weather_mvi.data.remote.WeatherApi
import com.beater.weather_mvi.domain.repository.WeatherRepository
import com.beater.weather_mvi.domain.util.Resource
import com.beater.weather_mvi.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}