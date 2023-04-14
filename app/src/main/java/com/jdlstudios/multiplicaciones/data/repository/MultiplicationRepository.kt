package com.jdlstudios.multiplicaciones.data.repository

import com.jdlstudios.multiplicaciones.data.database.dao.MultiplicationDao
import com.jdlstudios.multiplicaciones.data.database.entities.MultiplicationEntity
import com.jdlstudios.multiplicaciones.data.model.MultiplicationModel
import com.jdlstudios.multiplicaciones.data.model.MultiplicationProvider
import com.jdlstudios.multiplicaciones.domain.model.Multiplication
import com.jdlstudios.multiplicaciones.domain.model.toDomain
import javax.inject.Inject

class MultiplicationRepository @Inject constructor(
    private val multiplicationDao: MultiplicationDao
) {

    fun getMultiplication(): Multiplication {
        val response: MultiplicationModel = MultiplicationProvider.randomMultiplication()
        return response.toDomain()
    }

    suspend fun getMultiplicationFromDatabase(): List<Multiplication> {
        val response = multiplicationDao.getAllMultiplications()
        return response.map { it.toDomain() }
    }

    suspend fun insertMultiplications(multiplications: List<MultiplicationEntity>){
        multiplicationDao.insertAll(multiplications)
    }

    suspend fun clearMultiplications() {
        multiplicationDao.deleteAllMultiplications()
    }
}