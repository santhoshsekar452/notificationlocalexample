package com.santhosh.notificationlocalexample.core.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

object NotificationChannelManager {

    fun create(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                NotificationConstants.CHANNEL_ID,
                NotificationConstants.CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            )

            val manager =
                context.getSystemService(NotificationManager::class.java)

            manager.createNotificationChannel(channel)
        }
    }
}