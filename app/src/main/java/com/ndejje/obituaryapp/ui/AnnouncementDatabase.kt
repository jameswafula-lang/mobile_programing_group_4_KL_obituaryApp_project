package com.ndejje.obituaryapp.ui

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ndejje.obituaryapp.model.Announcement

@Database(entities = [Announcement::class], version = 1, exportSchema = false)
abstract class AnnouncementDatabase : RoomDatabase() {
    abstract fun announcementDao(): AnnouncementDao

    companion object {
        @Volatile
        private var INSTANCE: AnnouncementDatabase? = null

        fun getDatabase(context: Context): AnnouncementDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AnnouncementDatabase::class.java,
                    "announcement_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
