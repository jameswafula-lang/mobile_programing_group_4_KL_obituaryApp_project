package com.ndejje.obituaryapp.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ndejje.obituaryapp.ui.theme.ObituaryAppTheme

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onStartClicked = { navController.navigate("gallery") })
        }
        composable("gallery") {
            TemplateGalleryScreen(onTemplateSelected = { navController.navigate("editor") })
        }
        composable("editor") {
            // This calls your Editor Screen
            AnnouncementEditorScreen(onPreviewClicked = { navController.navigate("preview") })
        }
        composable("preview") {
            // Placeholder for the final screen
            Text(text = "Final Announcement Card Preview")
        }
    }
}

// --- PREVIEW SECTION ---
// This allows you to see the Home Screen in the "Split" view
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ObituaryAppTheme {
        HomeScreen(onStartClicked = {})
    }
}
