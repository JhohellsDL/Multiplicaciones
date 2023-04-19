package com.jdlstudios.multiplicaciones.data.database

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jdlstudios.multiplicaciones.data.database.converters.Converters
import com.jdlstudios.multiplicaciones.data.database.dao.MultiplicationSessionDao
import com.jdlstudios.multiplicaciones.data.database.entities.MultiplicationSessionEntity

@RequiresApi(Build.VERSION_CODES.O)
@Database(entities = [MultiplicationSessionEntity::class], version = 1 , exportSchema = false)
@TypeConverters(Converters::class)
abstract class SessionDatabase: RoomDatabase() {

    abstract fun getSessionDao(): MultiplicationSessionDao

}