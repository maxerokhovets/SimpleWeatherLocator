package com.nucldev.simpleweatherlocator.components;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.nucldev.simpleweatherlocator.R;


public class CurrentWeatherFragment extends Fragment {

    public static TextView sLocationTextView;
    public static TextView sTemperatureTextView;
    public static TextView sWeatherTextView;
    public static TextView sWindTextView;
    public static TextView sPressureTextView;
    public static TextView sHumidityTextView;
    public static ImageView sCurrentWeatherImage;
    public static TextView sWindDirectionTextView;
    public static Context sContext;


    public CurrentWeatherFragment(Context context) {
            this.sContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_weather, container, false);
        sLocationTextView = view.findViewById(R.id.locationTextView);
        sTemperatureTextView = view.findViewById(R.id.forecastTemperatureTextView);
        sWeatherTextView = view.findViewById(R.id.weatherTextView);
        sWindTextView = view.findViewById(R.id.windTextView);
        sPressureTextView = view.findViewById(R.id.pressureTextView);
        sHumidityTextView = view.findViewById(R.id.humidityTextView);
        sCurrentWeatherImage = view.findViewById(R.id.currentWeatherImageView);
        sWindDirectionTextView = view.findViewById(R.id.windDirectionTextView);
        return view;
    }

}
