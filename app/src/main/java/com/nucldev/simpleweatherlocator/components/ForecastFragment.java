package com.nucldev.simpleweatherlocator.components;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nucldev.simpleweatherlocator.R;
import com.nucldev.simpleweatherlocator.ui.main.ForecastRecyclerViewAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends Fragment {
    public static RecyclerView sRecyclerView;
    public static ForecastRecyclerViewAdapter recyclerViewAdapter;
    private Context context;

    public ForecastFragment(Context context) {
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);
        sRecyclerView = view.findViewById(R.id.forecastRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context);
        sRecyclerView.setLayoutManager(linearLayoutManager);
        sRecyclerView.setHasFixedSize(true);

        return view;
    }

}
