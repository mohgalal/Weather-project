package com.example.weatherproject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofirHelper {

    const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    fun getInstance() : Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
}
