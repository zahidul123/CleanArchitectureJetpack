package com.example.composecleanarchitecture.ui.features.question_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composecleanarchitecture.ui.common_components.CustomTextComponents
import com.example.composecleanarchitecture.ui.theme.optionTextColor
import com.example.composecleanarchitecture.ui.theme.outlineBorderColor
import com.example.composecleanarchitecture.ui.theme.whiteColor

@Composable
fun OutlineBorderWithText(
    index: String,
    title: String,
    answered: Boolean = false,
    backGroundColor: Color = outlineBorderColor,
    textColor: Color = optionTextColor,
    isAnswerClicked: (index: String, isAnswered: Boolean) -> Unit
) {
    var isAnswered by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 10.dp)
            .background(
                color = if (answered) backGroundColor else whiteColor,
                shape = RoundedCornerShape(corner = CornerSize(8.dp))
            )
            .border(
                width = 1.dp,
                color = backGroundColor,
                shape = RoundedCornerShape(corner = CornerSize(8.dp))
            )
            .clickable {
                if (!isAnswered) {
                    isAnswered = true
                    isAnswerClicked.invoke(index, true)
                }
            },
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .align(alignment = Alignment.CenterStart)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                CustomTextComponents(
                    title = "$index . ",
                    fontWeight = FontWeight.W400,
                    textSize = 14.sp,
                    textColor = textColor,
                    textAlign = TextAlign.Start
                )
                CustomTextComponents(
                    title = title,
                    fontWeight = FontWeight.W400,
                    textSize = 14.sp,
                    textColor = textColor,
                    textAlign = TextAlign.Start
                )
            }

        }
    }
}

@Preview
@Composable
fun dwsde() {
    OutlineBorderWithText(
        "A",
        " ঢাক্ ঢাক্ গুড় গুড় করে কী লাভ,কাজে \nলেগে যাও"
    ) { index, isAnswered ->

    }
}