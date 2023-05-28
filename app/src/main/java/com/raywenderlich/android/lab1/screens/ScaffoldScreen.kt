package com.raywenderlich.android.lab1.screens


import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import com.raywenderlich.android.lab1.router.BackButtonHandler
import kotlinx.coroutines.CoroutineScope
import com.raywenderlich.android.lab1.router.FundamentalsRouter
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.foundation.layout.*
import androidx.compose.material.rememberScaffoldState
import android.os.Bundle
import androidx.compose.ui.graphics.Color
import com.raywenderlich.android.lab1.router.Screen
import androidx.activity.compose.setContent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.colorResource
import com.raywenderlich.android.lab1.R
import androidx.compose.foundation.background
import androidx.activity.ComponentActivity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@Composable
fun ScaffoldScreen(){
    MyScaffold()

    BackButtonHandler {
        FundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyScaffold() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        contentColor = colorResource(id = R.color.colorPrimary),
        content = {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxSize()) {

                THREE_ELEMENT_LIST.forEach { textResId ->
                    Text(
                        text = stringResource(id = textResId),
                        fontSize = 18.sp
                    )
                }


            }
        },
        topBar = { MyTopAppBar(scaffoldState = scaffoldState, scope = scope) },
        bottomBar = { MyBottomAppBar()},
        drawerContent = { MyColumn()}
    )
}

@Composable
fun MyTopAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    val drawerState = scaffoldState.drawerState
    TopAppBar(
        navigationIcon = {
            IconButton(
                content = {
                    Icon(
                        Icons.Default.Menu,
                        tint = Color.White,
                        contentDescription = stringResource(id = R.string.menu)
                    )
                },
                onClick = {
                    scope.launch { if (drawerState.isClosed) drawerState.open() else drawerState.close() }
                }
            )
        },
        title = { Text(text = stringResource(id = R.string.app_name), color = Color.White) },
        backgroundColor = colorResource(id = R.color.colorPrimary)
    )
}

@Composable
fun MyBottomAppBar(){
    BottomAppBar(
        content = {},
        backgroundColor = colorResource(id = R.color.colorPrimary)
    )
}