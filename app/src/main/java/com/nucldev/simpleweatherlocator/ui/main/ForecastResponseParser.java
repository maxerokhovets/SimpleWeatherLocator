package com.nucldev.simpleweatherlocator.ui.main;

import com.nucldev.simpleweatherlocator.components.ForecastFragment;
import com.nucldev.simpleweatherlocator.netinteraction.forecastpojo.ForecastResponse;
import com.nucldev.simpleweatherlocator.netinteraction.forecastpojo.ListItem;
import com.nucldev.simpleweatherlocator.ui.main.utils.*;

import java.util.List;

public class ForecastResponseParser {
    private ForecastResponse forecastResponse;

    public ForecastResponseParser(ForecastResponse forecastResponse) {
        this.forecastResponse = forecastResponse;
    }

    public void doParse(){
        List<ListItem> itemList = this.forecastResponse.getList();
        Object[] itemArray = new Object[itemList.size()];
        for (int i=0; i<itemList.size(); i++){
            String[] stringArray = new String[4];
            String descStr = "";
            DateParser parser = new DateParser(this.forecastResponse.getList()
                    .get(i)
                    .getDtTxt());
            descStr += parser.getTime()+"\n";
            FirstLetterToUpperCase fltuc = new FirstLetterToUpperCase(this.forecastResponse.getList()
                    .get(i)
                    .getWeather()
                    .get(0)
                    .getDescription());
            StringDelimiter stringDelimiter = new StringDelimiter(fltuc.toUpperCase()); // перенос на новою строку, если сервер возвращает более двух слов
            descStr += stringDelimiter.divide()+"\n";
            descStr += this.forecastResponse.getList()
                    .get(i)
                    .getWind()
                    .getSpeed()+" m/s, ";
            AzimuthToSideOfTheWorldConverter converter = new AzimuthToSideOfTheWorldConverter(this.forecastResponse.getList()
                    .get(i)
                    .getWind()
                    .getDeg());
            descStr += converter.getSideOfTheWorld();
            stringArray[0]=descStr;
            int temperature = (int) Rounding.mathRounding(this.forecastResponse.getList()
                    .get(i)
                    .getMain()
                    .getTemp()-273.15, 0);
            String tempStr = "";
            tempStr = Integer.toString(temperature)+"℃";
            stringArray[1] = tempStr;
            String date = "";
            date+= parser.getDateAndDayOfWeek();
            stringArray[2] = date;
            String weatherImgFile = "";
            weatherImgFile = "i"+this.forecastResponse
                    .getList()
                    .get(i)
                    .getWeather()
                    .get(0)
                    .getIcon();
            stringArray[3] = weatherImgFile;
            itemArray[i]=stringArray;
        }

        ForecastFragment.recyclerViewAdapter = new ForecastRecyclerViewAdapter(itemArray);
        ForecastFragment.sRecyclerView.setAdapter(ForecastFragment.recyclerViewAdapter);
    }
}
