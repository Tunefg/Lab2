package com.raywenderlich.android.lab1.screens

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import com.raywenderlich.android.lab1.router.BackButtonHandler
import kotlinx.coroutines.CoroutineScope
import com.raywenderlich.android.lab1.router.FundamentalsRouter
import androidx.compose.material.rememberScaffoldState
import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import com.raywenderlich.android.lab1.router.Screen
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.colorResource
import com.raywenderlich.android.lab1.R

@Composable
fun ScaffoldScreen(){
    MyScaffold()

    BackButtonHandler {
        FundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun MyScaffold() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        contentColor = colorResource(id = R.color.colorPrimary),
        content = {
            MyRow()
        },
        topBar = { MyTopAppBar(scaffoldState = scaffoldState, scope = scope) },
        bottomBar = { MyBottomAppBar()},
        drawerContent = { MyColumn()}
    )
}

@Composable
fun MyTopAppBar(scaffoldState: ScaffoldState,scope: CoroutineScope){}

@Composable
fun MyBottomAppBar(){}