package com.ndejje.obituaryapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ndejje.obituaryapp.R
import com.ndejje.obituaryapp.model.Announcement

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnnouncementListScreen(
    viewModel: AnnouncementViewModel,
    onNavigateBack: () -> Unit
) {
    val announcements by viewModel.announcements.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Saved Announcements") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        if (announcements.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No announcements saved yet.", style = MaterialTheme.typography.bodyLarge)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(announcements) { announcement ->
                    AnnouncementItem(announcement = announcement)
                }
            }
        }
    }
}

@Composable
fun AnnouncementItem(announcement: Announcement) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = announcement.deceasedName, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "Died: ${announcement.dateOfDeath}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Burial: ${announcement.burialDate}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
