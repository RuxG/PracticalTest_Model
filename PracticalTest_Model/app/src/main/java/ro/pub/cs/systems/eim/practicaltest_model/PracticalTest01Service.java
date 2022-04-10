package ro.pub.cs.systems.eim.practicaltest_model;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class PracticalTest01Service extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Started Service", "onCreate() method was invoked");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("Started Service", "onBind() method was invoked");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("Started Service", "onUnbind() method was invoked");
        return true;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d("Started Service", "onRebind() method was invoked");
    }

    @Override
    public void onDestroy() {
        Log.d("Started Service", "onDestroy() method was invoked");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Thread dedicatedThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("Started Service", "Thread.run() was invoked, PID: " + android.os.Process.myPid() + " TID: " + android.os.Process.myTid());
                Intent intent = new Intent();
                intent.setAction("MY_DATA_ACTION");
                intent.putExtra("MY_DATA", "DATA_SAMPLE");
                while (true) {
                    sendBroadcast(intent);
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        dedicatedThread.start();
        return START_REDELIVER_INTENT;
    }
}