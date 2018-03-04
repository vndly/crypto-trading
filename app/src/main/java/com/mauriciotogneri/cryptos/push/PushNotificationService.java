package com.mauriciotogneri.cryptos.push;

import android.content.Intent;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.mauriciotogneri.cryptos.activities.MainActivity;
import com.mauriciotogneri.cryptos.R;

public class PushNotificationService extends FirebaseMessagingService
{
    private static int NOTIFICATION_REQUEST_CODE_ID = 1;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage)
    {
        int icon = R.drawable.ic_notification;
        String title = getString(R.string.app_name);
        String message = remoteMessage.getNotification().getBody();
        Intent intent = new Intent(this, MainActivity.class);

        NotificationDisplayer notificationDisplayer = new NotificationDisplayer(this);
        notificationDisplayer.create(requestCodeId(), icon, title, message, intent);
    }

    public static int requestCodeId()
    {
        synchronized (PushNotificationService.class)
        {
            return NOTIFICATION_REQUEST_CODE_ID++;
        }
    }
}