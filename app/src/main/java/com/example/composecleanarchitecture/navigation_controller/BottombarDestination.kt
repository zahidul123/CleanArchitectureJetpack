package com.example.composecleanarchitecture.navigation_controller

import com.example.composecleanarchitecture.R

sealed class BottomBarDestination(var title: String, var icon: Int, var route: String) {
    object HomeScreen : BottomBarDestination("Home", R.drawable.ic_home, "HomeScreen")
    object QuestionBankScreen :
        BottomBarDestination("Questions Bank", R.drawable.ic_books, "QuestionBankScreen")

    object MyQuestionsScreen :
        BottomBarDestination("My Questions", R.drawable.ic_question, "MyQuestionsScreen")

    object CircularScreen :
        BottomBarDestination("Circular", R.drawable.ic_circular, "CircularScreen")
}