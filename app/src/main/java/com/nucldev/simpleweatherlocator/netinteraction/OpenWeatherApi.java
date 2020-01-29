package com.nucldev.simpleweatherlocator.netinteraction;

import com.nucldev.simpleweatherlocator.netinteraction.currentweatherpojo.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface OpenWeatherApi {
        @GET
        public Call<Response> getWeatherForCoordinates(@Url String url );


}
