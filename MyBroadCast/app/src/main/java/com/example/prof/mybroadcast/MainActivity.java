package com.example.prof.mybroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    AirPlaneMode airPlaneMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        airPlaneMode = new AirPlaneMode();
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(airPlaneMode,new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
        }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(airPlaneMode);
    }
}
