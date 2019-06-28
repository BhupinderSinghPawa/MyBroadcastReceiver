package com.example.mybroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class MyPhoneSender extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle extras = intent.getExtras();

        Log.i("myLog", "MyPhoneSender onReceive() called");

        if (extras != null) {

            String state = extras.getString(TelephonyManager.EXTRA_STATE);
            Log.i("myLog", state);

            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                String phoneNumber = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.w("myLog", phoneNumber);

                // toast
                Toast.makeText(context, "Receiving " + state + "from " + phoneNumber, Toast.LENGTH_LONG).show();
                Log.i("myLog", "Receiving " + state + "from " + phoneNumber);

            }

        }
    }
}
