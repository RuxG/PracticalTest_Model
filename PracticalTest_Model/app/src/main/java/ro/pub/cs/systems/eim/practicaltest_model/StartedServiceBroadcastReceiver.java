package ro.pub.cs.systems.eim.practicaltest_model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    public StartedServiceBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.compareTo("MY_DATA_ACTION") == 0) {
            String extra = intent.getStringExtra("MY_DATA");
            Log.d("MyBroadcastReciever", "Received from service MY_DATA: " + extra + "\n");
        }

    }
}
