package com.example.weatherproject

import com.example.weatherproject.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

///data/2.5/onecall?lat=33.44&lon=-94.04&exclude=minutely&appid=45dfbf5838de9e226da308b23bf8f3f0
const val API_KEY = "45dfbf5838de9e226da308b23bf8f3f0"
const val EXCLUDE = "minutely"

interface RetrofitService {
    @GET(value = "onecall")
    suspend fun getAllWeathers(
        @Query("lat") lat : Double =35.6,
        @Query("lon") long : Double = 32.11,
        @Query("lang") language : String = "en",
        @Query("units") units : String = "imperial",
        @Query("exclude") exclude : String = EXCLUDE,
        @Query("appid") key:String = API_KEY
    ):Response<WeatherModel>
}