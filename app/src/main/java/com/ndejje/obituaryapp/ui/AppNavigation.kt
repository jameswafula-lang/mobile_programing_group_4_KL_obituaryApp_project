package com.ndejje.obituaryapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object TemplateGallery : Screen("template_gallery")
    object Editor : Screen("editor")
    object Preview : Screen("preview")
    object SavedList : Screen("saved_list")
}

@Composable
fun ObituaryAppNavigation(viewModel: AnnouncementViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(
                onStartClicked = { navController.navigate(Screen.TemplateGallery.route) },
                onViewSavedClicked = { navController.navigate(Screen.SavedList.route) }
            )
        }
        composable(Screen.TemplateGallery.route) {
            TemplateGalleryScreen(
                onTemplateSelected = { templateId -> viewModel.selectTemplate(templateId) },
                onNavigateToEditor = { navController.navigate(Screen.Editor.route) }
            )
        }
        composable(Screen.Editor.route) {
            AnnouncementEditorScreen(
                viewModel = viewModel,
                onNavigateToPreview = { navController.navigate(Screen.Preview.route) }
            )
        }
        composable(Screen.Preview.route) {
            PreviewShareScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack(Screen.Home.route, false) }
            )
        }
        composable(Screen.SavedList.route) {
            AnnouncementListScreen(
                viewModel = viewModel,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
