package com.example.prof.mybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class PhoneRx extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String state = intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
        Toast.makeText(context,state,Toast.LENGTH_LONG).show();
    }
}
