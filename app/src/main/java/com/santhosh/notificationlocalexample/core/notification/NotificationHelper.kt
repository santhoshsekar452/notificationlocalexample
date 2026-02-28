package com.santhosh.notificationlocalexample.core.notification

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.santhosh.notificationlocalexample.MainActivity
import com.santhosh.notificationlocalexample.R

object NotificationHelper {

    @SuppressLint("ServiceCast")
    fun showReminder(context: Context, title: String, message: String) {
        val builder = NotificationCompat.Builder(
            context,
            NotificationConstants.CHANNEL_ID
        )
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        val manager =
            context.getSystemService(Context.NOTIFICATION_SERVICE)
                    as NotificationManager

        manager.notify(System.currentTimeMillis().toInt(), builder.build())
    }
}