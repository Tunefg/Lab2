package com.raywenderlich.android.lab1.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.raywenderlich.android.lab1.router.BackButtonHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.colorResource
import com.raywenderlich.android.lab1.R
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.raywenderlich.android.lab1.router.FundamentalsRouter
import com.raywenderlich.android.lab1.router.Screen


@Composable
fun TextScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyText()
    }

    BackButtonHandler {
        FundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun MyText() {

    Text(
        text = stringResource(id = R.string.set_text),

        fontStyle = FontStyle.Normal,
        color = colorResource(id = R.color.blue),
        fontWeight = FontWeight.Black,
        fontSize = 30.sp

    )
}