package com.jdlstudios.multiplicaciones.domain.model

import android.os.Parcelable
import com.jdlstudios.multiplicaciones.data.database.entities.MultiplicationEntity
import com.jdlstudios.multiplicaciones.data.model.MultiplicationModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Multiplication(
    val factor1: Int,
    val factor2: Int,
    val result: Int
) : Parcelable

fun MultiplicationModel.toDomain() = Multiplication(factor1, factor2, result)

fun MultiplicationEntity.toDomain() = Multiplication(factor1, factor2, result)