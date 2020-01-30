package com.nucldev.simpleweatherlocator.netinteraction;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApiService {
    private static WeatherApiService mInstance;
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private Retrofit mRetrofit;

    private WeatherApiService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static WeatherApiService getInstance() {
        if (mInstance == null) {
            mInstance = new WeatherApiService();
        }
        return mInstance;
    }

    public OpenWeatherApi getOpenWeatherApi() {
        return mRetrofit.create(OpenWeatherApi.class);
    }
}
