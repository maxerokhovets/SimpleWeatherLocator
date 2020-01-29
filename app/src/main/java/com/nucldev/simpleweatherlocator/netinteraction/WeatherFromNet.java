package com.nucldev.simpleweatherlocator.netinteraction;

import androidx.annotation.NonNull;
import com.nucldev.simpleweatherlocator.MainActivity;
import com.nucldev.simpleweatherlocator.netinteraction.currentweatherpojo.Response;
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
        System.out.println(url);
        NetworkService.getInstance()
                .getOpenWeatherApi()
                .getWeatherForCoordinates(url)
                .enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(@NonNull Call<Response> call, @NonNull retrofit2.Response<Response> response) {
                        Response response1= response.body();
                        MainActivity.sTextView.append(response1.toString());
                    }

                    @Override
                    public void onFailure(@NonNull Call<Response> call, @NonNull Throwable t) {
                        //todo сделать toast
                        MainActivity.sTextView.append("Error occurred while getting request!"+"\n");
                    }
                });
    }
}
