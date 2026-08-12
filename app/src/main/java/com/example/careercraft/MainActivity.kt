package com.example.careercraft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.careercraft.navigation.CareerCraftNavGraph
import com.example.careercraft.ui.theme.CareerCraftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CareerCraftTheme {
                CareerCraftNavGraph()
            }
        }
    }
}