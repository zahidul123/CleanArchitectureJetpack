package com.example.composecleanarchitecture.ui.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composecleanarchitecture.navigation_controller.Destinations
import com.example.composecleanarchitecture.ui.common_components.ToolBarLayoutComponent
import com.example.composecleanarchitecture.ui.features.home.components.CaouselPager
import com.example.composecleanarchitecture.ui.features.home.components.CarouselPagerYearWise
import com.example.composecleanarchitecture.ui.features.home.components.CategoryHeadingComponent
import com.example.composecleanarchitecture.ui.theme.secondaryColor


@Composable
fun HomeScreen(navController: NavController) {

    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = secondaryColor)
    ) {
        ToolBarLayoutComponent(
            navController = navController,
            isBackShow = false,
            title = "রাফখাতা",
            textSize = 18.sp
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = secondaryColor)
                .verticalScroll(state = scrollState)
        ) {

            CategoryHeadingComponent("বিগত সালের প্রশ্ন", "08") {
                navController.navigate(Destinations.AllPreviousYearCategory.route)

            }
            CaouselPager {
                navController.navigate(Destinations.QuestionDetailsScreen.route)
            }
            CategoryHeadingComponent("প্রতিষ্ঠান ভিত্তিক প্রশ্ন", "73"){

            }
            CaouselPager {
                navController.navigate(Destinations.QuestionDetailsScreen.route)
            }
            CategoryHeadingComponent("সাল ভিত্তিক প্রশ্ন", "23"){

            }
            CarouselPagerYearWise {
                navController.navigate(Destinations.QuestionDetailsScreen.route)
            }
            CategoryHeadingComponent("টপিক ভিত্তিক প্রশ্ন", "23"){

            }
            CarouselPagerYearWise {
                navController.navigate(Destinations.QuestionDetailsScreen.route)
            }
            CategoryHeadingComponent("বিষয় ভিত্তিক প্রশ্ন", "23"){

            }
            CarouselPagerYearWise {

            }

        }
    }
}