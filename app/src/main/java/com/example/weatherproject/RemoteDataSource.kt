package com.example.weatherproject

import com.example.weatherproject.model.WeatherModel
import retrofit2.Response

interface RemoteDataSource {

    suspend fun getCurrentWeather(lat:Double, long:Double, language:String,
                                  units:String, exclude:String, key:String) : Response<WeatherModel>
}