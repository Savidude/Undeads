package savidude.com.undeads.Controllers;


import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import savidude.com.undeads.MainActivity;

/**
 * Created by sky on 5/29/2016.
 */
public class AlarmReceiver extends BroadcastReceiver {

    NotificationCompat.Builder notification;

    @Override
    public void onReceive(Context context, Intent intent) {

        String job_Description = "Death God";
        String start_Time = "29-05-2016 00:00";
        String end_Time = "31-12-9999 00:00";

        createNotification(context, job_Description, start_Time, end_Time);
    }

    private void createNotification(Context context, String job_description, String start_time, String end_time) {

        String startTime[] = start_time.split(" ");
        String endTime[] = end_time.split(" ");

        PendingIntent notificIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);

        notification = new NotificationCompat.Builder(context);
        notification.setAutoCancel(true);
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle(job_description);
        notification.setContentText("Date: " + startTime[0] + ", Start Time : " + startTime[1] + ", End Time : " + endTime[0]);
        notification.setContentIntent(notificIntent);
        notification.setDefaults(NotificationCompat.DEFAULT_SOUND);

        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        nm.notify(1, notification.build());


    }

    public static void alarmSet(Context context){


    }
}
