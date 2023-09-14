package com.example.composecleanarchitecture.navigation_controller


sealed class Destinations(val route: String) {
    object SplashScreen : Destinations("SplashScreen")
    object LoginScreen : Destinations("LoginScreen")
    object DashBoardScreen : Destinations("DashBoardScreen")
    object QuestionDetailsScreen : Destinations("QuestionDetailsScreen")
    object AllPreviousYearCategory : Destinations("AllPreviousYearCategory")
}

