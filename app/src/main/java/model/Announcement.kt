package com.ndejje.obituaryapp.model
data class Announcement(
    val id: Int = 0,
    val deceasedName: String,
    val dateOfBirth: String,
    val dateOfDeath: String,
    val burialDate: String,
    val village: String,
    val mapLocationUrl: String, // for Google Maps Pin
    val templateTheme: String   // Classic or Buganda Traditional
)
