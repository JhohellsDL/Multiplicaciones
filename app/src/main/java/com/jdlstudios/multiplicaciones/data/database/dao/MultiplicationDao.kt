package com.jdlstudios.multiplicaciones.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jdlstudios.multiplicaciones.data.database.entities.MultiplicationEntity

@Dao
interface MultiplicationDao {

    @Query("SELECT * FROM multiplication_table")
    suspend fun getAllMultiplications(): List<MultiplicationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(multiplications: List<MultiplicationEntity>)

    @Query("DELETE FROM multiplication_table")
    suspend fun deleteAllMultiplications()
}