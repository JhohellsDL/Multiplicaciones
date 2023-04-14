package com.jdlstudios.multiplicaciones.domain.model

import com.jdlstudios.multiplicaciones.data.database.entities.MultiplicationEntity
import com.jdlstudios.multiplicaciones.data.model.MultiplicationModel

data class Multiplication(
    val factor1: Int,
    val factor2: Int,
    val result: Int
)

fun MultiplicationModel.toDomain() = Multiplication(factor1, factor2, result)

fun MultiplicationEntity.toDomain() = Multiplication(factor1, factor2, result)