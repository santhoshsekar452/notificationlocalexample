package com.santhosh.notificationlocalexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.google.firebase.messaging.FirebaseMessaging
import com.santhosh.notificationlocalexample.core.notification.NotificationPermissionManager
import com.santhosh.notificationlocalexample.domain.notification.ReminderScheduler
import com.santhosh.notificationlocalexample.presentation.reminder.ReminderScreen
import com.santhosh.notificationlocalexample.presentation.reminder.ReminderViewModel
import com.santhosh.notificationlocalexample.ui.theme.NotificationLocalExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        NotificationPermissionManager.request(this)
        val scheduler = ReminderScheduler(context = this)
        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("FCM_TOKEN", "Token: ${task.result}")
                } else {
                    Log.d("FCM_TOKEN", "Fetching failed")
                }
            }
        setContent {
            NotificationLocalExampleTheme {
                ReminderScreen(viewModel = ReminderViewModel(
                    scheduler = scheduler
                ))
            }
        }
    }
}
