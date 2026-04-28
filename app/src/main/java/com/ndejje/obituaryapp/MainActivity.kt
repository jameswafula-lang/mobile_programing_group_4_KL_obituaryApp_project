package com.ndejje.obituaryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ndejje.obituaryapp.ui.AppNavigation
import com.ndejje.obituaryapp.ui.theme.ObituaryAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ObituaryAppTheme {
                // This calls your Navigation system which starts at the Home Screen
                AppNavigation()
            }
        }
    }
}

