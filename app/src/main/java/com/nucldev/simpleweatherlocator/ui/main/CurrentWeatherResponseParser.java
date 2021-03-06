package com.nucldev.simpleweatherlocator.ui.main;

import android.graphics.Color;
import com.nucldev.simpleweatherlocator.R;
import com.nucldev.simpleweatherlocator.components.CurrentWeatherFragment;
import com.nucldev.simpleweatherlocator.netinteraction.currentweatherpojo.CurrentWeatherResponse;
import com.nucldev.simpleweatherlocator.netinteraction.currentweatherpojo.WeatherItem;
import com.nucldev.simpleweatherlocator.ui.main.utils.AzimuthToSideOfTheWorldConverter;
import com.nucldev.simpleweatherlocator.ui.main.utils.Rounding;

import java.util.List;

public class CurrentWeatherResponseParser {
    private CurrentWeatherResponse mResponse;
    public static String sCurrentWeatherMessage = "";

    public CurrentWeatherResponseParser(CurrentWeatherResponse response) {
        this.mResponse = response;
    }

    public void doParse(){
        CurrentWeatherFragment.sWindImageView.setImageResource(R.drawable.wind);
        CurrentWeatherFragment.sWindDirectionImageView.setImageResource(R.drawable.wind_direction);
        CurrentWeatherFragment.sPressureImageView.setImageResource(R.drawable.pressure);
        CurrentWeatherFragment.sHumidityImageView.setImageResource(R.drawable.humidity);
        sCurrentWeatherMessage = "Current weather in ";
        CurrentWeatherFragment.sLocationTextView.setText(this.mResponse.getName());
        sCurrentWeatherMessage += this.mResponse.getName()+":\n";
        int temperature = (int) Rounding.mathRounding(this.mResponse.getMain().getTemp()-273.15, 0);
        if(temperature>=20)
            CurrentWeatherFragment.sTemperatureTextView.setTextColor(Color.rgb(243,9,9));
        if(temperature<20 & temperature>=10)
            CurrentWeatherFragment.sTemperatureTextView.setTextColor(Color.rgb(63,177,22));
        if(temperature<10 & temperature>=0)
            CurrentWeatherFragment.sTemperatureTextView.setTextColor(Color.rgb(10,135,240));
        if(temperature<0 & temperature>-10)
            CurrentWeatherFragment.sTemperatureTextView.setTextColor(Color.rgb(13,71,161));
        if(temperature<=-10)
            CurrentWeatherFragment.sTemperatureTextView.setTextColor(Color.BLUE);
        String sTemperature = "";
        sTemperature = Integer.toString(temperature);
        sCurrentWeatherMessage += "Temperature: "+sTemperature+"℃\n";
        CurrentWeatherFragment.sTemperatureTextView.setText(sTemperature+"℃");
        List<WeatherItem> list = this.mResponse.getWeather();
        CurrentWeatherFragment.sWeatherTextView.setText("Cloudiness: "+this.mResponse.getClouds()
                .getAll()+"%,"+"\n"+list.get(0)
                .getDescription());
        AzimuthToSideOfTheWorldConverter converter = new AzimuthToSideOfTheWorldConverter(this.mResponse.getWind().getDeg());
        String sDirection = "";
        CurrentWeatherFragment.sWindDirectionTextView.setText(sDirection+converter.getSideOfTheWorld());
        String sWind = "";
        CurrentWeatherFragment.sWindTextView.setText(sWind+Double.toString(this.mResponse.getWind()
                .getSpeed())+" m/s");
        sCurrentWeatherMessage += "Wind: "+Double.toString(this.mResponse.getWind()
                .getSpeed())+" m/s, "+converter.getSideOfTheWorld()+"\n";
        Integer press = (int) Rounding.mathRounding(this.mResponse.getMain().getPressure()/1.333, 0);
        String sPressure = "";
        CurrentWeatherFragment.sPressureTextView.setText(sPressure+press.toString()+" mmHg");
        sCurrentWeatherMessage += "Pressure: "+press.toString()+" mmHg\n";
        String sHumidity = "";
        CurrentWeatherFragment.sHumidityTextView.setText(sHumidity+this.mResponse.getMain().getHumidity()+"%");
        sCurrentWeatherMessage += "Humidity: "+this.mResponse.getMain().getHumidity()+"%\n";
        sCurrentWeatherMessage += list.get(0).getDescription();
        int imgId = CurrentWeatherFragment.sContext.getResources()
                .getIdentifier("i"+this.mResponse.getWeather()
                        .get(0)
                        .getIcon(),"drawable",CurrentWeatherFragment.sContext.getPackageName());
        CurrentWeatherFragment.sCurrentWeatherImage.setImageResource(imgId);

    }

}
