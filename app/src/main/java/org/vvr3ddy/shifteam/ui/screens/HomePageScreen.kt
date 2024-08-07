package org.vvr3ddy.shifteam.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class HomePageScreen private constructor(){
    companion object {
        val instance: HomePageScreen by lazy {
            HomePageScreen()
        }
    }

    @Composable
    fun ShowHomePage(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.then(Modifier.fillMaxSize()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Home Page")
        }
    }
}