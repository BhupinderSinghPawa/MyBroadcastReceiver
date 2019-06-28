package com.example.mybroadcastreceiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sticky Intent Filter - returns the value from last broadcast
        IntentFilter batIntentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent battery = registerReceiver(null, batIntentFilter);
        int status = battery.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging =
                ((status == BatteryManager.BATTERY_STATUS_CHARGING) ||
                        (status == BatteryManager.BATTERY_STATUS_FULL));
        Log.i("myLog", "Battery " + status + " " + isCharging);
    }

    // onClick() property of start button
    public void startAlert(View view) {

        // read value
        EditText timeText = (EditText) findViewById(R.id.timeText);
        int i = Integer.parseInt(timeText.getText().toString());

        // Define a Pending Intent to start MyBroadcastReceiver
        Intent intentToFire = new Intent(this, MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(),
                234324243,
                intentToFire,
                0);

        // Set Alarm with the Pending Intent
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + (i * 1000),
                pendingIntent);

        Toast.makeText(this, "Alarm set for " + i + " seconds",
                Toast.LENGTH_LONG).show();
        Log.i("myLog", "Alarm set for " + i + " seconds");

    }


}
