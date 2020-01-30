package com.nucldev.simpleweatherlocator.netinteraction;

import com.nucldev.simpleweatherlocator.netinteraction.currentweatherpojo.CurrentWeatherResponse;
import com.nucldev.simpleweatherlocator.netinteraction.forecastpojo.ForecastResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface OpenWeatherApi {
        @GET
        public Call<CurrentWeatherResponse> getWeatherForCoordinates(@Url String url );

        @GET
        public Call<ForecastResponse> getForecastForCoordinates(@Url String url );

}
