package com.santhosh.notificationlocalexample.core.notification

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        val title = remoteMessage.notification?.title ?: "Default Title"
        val body = remoteMessage.notification?.body ?: "Default Message"


        NotificationHelper.showReminder(
            context = this,
            title = title,
            message = body
        )
    }

    override fun onNewToken(token: String) {
        Log.d("FCM_TOKEN", token)
    }
}