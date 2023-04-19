package com.jdlstudios.multiplicaciones.domain.usescases

import com.jdlstudios.multiplicaciones.data.database.entities.MultiplicationSessionEntity
import com.jdlstudios.multiplicaciones.data.repository.SessionRepository
import javax.inject.Inject

class GetSessionUseCase @Inject constructor(
    private val repository: SessionRepository
) {

    suspend fun getList(): List<MultiplicationSessionEntity>{
        return repository.getListSessionDataBase()
    }

    suspend fun getSessionWithID(id: Long): MultiplicationSessionEntity {
        return repository.getSessionFromDatabase(id)!!
    }

}