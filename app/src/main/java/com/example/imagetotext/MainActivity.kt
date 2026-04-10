package com.example.imagetotext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.imagetotext.ui.NavGraph
import com.example.imagetotext.ui.theme.ImageToTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImageToTextTheme {
                NavGraph()
            }
        }
    }
}
