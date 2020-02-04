package com.nucldev.simpleweatherlocator.netinteraction;

import android.widget.Toast;
import androidx.annotation.NonNull;
import com.nucldev.simpleweatherlocator.components.CurrentWeatherFragment;
import com.nucldev.simpleweatherlocator.netinteraction.currentweatherpojo.CurrentWeatherResponse;
import com.nucldev.simpleweatherlocator.netinteraction.forecastpojo.ForecastResponse;
import com.nucldev.simpleweatherlocator.ui.main.CurrentWeatherResponseParser;
import com.nucldev.simpleweatherlocator.ui.main.ForecastResponseParser;
import retrofit2.Call;
import retrofit2.Callback;

public class WeatherFromNet {
    private Double mLatitude;
    private Double mLongitude;


    public WeatherFromNet(Double latitude, Double longitude) {
        this.mLatitude = latitude;
        this.mLongitude = longitude;
    }

    public void getWeather(){
        String url = "weather?APPID=53c0da54be235480161da61705a6c37d&lat="+this.mLatitude+"&lon="+this.mLongitude;
        String url1 = "forecast?APPID=53c0da54be235480161da61705a6c37d&lat="+this.mLatitude+"&lon="+this.mLongitude;
        WeatherApiService.getInstance()
                .getOpenWeatherApi()
                .getWeatherForCoordinates(url)
                .enqueue(new Callback<CurrentWeatherResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<CurrentWeatherResponse> call, @NonNull retrofit2.Response<CurrentWeatherResponse> response) {
                        CurrentWeatherResponse response1= response.body();
                        CurrentWeatherResponseParser parser = new CurrentWeatherResponseParser(response1);
                        parser.doParse();
                    }

                    @Override
                    public void onFailure(@NonNull Call<CurrentWeatherResponse> call, @NonNull Throwable t) {
                        Toast.makeText(CurrentWeatherFragment.sContext, "Failed to get data!", Toast.LENGTH_LONG).show();
                    }
                });

        WeatherApiService.getInstance()
                .getOpenWeatherApi()
                .getForecastForCoordinates(url1)
                .enqueue(new Callback<ForecastResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<ForecastResponse> call, @NonNull retrofit2.Response<ForecastResponse> response) {
                        ForecastResponse response1= response.body();
                        ForecastResponseParser parser = new ForecastResponseParser(response1);
                        parser.doParse();
                    }

                    @Override
                    public void onFailure(@NonNull Call<ForecastResponse> call, @NonNull Throwable t) {
//                        Toast.makeText(CurrentWeatherFragment.sContext, "Failed to get data!", Toast.LENGTH_LONG).show();
                    }
                });
    }
}
