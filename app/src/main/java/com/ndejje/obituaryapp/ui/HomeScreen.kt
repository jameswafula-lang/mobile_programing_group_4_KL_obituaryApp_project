package com.ndejje.obituaryapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ndejje.obituaryapp.R

@Composable
fun HomeScreen(
    onStartClicked: () -> Unit,
    onViewSavedClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.funeral_service),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = stringResource(id = R.string.slogan),
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = onStartClicked,
            modifier = Modifier.fillMaxWidth(0.8f),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = stringResource(id = R.string.btn_start))
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = onViewSavedClicked,
            modifier = Modifier.fillMaxWidth(0.8f),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = "View Saved Announcements")
        }
    }
}
