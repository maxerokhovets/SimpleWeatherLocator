package com.nucldev.simpleweatherlocator.components;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.nucldev.simpleweatherlocator.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends Fragment {
    public static TextView tv;

    public ForecastFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);
        tv = view.findViewById(R.id.forecastTextView);
        return view;
    }

}
