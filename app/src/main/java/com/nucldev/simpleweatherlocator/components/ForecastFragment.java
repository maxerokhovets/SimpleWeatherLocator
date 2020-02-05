package com.nucldev.simpleweatherlocator.components;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.nucldev.simpleweatherlocator.R;
import com.nucldev.simpleweatherlocator.netinteraction.forecastpojo.ForecastResponse;
import com.nucldev.simpleweatherlocator.ui.main.ForecastRecyclerViewAdapter;
import com.nucldev.simpleweatherlocator.ui.main.ForecastResponseParser;


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
        Cursor query = Main2Activity.sForecastDatabase.query("str",new String[]{"rString"}, null,null,null,null, null);
        String jsonResponse = "";
        if(query.moveToFirst()){
            jsonResponse = query.getString(0);
            System.out.println(jsonResponse);
            Gson gson = new Gson();
            ForecastResponse fr = gson.fromJson(jsonResponse, ForecastResponse.class);
            new ForecastResponseParser(fr).doParse();
        }
        return view;
    }

}
