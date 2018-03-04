package com.mauriciotogneri.cryptos;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;

public class NotificationDisplayer
{
    private final Context context;
    private static final String CHANNEL_ID = BuildConfig.APPLICATION_ID + ".notification.channel";

    public NotificationDisplayer(Context context)
    {
        this.context = context;
    }

    public void create(int id, int icon, String title, String text, Intent intent)
    {
        createChannels();

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, CHANNEL_ID);
        notificationBuilder.setSmallIcon(icon);
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setContentTitle(title);
        notificationBuilder.setContentText(text);
        notificationBuilder.setPriority(Notification.PRIORITY_HIGH);
        notificationBuilder.setVibrate(new long[0]);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, id, intent, PendingIntent.FLAG_ONE_SHOT);
        notificationBuilder.setContentIntent(pendingIntent);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(id, notificationBuilder.build());
    }

    private void createChannels()
    {
        if (Build.VERSION.SDK_INT >= VERSION_CODES.O)
        {
            NotificationChannel notificationChannel = new NotificationChannel(
                    CHANNEL_ID,
                    context.getString(R.string.app_name),
                    NotificationManager.IMPORTANCE_DEFAULT);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(ContextCompat.getColor(context, R.color.colorPrimary));
            notificationChannel.setShowBadge(true);
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            if (notificationManager != null)
            {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
    }
}