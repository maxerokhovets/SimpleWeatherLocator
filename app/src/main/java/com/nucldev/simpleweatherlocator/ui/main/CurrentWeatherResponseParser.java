package com.nucldev.simpleweatherlocator.ui.main;

import com.nucldev.simpleweatherlocator.components.CurrentWeatherFragment;
import com.nucldev.simpleweatherlocator.netinteraction.currentweatherpojo.CurrentWeatherResponse;
import com.nucldev.simpleweatherlocator.netinteraction.currentweatherpojo.WeatherItem;
import com.nucldev.simpleweatherlocator.ui.main.utils.AzimuthToSideOfTheWorldConverter;
import com.nucldev.simpleweatherlocator.ui.main.utils.Rounding;

import java.sql.RowId;
import java.util.List;

public class CurrentWeatherResponseParser {
    private CurrentWeatherResponse mResponse;
    private String mCurrentWeatherMessage;

    public CurrentWeatherResponseParser(CurrentWeatherResponse response) {
        this.mResponse = response;
    }

    public void doParse(){
        CurrentWeatherFragment.sLocationTextView.setText(this.mResponse.getName());
        int temperature = (int) Rounding.mathRounding(this.mResponse.getMain().getTemp()-273.15, 0);
        String sTemperature = Integer.toString(temperature);
        CurrentWeatherFragment.sTemperatureTextView.setText(sTemperature+"℃");
        List<WeatherItem> list = this.mResponse.getWeather();
        CurrentWeatherFragment.sWeatherTextView.setText("Cloudiness: "+this.mResponse.getClouds().getAll()+"%,"+"\n"+list.get(0).getDescription());
        AzimuthToSideOfTheWorldConverter converter = new AzimuthToSideOfTheWorldConverter(this.mResponse.getWind().getDeg());
        CurrentWeatherFragment.sWindTextView.setText("Wind: "+Double.toString(this.mResponse.getWind().getSpeed())+" m/s, "+converter.getSideOfTheWorld());
        Integer press = (int) Rounding.mathRounding(this.mResponse.getMain().getPressure()/1.333, 0);
        CurrentWeatherFragment.sPressureTextView.setText("Pressure: "+press.toString()+" mmHg");
        CurrentWeatherFragment.sHumidityTextView.setText("Humidity: "+this.mResponse.getMain().getHumidity()+"%");
    }

}
