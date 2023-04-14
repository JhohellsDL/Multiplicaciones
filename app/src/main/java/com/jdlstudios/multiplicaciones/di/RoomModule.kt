package com.jdlstudios.multiplicaciones.di

import android.content.Context
import androidx.room.Room
import com.jdlstudios.multiplicaciones.data.database.MultiplicationDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val MULTIPLICATION_DATABASE_NAME = "multiplication_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        MultiplicationDatabase::class.java,
        MULTIPLICATION_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideRoomDao(db: MultiplicationDatabase) = db.getMultiplicationDao()

}