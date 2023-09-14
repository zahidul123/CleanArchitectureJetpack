package com.example.composecleanarchitecture.navigation_controller

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composecleanarchitecture.ui.features.circular.CircularScreen
import com.example.composecleanarchitecture.ui.features.home.HomeScreen
import com.example.composecleanarchitecture.ui.features.home.components.PreviousYear.AllPreviousYearCategory
import com.example.composecleanarchitecture.ui.features.my_question.MyQuestionsScreen
import com.example.composecleanarchitecture.ui.features.question_bank.QuestionBankScreen
import com.example.composecleanarchitecture.ui.features.question_details.QuestionDetailsScreen


@Composable
fun BottomBarNavGraph(
    navController: NavController,
    logout: () -> Unit
) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = BottomBarDestination.HomeScreen.route
    ) {
        composable(BottomBarDestination.HomeScreen.route) { HomeScreen(navController = navController) }
        composable(BottomBarDestination.QuestionBankScreen.route) { QuestionBankScreen(navController = navController) }
        composable(BottomBarDestination.MyQuestionsScreen.route) { MyQuestionsScreen(navController = navController) }
        composable(BottomBarDestination.CircularScreen.route) {
            CircularScreen() {
                logout()
            }
        }
        composable(Destinations.QuestionDetailsScreen.route) { QuestionDetailsScreen(navController) }
        composable(Destinations.AllPreviousYearCategory.route) {
            AllPreviousYearCategory(
                navController
            )
        }
    }
}