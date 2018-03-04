package com.mauriciotogneri.cryptos.app;

import android.app.Application;

import com.google.firebase.messaging.FirebaseMessaging;

public class Cryptos extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        FirebaseMessaging.getInstance().subscribeToTopic("global");
    }
}