package com.jdlstudios.multiplicaciones.domain.usescases

import com.jdlstudios.multiplicaciones.data.database.entities.MultiplicationSessionEntity
import com.jdlstudios.multiplicaciones.data.repository.SessionRepository
import javax.inject.Inject

class InsertSessionUseCase @Inject constructor(
    private val repository: SessionRepository
) {

    suspend operator fun invoke(session: MultiplicationSessionEntity){
        repository.insertSession(session)
    }

}