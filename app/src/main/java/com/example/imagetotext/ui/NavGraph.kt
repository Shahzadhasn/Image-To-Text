package com.example.imagetotext.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.imagetotext.OcrViewModel
import com.example.imagetotext.ui.screens.HomeScreen
import com.example.imagetotext.ui.screens.ResultScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val ocrViewModel: OcrViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                viewModel = ocrViewModel,
                onNavigateToResult = { navController.navigate("result") }
            )
        }
        composable("result") {
            ResultScreen(
                viewModel = ocrViewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
