package com.ndejje.obituaryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ndejje.obituaryapp.ui.AnnouncementDatabase
import com.ndejje.obituaryapp.ui.AnnouncementRepository
import com.ndejje.obituaryapp.ui.AnnouncementViewModel
import com.ndejje.obituaryapp.ui.ObituaryAppNavigation
import com.ndejje.obituaryapp.ui.theme.APlusFuneralTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        val database = AnnouncementDatabase.getDatabase(this)
        val repository = AnnouncementRepository(database.announcementDao())

        setContent {
            APlusFuneralTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: AnnouncementViewModel = viewModel(
                        factory = AnnouncementViewModelFactory(repository)
                    )
                    ObituaryAppNavigation(viewModel = viewModel)
                }
            }
        }
    }
}

class AnnouncementViewModelFactory(private val repository: AnnouncementRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnnouncementViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AnnouncementViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
