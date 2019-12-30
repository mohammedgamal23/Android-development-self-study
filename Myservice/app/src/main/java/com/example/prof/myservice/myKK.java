package com.example.prof.myservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


public class myKK extends Service {


    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                {
                    CreateNotification();
                }
            }
            t.
        });



        return super.onStartCommand(intent, flags, startId);

    }

    private void CreateNotification()
    {
        Intent intent = new Intent(this,myKK.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("New Notification");
        builder.setContentText("Subject");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.addAction(android.R.drawable.alert_dark_frame,"play",pendingIntent);
        builder.addAction(android.R.drawable.sym_action_call,"Pause",pendingIntent);
        Notification noti = builder.build();
        NotificationManager nmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nmanager.notify(0,noti);
    }
}
