package com.santhosh.notificationlocalexample.presentation.reminder

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ReminderScreen(viewModel: ReminderViewModel) {


    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(100.dp)
    ) {
        Button(onClick = {
            Log.d("NOTI_TEST", "Notification triggered")
            viewModel.sendReminder()
        },
        ) {
            Text("Show Reminder")
        }
    }

}