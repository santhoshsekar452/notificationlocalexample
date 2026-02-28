package com.santhosh.notificationlocalexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import com.santhosh.notificationlocalexample.core.notification.NotificationPermissionManager
import com.santhosh.notificationlocalexample.domain.notification.ReminderScheduler
import com.santhosh.notificationlocalexample.presentation.reminder.AppNavGraph
import com.santhosh.notificationlocalexample.presentation.reminder.ReminderScreen
import com.santhosh.notificationlocalexample.presentation.reminder.ReminderViewModel
import com.santhosh.notificationlocalexample.presentation.reminder.Routes
import com.santhosh.notificationlocalexample.ui.theme.NotificationLocalExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        NotificationPermissionManager.request(this)
        val scheduler = ReminderScheduler(context = this)
        val  viewModel = ReminderViewModel(scheduler = scheduler)
        setContent {
            NotificationLocalExampleTheme {
                val navController = rememberNavController()
                val screen = intent?.getStringExtra("screen")
                AppNavGraph(
                    screen = screen ?: Routes.REMINDER_DETAILS,
                    navController = navController,
                    viewModel = viewModel
                )
            }
        }
    }
}
