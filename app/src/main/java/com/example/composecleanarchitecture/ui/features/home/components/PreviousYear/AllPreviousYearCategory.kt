package com.example.composecleanarchitecture.ui.features.home.components.PreviousYear

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composecleanarchitecture.R
import com.example.composecleanarchitecture.models.dashboard.previous_year.PreviousYearQuestion
import com.example.composecleanarchitecture.ui.common_components.CardWithImage
import com.example.composecleanarchitecture.ui.common_components.CustomTextComponents
import com.example.composecleanarchitecture.ui.common_components.ToolBarLayoutComponent
import com.example.composecleanarchitecture.ui.theme.blackVarColor1
import com.example.composecleanarchitecture.ui.theme.secondaryColor

@Composable
fun AllPreviousYearCategory(navController: NavController) {
    val state = rememberLazyGridState()
    val categories = listOf<PreviousYearQuestion>(
        PreviousYearQuestion(
            false,
            "New",
            "বিসিএস",
            R.drawable.ic_bcs_pasc
        ),
        PreviousYearQuestion(
            false,
            "New",
            "ব্যাংক",
            R.drawable.ic_bank
        ),
        PreviousYearQuestion(
            false,
            "New",
            "ঢাবি আইবিএ",
            R.drawable.ic_du_iba
        ),
        PreviousYearQuestion(
            false,
            "New",
            "জুডিসিয়াল",
            R.drawable.ic_judge
        ),
        PreviousYearQuestion(
            false,
            "New",
            "পিএসসি",
            R.drawable.ic_bcs_pasc
        ),
        PreviousYearQuestion(
            false,
            "New",
            "কলেজ",
            R.drawable.ic_school_college
        ),
        PreviousYearQuestion(
            false,
            "New",
            "হাই স্কুল",
            R.drawable.ic_school_college
        ),
        PreviousYearQuestion(
            false,
            "New",
            "প্রাইমারি",
            R.drawable.ic_primary_school
        ),
        PreviousYearQuestion(
            false,
            "New",
            "প্রাইভেট ব্যাংক",
            R.drawable.ic_private_bank
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = secondaryColor)
    ) {
        ToolBarLayoutComponent(
            navController = navController,
            isBackShow = true,
            title = "বিগত সালের প্রশ্ন",
            textSize = 16.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
            CustomTextComponents(
                title = "বিগত সালের প্রশ্ন",
                fontWeight = FontWeight.W400,
                textColor = blackVarColor1,
                textSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalGrid(
            state = state,
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp),
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(categories.size) { index ->
                CardWithImage(
                    previousYearQuestion = categories[index]
                )
            }
        }
    }
}