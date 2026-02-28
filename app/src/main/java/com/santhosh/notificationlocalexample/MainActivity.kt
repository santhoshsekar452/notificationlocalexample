package com.santhosh.notificationlocalexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
        setContent {
            NotificationLocalExampleTheme {
                ReminderScreen(viewModel = ReminderViewModel(
                    scheduler = scheduler
                ))
            }
        }
    }
}
