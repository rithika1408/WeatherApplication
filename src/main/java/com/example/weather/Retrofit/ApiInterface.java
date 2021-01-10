package com.example.weather.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("weather?appid=d5a4f6ba20156440cb50a40e2dc0a848")
    Call<Example> getWeatherData(@Query("q") String name);


}

