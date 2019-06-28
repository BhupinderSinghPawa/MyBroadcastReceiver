package com.example.mybroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // toast
        Toast.makeText(context, "Toast the onReceive() callback", Toast.LENGTH_LONG).show();
        Log.i("myLog", "MyBroadCastReceiver onReceive() called");

        // vibrate the phone, add permissions in Manifest
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);

        /*
        // Manifest file - register receiver - android.intent.action.PHONE_STATE
        // and user permissions for android.permission.READ_PHONE_STATE
        Bundle extras = intent.getExtras();
        String state = extras.getString(TelephonyManager.EXTRA_STATE);
        String phonenumber = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
        Log.i("com.example.mybroadcastreceiver",state + ", " + phonenumber);
        */
    }

}
