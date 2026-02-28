package com.santhosh.notificationlocalexample.domain.notification

import android.content.Context
import com.santhosh.notificationlocalexample.core.notification.NotificationHelper

class ReminderScheduler(
    private val context: Context
) {
    fun triggerNow(title: String, message: String) {
        NotificationHelper.showReminder(context, title, message)
    }
}