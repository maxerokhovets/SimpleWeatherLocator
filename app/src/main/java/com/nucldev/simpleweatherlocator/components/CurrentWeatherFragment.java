package com.nucldev.simpleweatherlocator.components;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.gson.Gson;
import com.nucldev.simpleweatherlocator.R;
import com.nucldev.simpleweatherlocator.netinteraction.currentweatherpojo.CurrentWeatherResponse;
import com.nucldev.simpleweatherlocator.ui.main.CurrentWeatherResponseParser;


public class CurrentWeatherFragment extends Fragment {

    public static TextView sLocationTextView;
    public static TextView sTemperatureTextView;
    public static TextView sWeatherTextView;
    public static TextView sWindTextView;
    public static TextView sPressureTextView;
    public static TextView sHumidityTextView;
    public static ImageView sCurrentWeatherImage;
    public static TextView sWindDirectionTextView;
    public static ImageView sWindImageView;
    public static ImageView sWindDirectionImageView;
    public static ImageView sPressureImageView;
    public static ImageView sHumidityImageView;
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
        sWindImageView = view.findViewById(R.id.windImageView);
        sWindDirectionImageView = view.findViewById(R.id.windDirectionImageView);
        sPressureImageView = view.findViewById(R.id.pressureImageView);
        sHumidityImageView = view.findViewById(R.id.humidityImageView);
        Cursor query = Main2Activity.sCurrentDatabase.query("str",new String[]{"rString"}, null,null,null,null, null);
        String jsonResponse = "";
        if(query.moveToFirst()){
            jsonResponse = query.getString(0);
            System.out.println(jsonResponse);
            Gson gson = new Gson();
            CurrentWeatherResponse cwr = gson.fromJson(jsonResponse, CurrentWeatherResponse.class);
            new CurrentWeatherResponseParser(cwr).doParse();
        }
        return view;
    }

}
