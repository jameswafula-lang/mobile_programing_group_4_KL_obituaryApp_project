package com.ndejje.obituaryapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.ndejje.obituaryapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnnouncementEditorScreen(onPreviewClicked: () -> Unit) {
    // State management: These variables hold the data as the user types
    var name by remember { mutableStateOf("") }
    var village by remember { mutableStateOf("") }
    var burialDate by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Enter Details") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(dimensionResource(R.dimen.padding_standard))
                .verticalScroll(rememberScrollState()) // Allows scrolling on small phones
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            // Name
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Deceased Name") },
                modifier = Modifier.fillMaxWidth()
            )

            // Village
            OutlinedTextField(
                value = village,
                onValueChange = { village = it },
                label = { Text("Village/Location") },
                modifier = Modifier.fillMaxWidth()
            )

            // Burial Date
            OutlinedTextField(
                value = burialDate,
                onValueChange = { burialDate = it },
                label = { Text("Burial Date (DD/MM/YYYY)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_standard)))

            // Map Button (Placeholder for Google Maps Pin)
            Button(
                onClick = { /* Future: Launch Google Maps */ },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Set Burial Location (GPS)")
            }

            // Preview Button
            Button(
                onClick = onPreviewClicked,
                modifier = Modifier.fillMaxWidth(),
                enabled = name.isNotEmpty() // Button only works if name is entered
            ) {
                Text("Preview Announcement")
            }
        }
    }
}
