package com.jdlstudios.multiplicaciones.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jdlstudios.multiplicaciones.data.database.entities.MultiplicationSessionEntity

@Dao
interface MultiplicationSessionDao {

    @Query("SELECT * FROM session_table")
    suspend fun getAllSessions(): List<MultiplicationSessionEntity>

    @Query("SELECT * FROM session_table WHERE id = :id")
    suspend fun getSessionById(id: Long): MultiplicationSessionEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(session: MultiplicationSessionEntity)

    @Query("DELETE FROM session_table")
    suspend fun deleteAllSessions()

}