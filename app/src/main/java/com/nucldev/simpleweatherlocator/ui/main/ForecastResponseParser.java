package com.nucldev.simpleweatherlocator.ui.main;

import com.nucldev.simpleweatherlocator.components.ForecastFragment;
import com.nucldev.simpleweatherlocator.netinteraction.forecastpojo.ForecastResponse;

public class ForecastResponseParser {
    private ForecastResponse forecastResponse;

    public ForecastResponseParser(ForecastResponse forecastResponse) {
        this.forecastResponse = forecastResponse;
    }

    public void doParse(){
        ForecastFragment.recyclerViewAdapter = new ForecastRecyclerViewAdapter(this.forecastResponse.getList());
        ForecastFragment.sRecyclerView.setAdapter(ForecastFragment.recyclerViewAdapter);
    }
}
