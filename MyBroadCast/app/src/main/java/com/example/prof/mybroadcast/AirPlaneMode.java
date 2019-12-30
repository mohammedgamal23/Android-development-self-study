package com.example.prof.mybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class AirPlaneMode extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        //boolean airMode = intent.getExtras().getBoolean("state");
        Bundle air = intent.getExtras();
        if(air != null)
        {
            boolean state = air.getBoolean("state");
            if(state == true)
            {
                Log.d("AirPlaneMode","ON");
            }else
            {
                Log.d("AirPlaneMode","OFF");
            }
        }
    }
}
