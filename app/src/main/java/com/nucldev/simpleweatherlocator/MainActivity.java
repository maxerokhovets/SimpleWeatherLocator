package com.nucldev.simpleweatherlocator;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Intent intent = new Intent(this, Main2Activity.class);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        };
        Handler handler = new Handler();
        handler.postDelayed(task, 2000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}