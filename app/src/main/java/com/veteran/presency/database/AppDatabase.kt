package com.veteran.presency.database

import androidx.room.Database
import com.veteran.presency.model.ModelDatabase
import androidx.room.RoomDatabase
import com.veteran.presency.database.dao.DatabaseDao

@Database(entities = [ModelDatabase::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao?
}