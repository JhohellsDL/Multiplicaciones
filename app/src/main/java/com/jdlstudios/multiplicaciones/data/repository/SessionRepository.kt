package com.jdlstudios.multiplicaciones.data.repository

import com.jdlstudios.multiplicaciones.data.database.dao.MultiplicationSessionDao
import com.jdlstudios.multiplicaciones.data.database.entities.MultiplicationSessionEntity
import javax.inject.Inject

class SessionRepository @Inject constructor(
    private val multiplicationSessionDao: MultiplicationSessionDao
) {

    suspend fun getListSessionDataBase(): List<MultiplicationSessionEntity> {
        return multiplicationSessionDao.getAllSessions()
    }

    suspend fun getSessionFromDatabase(id: Long): MultiplicationSessionEntity? {
        return multiplicationSessionDao.getSessionById(id)
    }

    suspend fun insertSession(session: MultiplicationSessionEntity) {
        multiplicationSessionDao.insertSession(session)
    }

}