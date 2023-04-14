package com.jdlstudios.multiplicaciones.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jdlstudios.multiplicaciones.data.database.dao.MultiplicationDao
import com.jdlstudios.multiplicaciones.data.database.entities.MultiplicationEntity

@Database(entities = [MultiplicationEntity::class], version = 1)
abstract class MultiplicationDatabase: RoomDatabase() {

    abstract fun getMultiplicationDao(): MultiplicationDao

}