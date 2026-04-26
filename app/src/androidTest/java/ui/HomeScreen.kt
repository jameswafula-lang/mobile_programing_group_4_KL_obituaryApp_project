package com.ndejje.obituaryapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ndejje.obituaryapp.R

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_standard)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // App Title using A-Plus Blue (Primary)
        Text(
            text = stringResource(id = R.string.funeral_service),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        // Slogan using String Resource
        Text(
            text = stringResource(id = R.string.slogan),
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_standard))
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_standard)))

        // The Main Action Button
        Button(
            onClick = { /* We will add navigation later */ },
            modifier = Modifier.fillMaxWidth(0.8f),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = stringResource(id = R.string.btn_start))
        }
    }
}
