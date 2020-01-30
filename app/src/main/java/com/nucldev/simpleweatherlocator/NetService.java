package com.nucldev.simpleweatherlocator;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.nucldev.simpleweatherlocator.netinteraction.WeatherFromNet;

public class NetService extends Service {
    public NetService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        WeatherFromNet weatherFromNet = new WeatherFromNet(MainActivity.sLatitude, MainActivity.sLongitude);
        weatherFromNet.getWeather();
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }
}
