package com.example.probandohttp.services;

import com.example.probandohttp.models.City;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    // weather?q=bogota,CO&APPID=a1a2f550e6a3ad12b1d1a338bac8abe6
    @GET("weather")
    Call<City> getCity(@Query("q") String city, @Query("appid") String key);
}
