package com.santhosh.notificationlocalexample.presentation.reminder

import androidx.lifecycle.ViewModel
import com.santhosh.notificationlocalexample.core.notification.NotificationChannelManager
import com.santhosh.notificationlocalexample.domain.notification.ReminderScheduler

class ReminderViewModel(
    private val scheduler: ReminderScheduler
) : ViewModel() {

    fun sendReminder() {
        scheduler.triggerNow(
            title = "Reminder",
            message = "Time to complete your task"
        )
    }
}