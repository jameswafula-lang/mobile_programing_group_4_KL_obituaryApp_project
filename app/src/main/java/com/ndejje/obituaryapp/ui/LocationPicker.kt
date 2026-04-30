package com.ndejje.obituaryapp.ui

import android.annotation.SuppressLint
import android.content.Context
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource

@SuppressLint("MissingPermission")
fun acquireCurrentLocation(context: Context, onLocationAcquired: (Double, Double) -> Unit) {
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    
    fusedLocationClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, CancellationTokenSource().token)
        .addOnSuccessListener { location ->
            if (location != null) {
                onLocationAcquired(location.latitude, location.longitude)
            }
        }
}

fun openMapForLocation(context: Context, onLocationPicked: (Double, Double) -> Unit) {

    acquireCurrentLocation(context, onLocationPicked)
}
