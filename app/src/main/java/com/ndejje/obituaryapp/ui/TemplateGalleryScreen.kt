package com.ndejje.obituaryapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.ndejje.obituaryapp.R

data class Template(val id: String, val name: String, val description: String)

@Composable
fun TemplateGalleryScreen(onTemplateSelected: () -> Unit) {
    val templates = listOf(
        Template("1", "Classic White", "Dignified and simple white theme."),
        Template("2", "Buganda Traditional", "Features traditional cultural elements."),
        Template("3", "Golden Sunset", "Premium gold finish for a royal send-off.")
    )

    Scaffold(
        topBar = { Text("Select a Design", modifier = Modifier.padding(dimensionResource(R.dimen.padding_standard))) }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(templates) { template ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(R.dimen.padding_small))
                        .clickable { onTemplateSelected() }
                ) {
                    Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_standard))) {
                        Text(text = template.name, style = MaterialTheme.typography.headlineSmall)
                        Text(text = template.description, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
