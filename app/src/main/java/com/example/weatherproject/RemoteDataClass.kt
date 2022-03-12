package com.example.weatherproject

import com.example.weatherproject.model.WeatherModel
import retrofit2.Response

class RemoteDataClass(var api:RetrofitService):RemoteDataSource {

    override suspend fun getCurrentWeather(
        lat: Double,
        long: Double,
        language: String,
        units: String,
        exclude: String,
        key: String
    ): Response<WeatherModel> = api.getAllWeathers(lat,long,language,units,exclude,key)
}