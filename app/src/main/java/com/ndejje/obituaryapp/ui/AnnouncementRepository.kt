package com.ndejje.obituaryapp.ui

import com.ndejje.obituaryapp.model.Announcement
import kotlinx.coroutines.flow.Flow

class AnnouncementRepository(private val dao: AnnouncementDao) {
    fun getAllAnnouncements(): Flow<List<Announcement>> = dao.getAllAnnouncements()

    suspend fun saveAnnouncement(announcement: Announcement) = dao.insert(announcement)

    suspend fun deleteAnnouncement(announcement: Announcement) = dao.delete(announcement)
}
