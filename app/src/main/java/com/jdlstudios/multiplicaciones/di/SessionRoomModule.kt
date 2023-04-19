package com.jdlstudios.multiplicaciones.di

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Room
import com.jdlstudios.multiplicaciones.data.database.SessionDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SessionRoomModule {

    private const val SESSION_DATABASE_NAME = "session_database"

    @RequiresApi(Build.VERSION_CODES.O)
    @Singleton
    @Provides
    fun provideSessionRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        SessionDatabase::class.java,
        SESSION_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideSessionRoomDao(sessionDB: SessionDatabase) = sessionDB.getSessionDao()

}