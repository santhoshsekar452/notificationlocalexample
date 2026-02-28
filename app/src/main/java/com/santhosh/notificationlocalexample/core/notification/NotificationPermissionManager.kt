package com.santhosh.notificationlocalexample.core.notification

import android.Manifest
import android.app.Activity
import android.os.Build
import androidx.core.app.ActivityCompat

object NotificationPermissionManager {

    fun request(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                100
            )
        }
    }
}