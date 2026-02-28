package com.santhosh.notificationlocalexample.presentation.reminder

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun AppNavGraph(
    screen: String,
    navController: NavHostController,
    viewModel: ReminderViewModel
) {
    LaunchedEffect(screen) {
        if (screen == "home") {
            navController.navigate(Routes.HOME)
        }
    }

   NavHost(
        navController = navController,
        startDestination = Routes.REMINDER_DETAILS
    ) {
        composable(Routes.HOME) {
            HomeScreen()
        }
        composable(Routes.REMINDER_DETAILS) {
            ReminderScreen(viewModel)
        }

    }
}