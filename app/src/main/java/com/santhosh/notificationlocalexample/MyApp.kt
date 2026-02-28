package com.santhosh.notificationlocalexample

import android.app.Application
import com.santhosh.notificationlocalexample.core.notification.NotificationChannelManager

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        NotificationChannelManager.create(this)
    }
}