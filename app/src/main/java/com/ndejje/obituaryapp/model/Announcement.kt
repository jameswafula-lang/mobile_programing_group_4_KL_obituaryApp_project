package com.ndejje.obituaryapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "announcements")
data class Announcement(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val deceasedName: String,
    val dateOfBirth: String,
    val dateOfDeath: String,
    val burialDate: String,
    val village: String,
    val latitude: Double?,
    val longitude: Double?,
    val imagePath: String?, // URI or file path
    val templateId: Int, // 0 = Classic, 1 = Buganda
    val timestamp: Long = System.currentTimeMillis()
)
